package com.example.data.remote

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.util.Log
import com.example.BuildConfig
import com.example.data.model.CropDiagnosis
import com.example.data.repository.AgriKnowledgeBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.concurrent.TimeUnit

class GeminiService(private val context: Context) {

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    suspend fun diagnoseCrop(
        photoUri: Uri?,
        cropName: String,
        location: String,
        problemDescription: String
    ): CropDiagnosis = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Throwable) {
            ""
        }

        // Convert photo to base64 if available
        var imageBase64: String? = null
        if (photoUri != null) {
            try {
                val inputStream: InputStream? = context.contentResolver.openInputStream(photoUri)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()
                if (bitmap != null) {
                    val scaledBitmap = scaleDown(bitmap, 1024f)
                    val outputStream = ByteArrayOutputStream()
                    scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream)
                    val byteArray = outputStream.toByteArray()
                    imageBase64 = Base64.encodeToString(byteArray, Base64.NO_WRAP)
                }
            } catch (e: Exception) {
                Log.e("GeminiService", "Error decoding photoUri: ${e.message}")
            }
        }

        // If no API key configured or placeholder key, use knowledgeable offline fallback
        if (apiKey.isBlank() || apiKey == "MY_GEMINI_API_KEY") {
            Log.d("GeminiService", "Using AgriKnowledgeBase fallback (no live API key provided)")
            val match = AgriKnowledgeBase.findMatchingDiagnosis(cropName, problemDescription, location)
            return@withContext match.copy(
                cropName = cropName.ifBlank { match.cropName },
                location = location.ifBlank { match.location },
                problemDescription = problemDescription.ifBlank { match.problemDescription },
                photoUri = photoUri?.toString() ?: match.photoUri
            )
        }

        try {
            val systemPrompt = """
                You are Agri-Doctor AI, an expert agricultural assistant for small-scale farmers and agricultural students in Rwanda and East Africa.
                Your job:
                1. ANALYZE: When a user uploads a photo of a crop or asks about symptoms, identify the plant type (or shared plant-animal condition) and any visible disease, pest, nutrient deficiency, or mycotoxin. Describe what you see clearly.
                2. DIAGNOSE: Give the most likely problem name in both English and Kinyarwanda. Explain the cause in simple terms.
                   - NOTE: If the query or symptoms involve diseases that affect BOTH plants and animals (e.g. Aflatoxicosis/Aspergillus, Fusarium mycotoxicosis, Anthrax pasture cycle, Pseudomonas soft rot & mastitis, Botulism in silage), explain the danger to BOTH crops and livestock in simple terms!
                3. TREAT: Provide practical treatment options:
                   - Immediate First Aid & Alternative Medicine: Urgent homemade first-aid remedy using ingredients already available on an African farm (wood ash, crushed garlic/chili, neem leaves, aloe vera, milk/whey, baking soda, activated charcoal for poisoning, clean salt-water wash, immediate pruning). Explain exact preparation and quick action before buying agrochemicals.
                   - Organic/Home remedy that uses things farmers already have (compost tea, bio-char, crop sanitation)
                   - Low-cost chemical solution or input + EXACT dosage per 20L sprayer (e.g., Dithane M-45 40-50g/20L, Rocket 44 EC 30ml/20L, Kocide 2000 40g/20L, or animal toxin binders)
                   - Prevention tips for next season (certified seeds from RAB/SPF/Tubura, rotation, spacing, livestock shelter hygiene)
                4. LOCALIZE & RECOMMEND PLACES: Explicitly recommend where to buy the pesticides or treatments in Rwanda, including:
                   - Specific local Agrodealer hubs (e.g., Nyabugogo Agrodealer Market, SPF-Ikigega in Musanze, Tubura/One Acre Fund depots, district agrodealers)
                   - Veterinary pharmacies for animal binders or treatments if dual-host
                   - Nearest referral or district hospital (CHUK in Kigali, Ruhengeri Hospital in Musanze, CHUB in Huye, Nyagatare Hospital) in case of accidental pesticide poisoning or human exposure
                   - Mention average prices in Rwandan Francs (RWF)
                5. TONE: Be encouraging, simple, and respectful. No complex jargon. Assume the farmer has basic education.

                Rules:
                - If the photo is unclear, set "isPhotoClear": false and in "clarificationNeeded" ask for a closer photo of the leaf, stem, and whole plant.
                - If you are not 80% sure (confidence < 80), set "isLowConfidence": true and state: "This looks like [Name], but I recommend asking your local agronomist to confirm."
                - Never suggest dangerous unauthorized chemicals or overdose.
                - Always end with: "Urabikora neza. Imana ikomeze ibihingwa byawe." (or "Urabikora neza. Imana ikomeze ibihingwa byawe n'amatungo yawe." if cross-host)

                Return ONLY a valid JSON object with the following keys:
                {
                  "isPhotoClear": true,
                  "clarificationNeeded": null,
                  "confidence": 90,
                  "isLowConfidence": false,
                  "visualObservation": "Description of what is seen on the crop or shared host",
                  "diseaseNameEn": "English Disease / Pest Name",
                  "diseaseNameRw": "Kinyarwanda Name",
                  "causeExplanation": "Simple cause explanation (mention animal impact if cross-host)",
                  "organicRemedy": "Home remedy using everyday materials",
                  "chemicalSolution": "Chemical name + EXACT dosage per 20L sprayer + precautions",
                  "preventionTips": "Prevention tips for next season",
                  "localAgrodealers": "Specific recommended places: Agrodealer shops, Veterinary pharmacies, and District Hospital for emergencies with RWF prices",
                  "firstAidAlternativeMedicine": "Immediate first-aid alternative remedy using farm items (wood ash, chili/garlic, milk, aloe, charcoal, etc.) before agrochemical purchase",
                  "firstAidAlternativeMedicineRw": "Ubutabazi bwa mbere gakondo bwo gutabara igihingwa cyangwa itungo hakoreshejwe ibikoresho byo ku cyaro",
                  "closingBlessing": "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                  "summaryKinyarwanda": "Incamake y'icyo umuhinzi yakora mu Kinyarwanda"
                }
            """.trimIndent()

            val userTextPrompt = """
                Crop name: ${cropName.ifBlank { "Unspecified crop" }}
                Location in Rwanda: ${location.ifBlank { "Rwanda" }}
                Farmer's problem description: ${problemDescription.ifBlank { "Please inspect this plant and diagnose symptoms" }}
            """.trimIndent()

            val partsArray = JSONArray()
            partsArray.put(JSONObject().put("text", userTextPrompt))

            if (imageBase64 != null) {
                val inlineData = JSONObject()
                    .put("mimeType", "image/jpeg")
                    .put("data", imageBase64)
                partsArray.put(JSONObject().put("inlineData", inlineData))
            }

            val contentObj = JSONObject().put("parts", partsArray)
            val contentsArray = JSONArray().put(contentObj)

            val systemInstructionObj = JSONObject().put(
                "parts",
                JSONArray().put(JSONObject().put("text", systemPrompt))
            )

            val generationConfig = JSONObject()
                .put("temperature", 0.2)
                .put("responseMimeType", "application/json")

            val requestJson = JSONObject()
                .put("contents", contentsArray)
                .put("systemInstruction", systemInstructionObj)
                .put("generationConfig", generationConfig)

            val mediaType = "application/json; charset=utf-8".toMediaType()
            val requestBody = requestJson.toString().toRequestBody(mediaType)

            // Supported models: gemini-2.5-flash
            val url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=$apiKey"
            val request = Request.Builder()
                .url(url)
                .post(requestBody)
                .build()

            val response = client.newCall(request).execute()
            val responseBody = response.body?.string()

            if (response.isSuccessful && !responseBody.isNullOrBlank()) {
                val parsed = parseGeminiResponse(responseBody, cropName, location, problemDescription, photoUri?.toString())
                if (parsed != null) {
                    return@withContext parsed
                }
            } else {
                Log.w("GeminiService", "Gemini call unsuccessful code=${response.code}: $responseBody")
            }
        } catch (e: Exception) {
            Log.e("GeminiService", "Exception during Gemini API call: ${e.message}", e)
        }

        // Fallback on knowledge base
        val fallback = AgriKnowledgeBase.findMatchingDiagnosis(cropName, problemDescription, location)
        fallback.copy(
            cropName = cropName.ifBlank { fallback.cropName },
            location = location.ifBlank { fallback.location },
            problemDescription = problemDescription.ifBlank { fallback.problemDescription },
            photoUri = photoUri?.toString() ?: fallback.photoUri
        )
    }

    private fun parseGeminiResponse(
        jsonString: String,
        inputCrop: String,
        inputLocation: String,
        inputDesc: String,
        photoUri: String?
    ): CropDiagnosis? {
        try {
            val root = JSONObject(jsonString)
            val candidates = root.optJSONArray("candidates") ?: return null
            if (candidates.length() == 0) return null
            val firstCandidate = candidates.getJSONObject(0)
            val content = firstCandidate.optJSONObject("content") ?: return null
            val parts = content.optJSONArray("parts") ?: return null
            if (parts.length() == 0) return null

            var textResponse = parts.getJSONObject(0).optString("text", "")
            if (textResponse.isBlank()) return null

            // Clean json markdown wrappers if any
            textResponse = textResponse.trim()
            if (textResponse.startsWith("```json")) {
                textResponse = textResponse.removePrefix("```json").trim()
            }
            if (textResponse.startsWith("```")) {
                textResponse = textResponse.removePrefix("```").trim()
            }
            if (textResponse.endsWith("```")) {
                textResponse = textResponse.removeSuffix("```").trim()
            }

            val data = JSONObject(textResponse)
            val isPhotoClear = data.optBoolean("isPhotoClear", true)
            val clarificationNeeded = if (data.isNull("clarificationNeeded")) null else data.optString("clarificationNeeded")
            val confidence = data.optInt("confidence", 85)
            val isLowConfidence = data.optBoolean("isLowConfidence", confidence < 80)
            val visualObservation = data.optString("visualObservation", "Symptoms observed on plant leaf and foliage.")
            val diseaseNameEn = data.optString("diseaseNameEn", "Crop Plant Condition")
            val diseaseNameRw = data.optString("diseaseNameRw", "Indwara y'Ibihingwa")
            val causeExplanation = data.optString("causeExplanation", "Fungal or pest pressure in the field.")
            val organicRemedy = data.optString("organicRemedy", "Apply wood ash and remove severely infected leaves.")
            val chemicalSolution = data.optString("chemicalSolution", "Low-cost fungicide or pesticide with exact 20L sprayer dosage.")
            val preventionTips = data.optString("preventionTips", "Crop rotation and certified seed.")
            val localAgrodealers = data.optString("localAgrodealers", "Local Agrodealer shops in your district.")
            val firstAidAlternativeMedicine = data.optString("firstAidAlternativeMedicine", "")
            val firstAidAlternativeMedicineRw = data.optString("firstAidAlternativeMedicineRw", "")
            var closingBlessing = data.optString("closingBlessing", "Urabikora neza. Imana ikomeze ibihingwa byawe.")
            if (!closingBlessing.contains("Urabikora neza. Imana ikomeze ibihingwa byawe.")) {
                closingBlessing = "$closingBlessing\nUrabikora neza. Imana ikomeze ibihingwa byawe."
            }
            val summaryKinyarwanda = data.optString("summaryKinyarwanda", "")

            return CropDiagnosis(
                cropName = inputCrop.ifBlank { "Analyzed Crop" },
                location = inputLocation.ifBlank { "Rwanda" },
                problemDescription = inputDesc,
                photoUri = photoUri,
                isPhotoClear = isPhotoClear,
                clarificationNeeded = clarificationNeeded,
                confidence = confidence,
                isLowConfidence = isLowConfidence,
                visualObservation = visualObservation,
                diseaseNameEn = diseaseNameEn,
                diseaseNameRw = diseaseNameRw,
                causeExplanation = causeExplanation,
                organicRemedy = organicRemedy,
                chemicalSolution = chemicalSolution,
                preventionTips = preventionTips,
                localAgrodealers = localAgrodealers,
                firstAidAlternativeMedicine = firstAidAlternativeMedicine,
                firstAidAlternativeMedicineRw = firstAidAlternativeMedicineRw,
                closingBlessing = closingBlessing,
                summaryKinyarwanda = summaryKinyarwanda
            )
        } catch (e: Exception) {
            Log.e("GeminiService", "Failed to parse Gemini JSON: ${e.message}")
            return null
        }
    }

    private fun scaleDown(realImage: Bitmap, maxImageSize: Float): Bitmap {
        val maxDim = maxOf(realImage.width, realImage.height).toFloat()
        if (maxDim <= maxImageSize) return realImage
        val ratio = maxImageSize / maxDim
        val width = (ratio * realImage.width).toInt().coerceAtLeast(1)
        val height = (ratio * realImage.height).toInt().coerceAtLeast(1)
        return Bitmap.createScaledBitmap(realImage, width, height, true)
    }
}
