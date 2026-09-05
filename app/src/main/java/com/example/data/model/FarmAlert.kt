package com.example.data.model

enum class AlertCategory {
    WEATHER,
    DISEASE_OUTBREAK,
    VACCINE_REMINDER,
    GROWTH_STAGE
}

data class FarmAlert(
    val id: String,
    val titleEn: String,
    val titleRw: String,
    val messageEn: String,
    val messageRw: String,
    val category: AlertCategory,
    val severity: String = "HIGH", // CRITICAL, HIGH, MEDIUM, INFO
    val targetDistrict: String = "All Rwanda",
    val timeFormatted: String = "Just now",
    val actionPromptEn: String = "View Advisory",
    val actionPromptRw: String = "Reba Inama",
    val isRead: Boolean = false,
    val isSystemNotificationSent: Boolean = false
)
