package com.example.data.model

enum class WeatherSeverity {
    DANGER,      // Critical weather/pest threat
    WARNING,     // High risk of fungal/bacterial spread
    ADVISORY,    // Moderate vigilance needed
    FAVORABLE    // Normal favorable farming conditions
}

data class WeatherAlert(
    val id: String,
    val district: String,
    val province: String,
    val tempC: Int,
    val condition: String,
    val conditionRw: String,
    val humidityPercent: Int,
    val rainProbability: Int,
    val windKmh: Int,
    val severity: WeatherSeverity,
    val alertTitleEn: String,
    val alertTitleRw: String,
    val diseaseRiskEn: String,
    val diseaseRiskRw: String,
    val affectedCropsAndAnimals: String,
    val farmingActionEn: String,
    val farmingActionRw: String,
    val forecastPeriod: String
)
