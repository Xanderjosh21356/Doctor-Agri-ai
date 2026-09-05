package com.example.data.model

data class CropDiagnosis(
    val id: Long = 0,
    val cropName: String,
    val location: String,
    val problemDescription: String,
    val photoUri: String? = null,
    val isPhotoClear: Boolean = true,
    val clarificationNeeded: String? = null,
    val confidence: Int = 85,
    val isLowConfidence: Boolean = false,
    val visualObservation: String,
    val diseaseNameEn: String,
    val diseaseNameRw: String,
    val causeExplanation: String,
    val organicRemedy: String,
    val chemicalSolution: String,
    val preventionTips: String,
    val localAgrodealers: String,
    val closingBlessing: String = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
    val summaryKinyarwanda: String = "",
    val firstAidAlternativeMedicine: String = "",
    val firstAidAlternativeMedicineRw: String = "",
    val animalImpact: String? = null,
    val isCrossHost: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
