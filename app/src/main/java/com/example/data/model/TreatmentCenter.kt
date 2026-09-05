package com.example.data.model

enum class CenterType {
    AGRODEALER_PESTICIDES,      // Pesticides, fungicides, seeds, sprayers
    VETERINARY_PHARMACY,        // Livestock meds, mycotoxin binders, vaccines
    DISTRICT_HOSPITAL,          // Pesticide poisoning, emergency medical care
    RAB_RESEARCH_STATION        // Free diagnostic testing, certification, expert advice
}

data class TreatmentCenter(
    val id: String,
    val name: String,
    val localName: String,
    val type: CenterType,
    val district: String,
    val province: String,
    val address: String,
    val phoneNumber: String,
    val availableSupplies: List<String>,
    val averagePricesRwf: String,
    val description: String,
    val isEmergency24h: Boolean = false
)
