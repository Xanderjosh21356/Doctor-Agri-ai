package com.example.ui

import android.app.Application
import android.content.Context
import android.net.Uri
import android.speech.tts.TextToSpeech
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AgriDatabase
import com.example.data.local.DiagnosisEntity
import com.example.data.model.CenterType
import com.example.data.model.CropDiagnosis
import com.example.data.model.CrossHostDisease
import com.example.data.remote.GeminiService
import com.example.data.repository.AgriKnowledgeBase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale

data class AgriDoctorUiState(
    val selectedPhotoUri: Uri? = null,
    val selectedCrop: String = "Maize (Ibigori)",
    val selectedLocation: String = "Musanze, Northern Province",
    val problemDescription: String = "",
    val isDiagnosing: Boolean = false,
    val currentDiagnosis: CropDiagnosis? = null,
    val history: List<CropDiagnosis> = emptyList(),
    val language: AppLanguage = AppLanguage.ENGLISH,
    val isKinyarwandaFocus: Boolean = false,
    val isDarkMode: Boolean = false,
    val isSpeaking: Boolean = false,
    val infoMessage: String? = null,
    val showPlacesDialog: Boolean = false,
    val showStudyDialog: Boolean = false,
    val selectedCenterType: CenterType? = null,
    val centerSearchQuery: String = "",
    val crossHostSearchQuery: String = ""
)

enum class AppLanguage {
    ENGLISH,
    KINYARWANDA
}

class AgriDoctorViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AgriDatabase.getDatabase(application)
    private val dao = db.diagnosisDao()
    private val geminiService = GeminiService(application)

    private val _uiState = MutableStateFlow(AgriDoctorUiState())
    val uiState: StateFlow<AgriDoctorUiState> = _uiState.asStateFlow()

    private var tts: TextToSpeech? = null
    private var isTtsInitialized = false

    init {
        // Collect history from Room
        viewModelScope.launch {
            dao.getAllDiagnoses().collect { entities ->
                val domainList = entities.map { it.toDomain() }
                _uiState.update { it.copy(history = domainList) }
            }
        }

        // Initialize TTS
        tts = TextToSpeech(application) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.ENGLISH
                isTtsInitialized = true
            }
        }
    }

    fun onPhotoSelected(uri: Uri?) {
        _uiState.update { it.copy(selectedPhotoUri = uri) }
    }

    fun onCropChanged(crop: String) {
        _uiState.update { it.copy(selectedCrop = crop) }
    }

    fun onLocationChanged(location: String) {
        _uiState.update { it.copy(selectedLocation = location) }
    }

    fun onProblemDescriptionChanged(desc: String) {
        _uiState.update { it.copy(problemDescription = desc) }
    }

    fun setLanguage(lang: AppLanguage) {
        _uiState.update { it.copy(language = lang, isKinyarwandaFocus = (lang == AppLanguage.KINYARWANDA)) }
    }

    fun toggleLanguage() {
        val next = if (_uiState.value.language == AppLanguage.ENGLISH) AppLanguage.KINYARWANDA else AppLanguage.ENGLISH
        setLanguage(next)
    }

    fun toggleLanguageFocus() {
        toggleLanguage()
    }

    fun toggleDarkMode() {
        _uiState.update { it.copy(isDarkMode = !it.isDarkMode) }
    }

    fun setDarkMode(dark: Boolean) {
        _uiState.update { it.copy(isDarkMode = dark) }
    }

    fun openPlacesDialog(type: CenterType? = null) {
        _uiState.update { it.copy(showPlacesDialog = true, selectedCenterType = type) }
    }

    fun closePlacesDialog() {
        _uiState.update { it.copy(showPlacesDialog = false) }
    }

    fun openStudyDialog() {
        _uiState.update { it.copy(showStudyDialog = true) }
    }

    fun closeStudyDialog() {
        _uiState.update { it.copy(showStudyDialog = false) }
    }

    fun onCenterSearchQueryChanged(q: String) {
        _uiState.update { it.copy(centerSearchQuery = q) }
    }

    fun onCenterTypeSelected(type: CenterType?) {
        _uiState.update { it.copy(selectedCenterType = type) }
    }

    fun onCrossHostSearchQueryChanged(q: String) {
        _uiState.update { it.copy(crossHostSearchQuery = q) }
    }

    fun loadCrossHostStudyItem(disease: CrossHostDisease) {
        val crossDiagnosis = CropDiagnosis(
            cropName = "${disease.nameEn} (Plant & Animal Shared)",
            location = "Rwanda / East Africa",
            problemDescription = "Plant symptoms: ${disease.plantSymptoms}\nAnimal symptoms: ${disease.animalSymptoms}",
            photoUri = null,
            isPhotoClear = true,
            confidence = 96,
            isLowConfidence = false,
            visualObservation = "${disease.plantSymptoms}\n\n[Animal Transmission]: ${disease.crossTransmissionCycle}",
            diseaseNameEn = disease.nameEn,
            diseaseNameRw = disease.nameRw,
            causeExplanation = "${disease.scientificName} (${disease.pathogenCategory}). ${disease.crossTransmissionCycle}",
            organicRemedy = disease.practicalCropTreatment,
            chemicalSolution = "• Plant Solution: ${disease.practicalCropTreatment}\n\n• Animal Remedy & Dosage: ${disease.animalRemedyAndDosage}",
            preventionTips = disease.preventionForNextSeason,
            localAgrodealers = disease.recommendedSuppliersAndHospitals,
            closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe n'amatungo yawe.",
            summaryKinyarwanda = disease.studySummaryRw
        )

        _uiState.update {
            it.copy(
                selectedCrop = disease.nameEn,
                problemDescription = "Plant: ${disease.plantHosts.joinToString(", ")} | Animals: ${disease.animalHosts.joinToString(", ")}",
                currentDiagnosis = crossDiagnosis,
                showStudyDialog = false,
                infoMessage = "Loaded Cross-Kingdom Study: ${disease.nameEn}"
            )
        }
    }

    fun selectSample(sample: CropDiagnosis, sampleUri: Uri?) {
        _uiState.update {
            it.copy(
                selectedCrop = sample.cropName,
                selectedLocation = sample.location,
                problemDescription = sample.problemDescription,
                selectedPhotoUri = sampleUri,
                currentDiagnosis = sample
            )
        }
    }

    fun diagnose() {
        val state = _uiState.value
        _uiState.update { it.copy(isDiagnosing = true, infoMessage = null) }

        viewModelScope.launch {
            try {
                val diagnosis = geminiService.diagnoseCrop(
                    photoUri = state.selectedPhotoUri,
                    cropName = state.selectedCrop,
                    location = state.selectedLocation,
                    problemDescription = state.problemDescription
                )

                // Save automatically into Room history
                val id = dao.insertDiagnosis(DiagnosisEntity.fromDomain(diagnosis))
                val savedDiagnosis = diagnosis.copy(id = id)

                _uiState.update {
                    it.copy(
                        isDiagnosing = false,
                        currentDiagnosis = savedDiagnosis
                    )
                }
            } catch (e: Exception) {
                // Safe fallback to knowledge base
                val fallback = AgriKnowledgeBase.findMatchingDiagnosis(
                    state.selectedCrop,
                    state.problemDescription,
                    state.selectedLocation
                ).copy(
                    cropName = state.selectedCrop,
                    location = state.selectedLocation,
                    problemDescription = state.problemDescription,
                    photoUri = state.selectedPhotoUri?.toString()
                )

                val id = dao.insertDiagnosis(DiagnosisEntity.fromDomain(fallback))
                val saved = fallback.copy(id = id)

                _uiState.update {
                    it.copy(
                        isDiagnosing = false,
                        currentDiagnosis = saved,
                        infoMessage = "Diagnosed using Agri-Doctor East Africa Knowledge Base."
                    )
                }
            }
        }
    }

    fun deleteHistoryItem(id: Long) {
        viewModelScope.launch {
            dao.deleteById(id)
            if (_uiState.value.currentDiagnosis?.id == id) {
                _uiState.update { it.copy(currentDiagnosis = null) }
            }
        }
    }

    fun viewDiagnosis(diagnosis: CropDiagnosis) {
        _uiState.update {
            it.copy(
                currentDiagnosis = diagnosis,
                selectedCrop = diagnosis.cropName,
                selectedLocation = diagnosis.location,
                problemDescription = diagnosis.problemDescription
            )
        }
    }

    fun speakDiagnosis() {
        val diagnosis = _uiState.value.currentDiagnosis ?: return
        if (!isTtsInitialized || tts == null) return

        if (_uiState.value.isSpeaking) {
            stopSpeaking()
            return
        }

        val isKinyarwanda = _uiState.value.language == AppLanguage.KINYARWANDA || _uiState.value.isKinyarwandaFocus
        val speechText = if (isKinyarwanda) {
            val firstAidRw = if (diagnosis.firstAidAlternativeMedicineRw.isNotBlank()) {
                "Ubutabazi bwa mbere gakondo: ${diagnosis.firstAidAlternativeMedicineRw.replace("•", "")}. "
            } else if (diagnosis.firstAidAlternativeMedicine.isNotBlank()) {
                "Ubutabazi bwa mbere: ${diagnosis.firstAidAlternativeMedicine.replace("•", "")}. "
            } else ""

            val summary = if (diagnosis.summaryKinyarwanda.isNotBlank()) diagnosis.summaryKinyarwanda else diagnosis.causeExplanation
            "${diagnosis.diseaseNameRw}. $summary. $firstAidRw ${diagnosis.closingBlessing}"
        } else {
            val firstAidEn = if (diagnosis.firstAidAlternativeMedicine.isNotBlank()) {
                "Immediate First Aid and Alternative Medicine: ${diagnosis.firstAidAlternativeMedicine.replace("•", "")}. "
            } else ""

            "Diagnosis: ${diagnosis.diseaseNameEn}. Kinyarwanda name: ${diagnosis.diseaseNameRw}. " +
            "Cause: ${diagnosis.causeExplanation}. " +
            firstAidEn +
            "Organic remedy: ${diagnosis.organicRemedy.replace("•", "")}. " +
            "Chemical solution: ${diagnosis.chemicalSolution.replace("•", "")}. " +
            "Buy at: ${diagnosis.localAgrodealers}. " +
            diagnosis.closingBlessing
        }

        tts?.speak(speechText, TextToSpeech.QUEUE_FLUSH, null, "agri_doctor_speech")
        _uiState.update { it.copy(isSpeaking = true) }
    }

    fun stopSpeaking() {
        tts?.stop()
        _uiState.update { it.copy(isSpeaking = false) }
    }

    override fun onCleared() {
        super.onCleared()
        tts?.stop()
        tts?.shutdown()
    }
}
