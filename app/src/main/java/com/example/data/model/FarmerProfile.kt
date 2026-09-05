package com.example.data.model

data class FarmerProfile(
    val fullName: String = "Jean Baptiste Nshimiyimana",
    val phoneNumber: String = "+250 788 456 789",
    val province: String = "Northern Province (Amajyaruguru)",
    val district: String = "Musanze",
    val sector: String = "Kinigi",
    val cell: String = "Bisoke",
    val village: String = "Kagano",
    val primaryCrops: List<String> = listOf("Irish Potatoes (Ibirayi)", "Maize (Ibigori)", "Climbing Beans (Ibishyimbo)"),
    val livestockOwned: List<String> = listOf("Dairy Cattle (Inka 2)", "Goats (Ihene 4)", "Poultry (Inkoko 15)"),
    val farmAreaHectares: Double = 1.5,
    val cooperativeName: String = "COOPAC Kinigi Farmers Union",
    val preferredAgrodealer: String = "Musanze Agri-Supplies & Chemical Depot",
    val preferredVetClinic: String = "Clinique Vétérinaire des Volcans",
    val emergencyVetPhone: String = "+250 788 333 444",
    val farmNotes: String = "Volcanic fertile soil. Prone to potato late blight during rainy season. Cows vaccinated against FMD."
)
