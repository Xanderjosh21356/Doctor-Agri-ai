package com.example.data.repository

import com.example.data.model.CenterType
import com.example.data.model.TreatmentCenter

object TreatmentCentersRepository {

    val CENTERS: List<TreatmentCenter> = listOf(
        // Kigali / Central Hubs
        TreatmentCenter(
            id = "nyabugogo_agro_hub",
            name = "Nyabugogo Central Agro-Chemical Market",
            localName = "Isoko ry'Imiti y'Ubuhinzi Nyabugogo",
            type = CenterType.AGRODEALER_PESTICIDES,
            district = "Nyarugenge",
            province = "Kigali City",
            address = "Near Nyabugogo Bus Park & Agrodealer Plaza, Kigali",
            phoneNumber = "+250788501234",
            availableSupplies = listOf(
                "Rocket 44 EC (Insecticide)",
                "Dithane M-45 (Mancozeb)",
                "Ridomil Gold MZ",
                "Knapsack Sprayers (Pompe ya litiro 20)",
                "Protective Gear (Masks, Boots, Gloves)"
            ),
            averagePricesRwf = "Rocket 100ml: 2,500 - 3,500 RWF • Dithane 500g: 3,500 RWF • Pompe 20L: 22,000 - 28,000 RWF",
            description = "Main national distribution center for certified agricultural pesticides, fungicides, and spraying equipment in Rwanda.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "chuk_hospital",
            name = "CHUK - University Teaching Hospital of Kigali",
            localName = "Ibitaro Bikuru bya Kaminuza bya Kigali (CHUK)",
            type = CenterType.DISTRICT_HOSPITAL,
            district = "Nyarugenge",
            province = "Kigali City",
            address = "KN 4 Ave, Kigali (Opposite Ministry of Health)",
            phoneNumber = "+250788300112",
            availableSupplies = listOf(
                "Pesticide Poisoning Emergency Unit (SAMU 112)",
                "Atropine & Pralidoxime Antidotes",
                "Skin Chemical Decontamination",
                "Acute Mycotoxicosis Intensive Care"
            ),
            averagePricesRwf = "Emergency Service (RAMA/Mutuelle de Santé accepted)",
            description = "National referral hospital handling acute organophosphate, carbamate pesticide intoxication, and agricultural emergencies. Toll-free 112.",
            isEmergency24h = true
        ),
        TreatmentCenter(
            id = "tubura_one_acre_fund",
            name = "Tubura (One Acre Fund) Input Hubs",
            localName = "Ibiro bya Tubura mu Turere",
            type = CenterType.AGRODEALER_PESTICIDES,
            district = "Nationwide (All 30 Districts)",
            province = "All Provinces",
            address = "Local field distribution depots in all rural sectors",
            phoneNumber = "*654#",
            availableSupplies = listOf(
                "Subsidized Fall Armyworm insecticides",
                "Aflasafe bio-fungicide for maize",
                "Certified hybrid maize and climbing bean seeds",
                "Lime for acidic volcanic/laterite soils",
                "Solar lamps and agricultural safety kits"
            ),
            averagePricesRwf = "Affordable seasonal credit / cash packages at government-subsidized rates",
            description = "Direct-to-farmer input program operating across rural Rwanda with certified agronomic training.",
            isEmergency24h = false
        ),

        // Northern Province (Musanze, Burera, Nyabihu)
        TreatmentCenter(
            id = "spf_ikigega_musanze",
            name = "SPF-Ikigega Seed & Fungicide Center",
            localName = "Ikigo cy'Imbuto n'Imiti cy'Ibirayi - SPF Ikigega",
            type = CenterType.AGRODEALER_PESTICIDES,
            district = "Musanze",
            province = "Northern Province",
            address = "Ruhengeri-Kinigi Road, Musanze Town",
            phoneNumber = "+250788456123",
            availableSupplies = listOf(
                "Dithane M-45 (Mancozeb 80% WP)",
                "Ridomil Gold MZ (Potato Late Blight)",
                "Score 250 EC (Systemic Fungicide)",
                "Certified Seed Potatoes (Kinigi, Cruza)",
                "Sprayer nozzles & repair gaskets"
            ),
            averagePricesRwf = "Dithane 500g: 3,200 - 4,000 RWF • Ridomil 250g: 4,500 RWF • Copper 500g: 4,000 RWF",
            description = "Highland specialist supplier for potato and pyrethrum crops, dealing with volcanic soil blights and bacterial rots.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "ruhengeri_referral_hospital",
            name = "Ruhengeri Referral Hospital",
            localName = "Ibitaro Bikuru bya Ruhengeri",
            type = CenterType.DISTRICT_HOSPITAL,
            district = "Musanze",
            province = "Northern Province",
            address = "RN4, Musanze Town Center",
            phoneNumber = "+250252546222",
            availableSupplies = listOf(
                "Emergency chemical burn unit",
                "Organophosphate antidote administration",
                "Inhalation distress oxygen therapy"
            ),
            averagePricesRwf = "Emergency admissions covered by Mutuelle de Santé / Community Health Insurance",
            description = "Key referral hospital for Northern Province farmers suffering chemical splash, accidental inhalation, or acute fungal illness.",
            isEmergency24h = true
        ),

        // Eastern Province (Nyagatare, Rwamagana, Gatsibo, Kayonza)
        TreatmentCenter(
            id = "nyagatare_agro_vet",
            name = "Nyagatare Agro-Veterinary Center",
            localName = "Agrodealer n'Ubuvuzi bw'Amatungo Nyagatare",
            type = CenterType.VETERINARY_PHARMACY,
            district = "Nyagatare",
            province = "Eastern Province",
            address = "Nyagatare Main Market Commercial Zone",
            phoneNumber = "+250788612345",
            availableSupplies = listOf(
                "Rocket 44 EC & Ampligo (Fall Armyworm)",
                "Acaricides & Tick dip chemicals (Amitraz, Bayticol)",
                "Toxin binders (Bentonite / yeast cell wall for feed)",
                "Oxytetracycline 20% injectable",
                "Maize hermetic storage bags (PICS bags)"
            ),
            averagePricesRwf = "PICS bag: 1,800 - 2,200 RWF • Acaricide 250ml: 5,500 RWF • Toxin binder 1kg: 2,500 RWF",
            description = "Comprehensive supplier serving eastern cattle corridors and maize-growing plains with both crop pesticides and veterinary medicines.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "rab_nyagatare_station",
            name = "RAB Eastern Zone Station (Nyagatare)",
            localName = "Ikigo cya RAB mu Burasirazuba",
            type = CenterType.RAB_RESEARCH_STATION,
            district = "Nyagatare",
            province = "Eastern Province",
            address = "RAB Station Nyagatare, Near RADA offices",
            phoneNumber = "114",
            availableSupplies = listOf(
                "Free crop pest identification & plant clinic",
                "Livestock disease diagnosis & Anthrax surveillance",
                "Certified drought-resistant seed grain supply",
                "Aflasafe biocontrol distribution"
            ),
            averagePricesRwf = "Diagnostic consultations are free of charge by RAB agronomists & vets",
            description = "Official government agricultural research station providing pest outbreaks alerts, free field advice, and plant disease testing.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "nyagatare_district_hospital",
            name = "Nyagatare District Hospital",
            localName = "Ibitaro by'Akarere ka Nyagatare",
            type = CenterType.DISTRICT_HOSPITAL,
            district = "Nyagatare",
            province = "Eastern Province",
            address = "Barija Road, Nyagatare",
            phoneNumber = "+250252565030",
            availableSupplies = listOf(
                "Emergency pesticide antidote center",
                "Zoonotic disease response unit (Anthrax, Rabies)",
                "Decontamination ward"
            ),
            averagePricesRwf = "Emergency healthcare covered by Mutuelle de Santé",
            description = "Primary hospital for Eastern Province handling crop pesticide emergencies and livestock transmission zoonoses.",
            isEmergency24h = true
        ),

        // Southern Province (Huye, Nyanza, Gisagara, Muhanga)
        TreatmentCenter(
            id = "huye_farmers_agrodealer",
            name = "Huye Regional Agrodealers Cooperative",
            localName = "Koperative y'Abacuruzi b'Imiti y'Ubuhinzi Huye",
            type = CenterType.AGRODEALER_PESTICIDES,
            district = "Huye",
            province = "Southern Province",
            address = "Near Huye Modern Market, Butare",
            phoneNumber = "+250788723456",
            availableSupplies = listOf(
                "Copper Oxychloride (Bean Anthracnose)",
                "Mancozeb 80% WP",
                "Neem oil & organic bio-pesticides",
                "Climbing bean support string & trellises",
                "Sprayer nozzles & safety masks"
            ),
            averagePricesRwf = "Copper Oxychloride 500g: 3,500 - 4,500 RWF • Mancozeb 500g: 3,000 RWF",
            description = "Southern hub supplying bean, coffee, and cassava growers with approved fungicides, bactericides, and organic remedies.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "chub_hospital",
            name = "CHUB - University Teaching Hospital of Butare",
            localName = "Ibitaro Bikuru bya Kaminuza bya Butare (CHUB)",
            type = CenterType.DISTRICT_HOSPITAL,
            district = "Huye",
            province = "Southern Province",
            address = "RN1, Butare Town Center",
            phoneNumber = "+250252530555",
            availableSupplies = listOf(
                "Specialized pesticide toxicology ward",
                "Mycotoxin and liver pathology treatment",
                "Severe agricultural trauma & poisoning emergency"
            ),
            averagePricesRwf = "Emergency health covered under insurance / Mutuelle",
            description = "Southern Province premier referral hospital providing comprehensive poisoning treatment and intensive care.",
            isEmergency24h = true
        ),
        TreatmentCenter(
            id = "rab_rubona_station",
            name = "RAB Rubona Research Station",
            localName = "Ikigo cy'Ubushakashatsi ku Buhinzi cya Rubona",
            type = CenterType.RAB_RESEARCH_STATION,
            district = "Huye",
            province = "Southern Province",
            address = "Rubona, Huye District (Off Kigali-Akanyaru Highway)",
            phoneNumber = "114",
            availableSupplies = listOf(
                "National Plant Pathology Laboratory (Laboratwari y'Ibihingwa)",
                "Soil testing & acidity analysis",
                "Clean cassava stem cuttings (CMD/CBSD free)",
                "Bio-fertilizer cultures (Rhizobium for legumes)"
            ),
            averagePricesRwf = "Consultations free; soil testing subsidized (2,000 - 5,000 RWF)",
            description = "Historic agricultural research center with laboratories for identifying difficult crop viruses, fungi, and bacterial blights.",
            isEmergency24h = false
        ),

        // Western Province (Rubavu, Karongi, Rusizi)
        TreatmentCenter(
            id = "rubavu_crossborder_agro",
            name = "Rubavu Horticultural Inputs & Agrodealer",
            localName = "Agrodealer y'Imboga n'Ibihingwa Rubavu",
            type = CenterType.AGRODEALER_PESTICIDES,
            district = "Rubavu",
            province = "Western Province",
            address = "Near Gisenyi Central Market & Border Road",
            phoneNumber = "+250788834567",
            availableSupplies = listOf(
                "Kocide 2000 (Copper Hydroxide bactericide)",
                "Belt SC (Flubendiamide for vegetable pests)",
                "Confidor 200 SL (Aphids & Whiteflies)",
                "Drip irrigation fittings & knapsack sprayers"
            ),
            averagePricesRwf = "Kocide 250g: 4,200 RWF • Confidor 100ml: 3,800 RWF • Belt 50ml: 5,500 RWF",
            description = "Specialized in intensive vegetable and tea crop treatments, offering bactericides for bacterial wilt and insect controls.",
            isEmergency24h = false
        ),
        TreatmentCenter(
            id = "gisenyi_hospital",
            name = "Gisenyi District Hospital",
            localName = "Ibitaro by'Akarere ka Gisenyi",
            type = CenterType.DISTRICT_HOSPITAL,
            district = "Rubavu",
            province = "Western Province",
            address = "Avenue de l'Hôpital, Gisenyi",
            phoneNumber = "+250252540055",
            availableSupplies = listOf(
                "Pesticide poisoning emergency reception",
                "Eye wash & chemical wash-down facilities",
                "Acute toxic exposure stabilized care"
            ),
            averagePricesRwf = "Accepted under Mutuelle de Santé / RAMA",
            description = "Western border emergency facility equipped for rapid stabilization of accidental agrochemical poisoning.",
            isEmergency24h = true
        )
    )

    fun getCentersByType(type: CenterType): List<TreatmentCenter> {
        return CENTERS.filter { it.type == type }
    }

    fun getCentersByDistrict(districtQuery: String): List<TreatmentCenter> {
        val q = districtQuery.lowercase().trim()
        if (q.isBlank()) return CENTERS
        return CENTERS.filter {
            it.district.lowercase().contains(q) ||
            it.province.lowercase().contains(q) ||
            it.name.lowercase().contains(q) ||
            it.localName.lowercase().contains(q)
        }
    }
}
