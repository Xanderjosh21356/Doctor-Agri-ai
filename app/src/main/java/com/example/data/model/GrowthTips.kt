package com.example.data.model

enum class GrowthCategory {
    CROP,
    LIVESTOCK
}

data class GrowthStageStep(
    val stageNumber: Int,
    val stageNameEn: String,
    val stageNameRw: String,
    val durationTextEn: String,
    val durationTextRw: String,
    val descriptionEn: String,
    val descriptionRw: String,
    val keyPracticesEn: List<String>,
    val keyPracticesRw: List<String>,
    val inputSuppliesNeededEn: String,
    val inputSuppliesNeededRw: String,
    val warningOrRisksEn: String,
    val warningOrRisksRw: String
)

data class FarmGrowthGuide(
    val id: String,
    val nameEn: String,
    val nameRw: String,
    val scientificName: String,
    val category: GrowthCategory,
    val seasonOrCycleTextEn: String,
    val seasonOrCycleTextRw: String,
    val generalDescriptionEn: String,
    val generalDescriptionRw: String,
    val optimalZoneRwanda: String,
    val stages: List<GrowthStageStep>,
    val expertTipsEn: String,
    val expertTipsRw: String
)
