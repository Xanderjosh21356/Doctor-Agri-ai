package com.example.ui.components

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicNone
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.example.ui.theme.EmeraldGreen
import com.example.ui.theme.GeoPrimary
import java.util.Locale

@Composable
fun VoiceDiagnosisDialog(
    isOpen: Boolean,
    isKinyarwanda: Boolean,
    initialCrop: String = "Maize (Ibigori)",
    onDismiss: () -> Unit,
    onDiagnoseVoice: (recognizedText: String, cropName: String) -> Unit,
    onPlaySampleAudio: (text: String) -> Unit = {}
) {
    if (!isOpen) return

    val context = LocalContext.current
    var spokenText by remember { mutableStateOf("") }
    var selectedCrop by remember { mutableStateOf(initialCrop) }
    var isListening by remember { mutableStateOf(false) }
    var speechStatusText by remember {
        mutableStateOf(
            if (isKinyarwanda) "Kanda kuri mikoro uvuge ibimenyetso by'igihingwa cyangwa itungo..."
            else "Tap the microphone and describe what is happening to your plant or animal..."
        )
    }

    // Microphone audio permission launcher
    var hasAudioPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECORD_AUDIO
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasAudioPermission = granted
        if (granted) {
            speechStatusText = if (isKinyarwanda) "Mikoro iremewe. Kanda utangire kuvuga!" else "Microphone ready. Tap mic to speak!"
        } else {
            speechStatusText = if (isKinyarwanda) "Mikoro ntiyemewe. Shobora kwandika hasi." else "Microphone permission denied. You can type below."
        }
    }

    // Native Speech Recognizer setup
    val speechRecognizer = remember {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            SpeechRecognizer.createSpeechRecognizer(context)
        } else {
            null
        }
    }

    DisposableEffect(speechRecognizer) {
        onDispose {
            try {
                speechRecognizer?.destroy()
            } catch (e: Exception) {
                // ignore
            }
        }
    }

    // Speech Intent Fallback Launcher
    val speechIntentLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        isListening = false
        val data = result.data
        val matches = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
        if (!matches.isNullOrEmpty()) {
            val recognized = matches[0]
            spokenText = recognized
            speechStatusText = if (isKinyarwanda) "Ibyo wavuze byumviswe neza!" else "Speech recognized successfully!"
        }
    }

    fun startListening() {
        if (!hasAudioPermission) {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
            return
        }

        isListening = true
        speechStatusText = if (isKinyarwanda) "Nteze amatwi... Vuga mu Kinyarwanda cyangwa Icyongereza" else "Listening... Describe the disease symptoms clearly"

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, if (isKinyarwanda) "rw-RW" else Locale.getDefault().toLanguageTag())
            putExtra(RecognizerIntent.EXTRA_PROMPT, if (isKinyarwanda) "Vuga ibimenyetso..." else "Speak symptoms...")
        }

        if (speechRecognizer != null) {
            speechRecognizer.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {
                    speechStatusText = if (isKinyarwanda) "Nteze amatwi... Tangira uvuge..." else "Ready! Speak now..."
                }
                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray?) {}
                override fun onEndOfSpeech() {
                    isListening = false
                }
                override fun onError(error: Int) {
                    isListening = false
                    speechStatusText = if (isKinyarwanda) "Ntibyumviswe neza. Gerageza kongera cyangwa ukande ku ngero ziri hasi." else "Could not catch voice clearly. Tap again or choose sample below."
                }
                override fun onResults(results: Bundle?) {
                    isListening = false
                    val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        spokenText = matches[0]
                        speechStatusText = if (isKinyarwanda) "Byumviswe neza!" else "Recognized successfully!"
                    }
                }
                override fun onPartialResults(partialResults: Bundle?) {
                    val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (!matches.isNullOrEmpty()) {
                        spokenText = matches[0]
                    }
                }
                override fun onEvent(eventType: Int, params: Bundle?) {}
            })
            try {
                speechRecognizer.startListening(intent)
            } catch (e: Exception) {
                // Fallback to Intent
                try {
                    speechIntentLauncher.launch(intent)
                } catch (e2: Exception) {
                    isListening = false
                    speechStatusText = if (isKinyarwanda) "Uburyo bw'ijwi ntibubonetse. Koresha ubutumwa bw'urugero hasi." else "Speech service unavailable. Please select a quick sample."
                }
            }
        } else {
            try {
                speechIntentLauncher.launch(intent)
            } catch (e: Exception) {
                isListening = false
                speechStatusText = if (isKinyarwanda) "Koresha ubutumwa bwanditse hasi." else "Please tap one of the quick samples below."
            }
        }
    }

    fun stopListening() {
        isListening = false
        try {
            speechRecognizer?.stopListening()
        } catch (e: Exception) {
            // ignore
        }
    }

    // Animation for pulsing mic ripple
    val infiniteTransition = rememberInfiniteTransition(label = "mic_pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isListening) 1.25f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    val sampleVoiceQueriesRw = listOf(
        Pair("Irish Potatoes (Ibirayi)", "Amababi y'ibirayi yafashwe n'umukara n'igihu cyera munsi y'ibibabi nyuma y'imvura."),
        Pair("Maize (Ibigori)", "Ibigori bifite utwobo twinshi mu mutwe n'ifu nk'amasaso, nkongwa irimo imbere."),
        Pair("Dairy Cattle (Inka)", "Inka ifite umuriro mwinshi, uduheri ku munwa no ku burenge, ntiyabasha kurisha."),
        Pair("Poultry (Inkoko)", "Inkoko zifite ibicurane, zikora umwuka w'ingorane kandi amaso yarabyimbye."),
        Pair("Climbing Beans (Ibishyimbo)", "Ibishyimbo birimo kuzana amabara y'ikigina ku mashami n'amababi akayunguruka.")
    )

    val sampleVoiceQueriesEn = listOf(
        Pair("Irish Potatoes (Ibirayi)", "Potato leaves turned black and water-soaked with white fungal mold underneath after fog."),
        Pair("Maize (Ibigori)", "Ragged holes inside the maize funnel whorl with saw-dust powder from caterpillars."),
        Pair("Dairy Cattle (Inka)", "High fever in dairy cow, blisters around muzzle and hooves, loss of milk production."),
        Pair("Poultry (Inkoko)", "Chicks have respiratory distress, gasping for breath and swollen faces."),
        Pair("Climbing Beans (Ibishyimbo)", "Anthracnose dark brown sunken lesions on bean pods and stems.")
    )

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .testTag("voice_diagnosis_dialog"),
            shape = RoundedCornerShape(24.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = CircleShape,
                            color = GeoPrimary.copy(alpha = 0.15f),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.RecordVoiceOver,
                                    contentDescription = null,
                                    tint = GeoPrimary,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = if (isKinyarwanda) "Gusuzuma ukoresheje Ijwi" else "Voice Diagnosis Assistant",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (isKinyarwanda) "Vuga ibimenyetso n'indwara by'ubuhinzi" else "Speak symptoms in Kinyarwanda or English",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.testTag("close_voice_dialog_btn")
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Target Crop / Livestock Selector
                Text(
                    text = if (isKinyarwanda) "Hitamo igihingwa cyangwa itungo:" else "Select crop or animal:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    listOf("Maize (Ibigori)", "Irish Potatoes (Ibirayi)", "Dairy Cattle (Inka)", "Poultry (Inkoko)").forEach { crop ->
                        val isSel = selectedCrop == crop
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = if (isSel) GeoPrimary else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { selectedCrop = crop }
                        ) {
                            Box(
                                modifier = Modifier.padding(vertical = 6.dp, horizontal = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = crop.split(" ").firstOrNull() ?: crop,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSel) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 10.sp
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Pulsing Center Microphone Button
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    // Outer ripple circle when listening
                    if (isListening) {
                        Box(
                            modifier = Modifier
                                .size(110.dp)
                                .scale(pulseScale)
                                .clip(CircleShape)
                                .background(GeoPrimary.copy(alpha = 0.2f))
                        )
                    }

                    Surface(
                        shape = CircleShape,
                        color = if (isListening) Color(0xFFD32F2F) else GeoPrimary,
                        shadowElevation = 8.dp,
                        modifier = Modifier
                            .size(76.dp)
                            .testTag("voice_mic_record_button")
                            .clickable {
                                if (isListening) stopListening() else startListening()
                            }
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = if (isListening) Icons.Default.GraphicEq else Icons.Default.Mic,
                                contentDescription = if (isListening) "Stop Listening" else "Start Speaking",
                                tint = Color.White,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Status text
                Text(
                    text = speechStatusText,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isListening) GeoPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = if (isListening) FontWeight.Bold else FontWeight.Normal,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Spoken Transcript Box
                OutlinedTextField(
                    value = spokenText,
                    onValueChange = { spokenText = it },
                    label = {
                        Text(if (isKinyarwanda) "Ibyavuzwe n'umuhinzi (Voice Transcript)" else "Transcribed Symptoms")
                    },
                    placeholder = {
                        Text(if (isKinyarwanda) "Ibyo uvuze biraza hano, cyangwa uhitemo urugero hasi..." else "Spoken words will appear here, or tap sample below...")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .testTag("voice_transcript_field"),
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Quick voice sample templates
                Text(
                    text = if (isKinyarwanda) "Urugero rw'ibibazo byo mu ijwi (Quick Samples):" else "Quick Voice Query Samples:",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))

                val sampleList = if (isKinyarwanda) sampleVoiceQueriesRw else sampleVoiceQueriesEn
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    sampleList.take(3).forEach { (crop, text) ->
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedCrop = crop
                                    spokenText = text
                                    speechStatusText = if (isKinyarwanda) "Wahisemo: $crop" else "Selected: $crop"
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.VolumeUp,
                                    contentDescription = null,
                                    tint = GeoPrimary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = crop,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = GeoPrimary,
                                        fontSize = 11.sp
                                    )
                                    Text(
                                        text = text,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontSize = 11.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Action Buttons: Run Diagnosis
                Button(
                    onClick = {
                        if (spokenText.isNotBlank()) {
                            onDiagnoseVoice(spokenText, selectedCrop)
                            onDismiss()
                        }
                    },
                    enabled = spokenText.isNotBlank(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("submit_voice_diagnosis_btn"),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GeoPrimary)
                ) {
                    Icon(imageVector = Icons.Default.Biotech, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (isKinyarwanda) "Suzuma Indwara Ako Kanya (Voice Diagnose)" else "Analyze with Agri-Doctor Voice",
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                TextButton(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (isKinyarwanda) "Hagarika" else "Cancel",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
