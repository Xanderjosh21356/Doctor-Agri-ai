package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.model.CropDiagnosis

@Entity(tableName = "diagnoses")
data class DiagnosisEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cropName: String,
    val location: String,
    val problemDescription: String,
    val photoUri: String?,
    val isPhotoClear: Boolean,
    val clarificationNeeded: String?,
    val confidence: Int,
    val isLowConfidence: Boolean,
    val visualObservation: String,
    val diseaseNameEn: String,
    val diseaseNameRw: String,
    val causeExplanation: String,
    val organicRemedy: String,
    val chemicalSolution: String,
    val preventionTips: String,
    val localAgrodealers: String,
    val closingBlessing: String,
    val summaryKinyarwanda: String,
    val firstAidAlternativeMedicine: String = "",
    val firstAidAlternativeMedicineRw: String = "",
    val animalImpact: String? = null,
    val isCrossHost: Boolean = false,
    val timestamp: Long
) {
    fun toDomain(): CropDiagnosis {
        return CropDiagnosis(
            id = id,
            cropName = cropName,
            location = location,
            problemDescription = problemDescription,
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
            closingBlessing = closingBlessing,
            summaryKinyarwanda = summaryKinyarwanda,
            firstAidAlternativeMedicine = firstAidAlternativeMedicine,
            firstAidAlternativeMedicineRw = firstAidAlternativeMedicineRw,
            animalImpact = animalImpact,
            isCrossHost = isCrossHost,
            timestamp = timestamp
        )
    }

    companion object {
        fun fromDomain(domain: CropDiagnosis): DiagnosisEntity {
            return DiagnosisEntity(
                id = domain.id,
                cropName = domain.cropName,
                location = domain.location,
                problemDescription = domain.problemDescription,
                photoUri = domain.photoUri,
                isPhotoClear = domain.isPhotoClear,
                clarificationNeeded = domain.clarificationNeeded,
                confidence = domain.confidence,
                isLowConfidence = domain.isLowConfidence,
                visualObservation = domain.visualObservation,
                diseaseNameEn = domain.diseaseNameEn,
                diseaseNameRw = domain.diseaseNameRw,
                causeExplanation = domain.causeExplanation,
                organicRemedy = domain.organicRemedy,
                chemicalSolution = domain.chemicalSolution,
                preventionTips = domain.preventionTips,
                localAgrodealers = domain.localAgrodealers,
                closingBlessing = domain.closingBlessing,
                summaryKinyarwanda = domain.summaryKinyarwanda,
                firstAidAlternativeMedicine = domain.firstAidAlternativeMedicine,
                firstAidAlternativeMedicineRw = domain.firstAidAlternativeMedicineRw,
                animalImpact = domain.animalImpact,
                isCrossHost = domain.isCrossHost,
                timestamp = domain.timestamp
            )
        }
    }
}
