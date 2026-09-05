package com.example.data.model

enum class DiseaseDomain {
    PLANT,
    ANIMAL
}

data class ComprehensiveDisease(
    val id: String,
    val nameEn: String,
    val nameRw: String,
    val scientificOrCausativeAgent: String,
    val domain: DiseaseDomain,
    val affectedHosts: String,
    val causesEn: String,
    val causesRw: String,
    val symptomsEn: String,
    val symptomsRw: String,
    val preventionsEn: String,
    val preventionsRw: String,
    val organicTreatmentsEn: String,
    val organicTreatmentsRw: String,
    val chemicalTreatmentsEn: String,
    val chemicalTreatmentsRw: String,
    val requiredMedicalSupplies: List<String>,
    val regionalPrevalence: String
)
