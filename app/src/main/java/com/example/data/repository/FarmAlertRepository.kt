package com.example.data.repository

import com.example.data.model.AlertCategory
import com.example.data.model.FarmAlert

object FarmAlertRepository {

    val INITIAL_ALERTS = listOf(
        FarmAlert(
            id = "alert_1_weather_musanze",
            titleEn = "Heavy Torrential Rain & Fog Warning",
            titleRw = "Impuruza y'Imvura Nyingi n'Igihu",
            messageEn = "Musanze & Nyabihu: 85mm rainfall forecasted over 48 hours with dense cold fog. 95% risk of Potato Late Blight (Miyiridiyu). Apply preventive Dithane M-45 (Mancozeb) before downpours.",
            messageRw = "Musanze na Nyabihu: Hateganyijwe imvura nyinshi ya mm 85 n'igihu gikonje mu masaha 48. Ibirayi bifite ibyago bya 95% bya Miyiridiyu. Fata Dithane M-45 utere hakiri kare.",
            category = AlertCategory.WEATHER,
            severity = "CRITICAL",
            targetDistrict = "Musanze",
            timeFormatted = "10 mins ago",
            actionPromptEn = "View Late Blight Remedy",
            actionPromptRw = "Reba Ubuvuzi bwa Miyiridiyu"
        ),
        FarmAlert(
            id = "alert_2_pest_nyagatare",
            titleEn = "Fall Armyworm (Nkongwa) Outbreak Scouting",
            titleRw = "Impuruza ya Nkongwa Idasanzwe mu Bigori",
            messageEn = "Nyagatare & Gatsibo: Sudden spike in moth flight traps. Inspect central maize whorls for young sawdust frass. Use wood ash + sand or spray Rocket early morning.",
            messageRw = "Nyagatare na Gatsibo: Habonetse ubwiyongere bwa nkongwa y'ibigori. Suzuma imitwe y'ibigori harebwa ivu ry'amasaso. Shyiramo ivu n'umucanga cyangwa utere Rocket mu gitondo.",
            category = AlertCategory.DISEASE_OUTBREAK,
            severity = "HIGH",
            targetDistrict = "Nyagatare",
            timeFormatted = "1 hour ago",
            actionPromptEn = "Armyworm First Aid",
            actionPromptRw = "Ubutabazi bwa Nkongwa"
        ),
        FarmAlert(
            id = "alert_3_vaccine_cattle",
            titleEn = "Mandatory Anthrax & FMD Booster",
            titleRw = "Inkingo Rusange z'Inka (Uburenge na Karande)",
            messageEn = "RAB Veterinary Campaign: Free routine vaccination against Foot & Mouth Disease (Uburenge) and Anthrax is underway in Eastern and Southern grazing corridors. Contact Sector Vet.",
            messageRw = "Gahunda ya RAB: Gukingira inka Uburenge n'Uburenge bwa Karande ku buntu birakomeje mu Turere tw'Iburasirazuba n'Amajyepfo. Hamagara umuganga w'umurenge.",
            category = AlertCategory.VACCINE_REMINDER,
            severity = "HIGH",
            targetDistrict = "All Rwanda",
            timeFormatted = "3 hours ago",
            actionPromptEn = "Find Vet Clinic",
            actionPromptRw = "Shaka Umuganga w'Amatungo"
        ),
        FarmAlert(
            id = "alert_4_growth_fertilizer",
            titleEn = "Season Maize 4-Week Top-Dressing",
            titleRw = "Igihe cyo Gushyiramo Ifumbire ya Urea",
            messageEn = "Maize planted at the start of the season is now knee-high (V6 stage). Apply Urea top-dressing (50 kg/ha) 5cm away from stalks right before expected evening rains.",
            messageRw = "Ibigori byatewe ubu bigeze mu mavi. Shyiramo ifumbire ya Urea (ibiro 50 kuri hegitari) intera ya cm 5 uvuye ku gishyitsi mbere y'imvura ya nimugoroba.",
            category = AlertCategory.GROWTH_STAGE,
            severity = "MEDIUM",
            targetDistrict = "All Rwanda",
            timeFormatted = "5 hours ago",
            actionPromptEn = "Growth Guide",
            actionPromptRw = "Reba Inama z'Iterambere"
        ),
        FarmAlert(
            id = "alert_5_disease_swine",
            titleEn = "African Swine Fever Biosecurity Alert",
            titleRw = "Icyorezo cy'Ingurube (ASF) - Amabwiriza y'Isuku",
            messageEn = "Rwamagana & Bugesera: Strict quarantine on movement of live pigs and pork products. Disinfect footwear before entering pigsties; do not feed kitchen swill.",
            messageRw = "Rwamagana na Bugesera: Kubuza urujya n'uruza rw'ingurube kubera icyorezo. Koresha umuti wica udukoko ku nkweto mbere yo kwinjira mu kiraro; ntukagaburire ingurube ibisigazwa byo mu gikoni bidatetse.",
            category = AlertCategory.DISEASE_OUTBREAK,
            severity = "CRITICAL",
            targetDistrict = "Rwamagana",
            timeFormatted = "Yesterday",
            actionPromptEn = "Biosecurity Steps",
            actionPromptRw = "Amabwiriza y'Ubuziranenge"
        )
    )

    fun getAlertsForDistrict(district: String): List<FarmAlert> {
        return INITIAL_ALERTS.filter {
            it.targetDistrict.equals("All Rwanda", ignoreCase = true) ||
            it.targetDistrict.contains(district, ignoreCase = true)
        }
    }
}
