package com.example.data.model

data class CrossHostDisease(
    val id: String,
    val nameEn: String,
    val nameRw: String,
    val scientificName: String,
    val pathogenCategory: String,
    val plantHosts: List<String>,
    val animalHosts: List<String>,
    val plantSymptoms: String,
    val animalSymptoms: String,
    val crossTransmissionCycle: String,
    val practicalCropTreatment: String,
    val animalRemedyAndDosage: String,
    val recommendedSuppliersAndHospitals: String,
    val preventionForNextSeason: String,
    val studySummaryRw: String
)
