package com.example.data.repository

import com.example.data.model.WeatherAlert
import com.example.data.model.WeatherSeverity

object WeatherAlertRepository {

    val alerts: List<WeatherAlert> = listOf(
        WeatherAlert(
            id = "alert_musanze_blight",
            district = "Musanze",
            province = "Amajyaruguru (Northern)",
            tempC = 16,
            condition = "Cool & Persistent Drizzle",
            conditionRw = "Imvura y'urujojo n'ubukonje bukabije",
            humidityPercent = 94,
            rainProbability = 88,
            windKmh = 14,
            severity = WeatherSeverity.DANGER,
            alertTitleEn = "CRITICAL: Potato & Tomato Late Blight Outbreak Risk",
            alertTitleRw = "IBYAGO BIHANITSE: Miyiridiyu mu Birayi n'Inyanya",
            diseaseRiskEn = "Continuous relative humidity above 90% and 15-18°C temperature create ideal spores multiplication for Phytophthora infestans (Late Blight). 3-4 consecutive damp days can decimate up to 80% of foliage.",
            diseaseRiskRw = "Ubuhehere buri hejuru ya 90% n'ubukonje bwa 16°C birorohereza agasimba k'indwara ya Miyiridiyu kwirundanya no gutsemba amababi y'ibirayi n'inyanya mu minsi mike.",
            affectedCropsAndAnimals = "Irish Potatoes (Ibirayi - Kinigi/Cruza), Tomatoes, Pyrethrum, Dairy calves",
            farmingActionEn = "Apply protective systemic fungicides (Mancozeb / Ridomil Gold / Dithane M-45) within 24 hours. Ensure drainage furrows around volcanic soil mounds are cleared. Keep calves dry to prevent pneumonia.",
            farmingActionRw = "Fuhira umuti wa Ridomil Gold cyangwa Dithane M-45 bitarenze amasaha 24. Cukura imiyoboro y'amazi mu mirima. Rinda inyana ubukonje n'umusonga.",
            forecastPeriod = "Next 48 Hours • Meteo Rwanda & RAB Agromet Advisory"
        ),
        WeatherAlert(
            id = "alert_nyagatare_drought_pest",
            district = "Nyagatare",
            province = "Iburasirazuba (Eastern)",
            tempC = 29,
            condition = "Hot & Dry Spell",
            conditionRw = "Izuba ryinshi n'ubushyuhe",
            humidityPercent = 42,
            rainProbability = 12,
            windKmh = 22,
            severity = WeatherSeverity.WARNING,
            alertTitleEn = "PEST SURGE: Fall Armyworm & Cassava Whitefly Flare-Up",
            alertTitleRw = "IBURABURIZWA: Inyenzi z'Ibigori (Fall Armyworm) n'Isazi z'imyumbati",
            diseaseRiskEn = "High ambient heat and low humidity cause rapid reproduction of Spodoptera frugiperda in maize funnels. Water-stressed cassava also becomes prone to Cassava Mosaic viral transmission by whiteflies.",
            diseaseRiskRw = "Ubushyuhe bwinshi butuma inyenzi z'ibigori zororoka vuba cyane mu mutima w'ibigori. Imyumbati ibura amazi nayo ifatwa n'ububembe buzanwa n'isazi zera.",
            affectedCropsAndAnimals = "Maize (Ibigori), Cassava (Imyumbati), Beans, Grazing Cattle",
            farmingActionEn = "Inspect maize funnels at dawn. Apply biological neem extracts, wood ash, or registered insecticides (Rocket / Emamectin Benzoate). Ensure cattle have shaded water troughs to avoid heat stress.",
            farmingActionRw = "Suzuma imitima y'ibigori mugitondo cya kare. Sukamo ivu cyangwa umuti wa Roketi / Neem. Ha inka amazi ahagije mu gicucu.",
            forecastPeriod = "Next 3-5 Days • Eastern Savanna Agro-Forecast"
        ),
        WeatherAlert(
            id = "alert_rubavu_downpour",
            district = "Rubavu",
            province = "Iburengerazuba (Western)",
            tempC = 21,
            condition = "Heavy Torrential Rain & Gusts",
            conditionRw = "Imvura y'amahindu n'imiyaga",
            humidityPercent = 89,
            rainProbability = 92,
            windKmh = 28,
            severity = WeatherSeverity.DANGER,
            alertTitleEn = "HIGH RISK: Soil Erosion, Banana Wilt & Coffee Leaf Rust",
            alertTitleRw = "IBYAGO: Isuri, Kirabiranya y'Ibitoki na Rust mu Kawa",
            diseaseRiskEn = "Lake Kivu moisture influx and heavy precipitation increase runoff on steep slopes. High humidity accelerates Hemileia vastatrix (Coffee Rust) and waterlogged Xanthomonas Banana Bacterial Wilt spread.",
            diseaseRiskRw = "Imvura nyinshi ku misozi itera isuri no gutemba kw'amazi. Ubuhehere butera uruhumbu rwa Kawa (Coffee Leaf Rust) no kwihutisha Kirabiranya mu bitoki.",
            affectedCropsAndAnimals = "Coffee (Ikawa), Bananas (Ibitoki), Climbing Beans, Tea",
            farmingActionEn = "Reinforce anti-erosion ditches (amaterasi) with vetiver grass. Disinfect pruning machetes with Jik or fire to halt Banana Wilt. Spray copper-based fungicide on coffee shrubs.",
            farmingActionRw = "Komeza amaterasi n'ingobyi z'imvura uhinga ubwatsi bwa vetiveri. Sukura imihoro n'imikasi ukoresheje Jik cyangwa umuriro mu bitoki.",
            forecastPeriod = "Active Today & Tomorrow • Western Rift Zone"
        ),
        WeatherAlert(
            id = "alert_huye_anthracnose",
            district = "Huye",
            province = "Amajyepfo (Southern)",
            tempC = 23,
            condition = "Humid Afternoon Showers",
            conditionRw = "Ibicucu n'imvura ya nimunsi",
            humidityPercent = 78,
            rainProbability = 65,
            windKmh = 12,
            severity = WeatherSeverity.ADVISORY,
            alertTitleEn = "ADVISORY: Bean Anthracnose & Groundnut Leaf Spot",
            alertTitleRw = "UBURANGAMIRIZWA: Ikirabiranya cy'Ibishyimbo n'Uruhumbu",
            diseaseRiskEn = "Alternating wet and warm conditions favor fungal leaf spot and pod lesions in beans. Stagnant marshland water can also promote Root Rot.",
            diseaseRiskRw = "Guhindagurika kw'izuba n'imvura bitera amabara y'umukara ku mababi n'imiteja y'ibishyimbo mu bishanga no ku misozi.",
            affectedCropsAndAnimals = "Beans (Ibishyimbo), Sweet Potatoes, Pigs & Poultry",
            farmingActionEn = "Avoid walking through or weeding wet bean fields to prevent spores transference on clothes. Ensure raised seedbeds in marshlands (ibishanga).",
            farmingActionRw = "Wirinda gukorera cyangwa kugendera mu bishyimbo bikirihehereye kugira ngo udakwirakwiza uruhumbu. Kora amayugi azamuye mu gishanga.",
            forecastPeriod = "This Week • Southern Plateau Agro-Advisory"
        ),
        WeatherAlert(
            id = "alert_kigali_periurban",
            district = "Kigali",
            province = "Umujyi wa Kigali",
            tempC = 24,
            condition = "Partly Cloudy & Scattered Rain",
            conditionRw = "Ibicucu n'imvura nkeya y'ibitonyanga",
            humidityPercent = 68,
            rainProbability = 40,
            windKmh = 15,
            severity = WeatherSeverity.FAVORABLE,
            alertTitleEn = "FAVORABLE: Optimal Window for Preventive Spraying & Planting",
            alertTitleRw = "IBIHE BYIZA: Umwanya mwiza wo gufuhira no gutera imyaka",
            diseaseRiskEn = "Mild temperatures and moderate wind allow effective chemical/organic application with minimal wash-off risk. Low fungal pressure across peri-urban vegetable plots.",
            diseaseRiskRw = "Ubushyuhe n'umuyaga biri mu rugero. Ni igihe cyiza cyo gutera imiti n'ifumbire idatwarwa n'imvura mu mirima y'imboga n'imbuto.",
            affectedCropsAndAnimals = "Vegetables (Imboga), Fruits, Poultry & Small Ruminants",
            farmingActionEn = "Apply foliar fertilizers and bio-pesticides early morning. Clean poultry coops and inspect greenhouse ventilation to prevent heat buildup.",
            farmingActionRw = "Fuhira ifumbire yo mu mababi mu gitondo. Sukura ibiraro by'inkoko n'amatungo magufi, fungura amadirishya y'inzu z'ubuhinzi (greenhouses).",
            forecastPeriod = "Next 48 Hours • Kigali Agro-Ecosystem"
        )
    )

    fun getAlertForDistrict(district: String): WeatherAlert {
        return alerts.find { it.district.equals(district.trim(), ignoreCase = true) }
            ?: alerts.first()
    }
}
