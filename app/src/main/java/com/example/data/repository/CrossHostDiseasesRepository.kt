package com.example.data.repository

import com.example.data.model.CrossHostDisease

object CrossHostDiseasesRepository {

    val DISEASES: List<CrossHostDisease> = listOf(
        CrossHostDisease(
            id = "aflatoxin_aspergillus",
            nameEn = "Aflatoxicosis (Aspergillus flavus)",
            nameRw = "Uburozi bwa Aflatoxine (Asiperegirusi)",
            scientificName = "Aspergillus flavus & Aspergillus parasiticus",
            pathogenCategory = "Fungal Mycotoxin (Cross-Kingdom Toxin)",
            plantHosts = listOf("Maize (Ibigori)", "Groundnuts (Ubunyobwa)", "Sorghum (Amasaka)", "Sunflower"),
            animalHosts = listOf("Dairy Cattle (Inka z'amata)", "Poultry/Chickens (Inkoko)", "Pigs (Ingurube)", "Humans"),
            plantSymptoms = "Olive-green to yellow powdery mold growing on maize kernels and cobs while maturing in field or during damp post-harvest storage. Infected groundnut pods show brown internal rotting and bitter taste.",
            animalSymptoms = "In cattle: acute liver failure, sudden drop in milk production, jaundice (yellow mucous membranes), lethargy, and bloody diarrhea. In poultry: high chick mortality, liver hemorrhages, and stunted growth. Toxin transmits into cow milk as Aflatoxin M1.",
            crossTransmissionCycle = "The fungus infects crops in fields through insect feeding punctures or late rains. When farmers feed moldy maize bran, spoiled grains, or silage to animals, aflatoxin B1 bio-accumulates in liver and passes directly into milk and eggs, threatening human family health.",
            practicalCropTreatment = "• Bio-control: Apply Aflasafe (at 10 kg/ha) 2-3 weeks before maize flowering to displace toxic strains with safe native strains.\n• Rapid Drying: Dry harvested maize on tarpaulins (never bare ground) until moisture is below 13.5%.\n• Storage: Use hermetic bags (PICS bags) with no chemical fumigants needed.",
            animalRemedyAndDosage = "• Immediately remove suspected moldy grain from livestock feed.\n• Feed additive binder: Mix 1% - 2% food-grade Bentonite clay or yeast cell wall glucomannan into dairy feed (approx. 50g - 100g per cow daily) to bind toxin in the gut.\n• Veterinary liver tonic: Vitamin E + Selenium injections from local sector vet.",
            recommendedSuppliersAndHospitals = "Buy Aflasafe at RAB Stations (3,000 RWF/kg); PICS bags at Nyabugogo and Nyagatare Agrodealers (2,000 RWF); For severe livestock feed poisoning consult Sector Veterinarian or RAB (114); For human ingestion symptoms report to District Hospital.",
            preventionForNextSeason = "Harvest promptly at physiological maturity, never leave mature cobs standing in rain. Rotate maize with non-susceptible legumes. Discard all discolored, shriveled, or broken kernels.",
            studySummaryRw = "Aflatoxine ni uburozi bukomeye buterwa n'agahu k'uruzori (Aspergillus) ku bigori n'ubunyobwa, bukagira ingaruka zikomeye ku mwijima w'inka n'inkoko kandi bukinjira mu mata. Koresha Aflasafe, ntiwumishirize hasi ku gitaka, kandi ukoreshe imifuka ya PICS."
        ),
        CrossHostDisease(
            id = "fusarium_mycotoxicosis",
            nameEn = "Fusarium Stalk/Ear Rot & Animal Toxicosis",
            nameRw = "Fuzariyumu: Indwara y'Ibigori n'Uburozi mu Matungo",
            scientificName = "Fusarium verticillioides & Fusarium graminearum",
            pathogenCategory = "Fungal Pathogen & Secondary Mycotoxins (Fumonisins & Zearalenone)",
            plantHosts = listOf("Maize (Ibigori)", "Wheat (Ingano)", "Sorghum", "Banana (Panama Wilt strain)"),
            animalHosts = listOf("Pigs (Ingurube)", "Horses/Donkeys", "Cattle (Inka)", "Poultry (Inkoko)"),
            plantSymptoms = "White, light-pink to salmon-red cottony mold on maize ear tips and cracked kernels. Internal pinkish or light purple decay of maize stalks causing lodging (falling over) in wind.",
            animalSymptoms = "In pigs: Pulmonary edema (lungs fill with fluid, severe coughing, frothing at snout, death within 48 hours) caused by Fumonisin. Zearalenone causes swollen vulva, abortion, and reproductive failure in sows. In cattle: feed refusal, reduced rumen motility, and bloody diarrhea.",
            crossTransmissionCycle = "Fusarium thrives in wet harvest conditions and enters ears via stem borers. Stalk residue left on fields serves as winter reservoir. When moldy grain or grain dust is milled into livestock feed, toxins resist heat cooking and poison animal organ systems.",
            practicalCropTreatment = "• Organic: Steep 500g of Mexican marigold (Tagetes) + 500g chili in 10L water with soap and spray against stem borer vectors.\n• Chemical fungicide: Azoxystrobin + Difenoconazole (Amistar Top 325 SC) at 15 ml per 20L sprayer applied at silking.\n• Hand-sorting: Sort and burn all pink-tinted maize kernels.",
            animalRemedyAndDosage = "• Immediate withdrawal of all corn-based feeds.\n• Oral drench: Activated charcoal (1-2 grams per kg body weight mixed in water) to adsorb gastrointestinal toxins.\n• Veterinary diuretic (Furosemide) administered by a veterinarian for pig pulmonary edema.",
            recommendedSuppliersAndHospitals = "Agrodealers in Musanze, Nyabugogo, and Rwamagana stock approved fungicides; Veterinary pharmacies in Nyagatare and Huye stock toxin binders and charcoal drenches; Severe animal distress: Call RAB Hotline 114.",
            preventionForNextSeason = "Deep tillage to bury infected maize stubble. Practice 2-year crop rotation with non-cereal crops like potatoes or beans. Control stalk borer moths early.",
            studySummaryRw = "Fuzariyumu ifata imitwe y'ibigori ikazana agahu k'iroza, igakora uburozi bwa Fumonisine bwica ibihaha by'ingurube n'umwijima w'inka. Wituburira amatungo ibigori bishaje cyangwa birimo iryo bara."
        ),
        CrossHostDisease(
            id = "anthrax_cycle",
            nameEn = "Anthrax Pasture-Soil-Animal Cycle",
            nameRw = "Icyorezo cy'Uburenge bwa Karande (Bacillus anthracis)",
            scientificName = "Bacillus anthracis",
            pathogenCategory = "Spore-Forming Bacterial Pathogen",
            plantHosts = listOf("Pasture Grasses (Ubwatsi bw'amatungo)", "Forage Legumes (Brachiaria, Desmodium)", "Low-grazing vegetation"),
            animalHosts = listOf("Cattle (Inka)", "Goats (Ihene)", "Sheep (Intama)", "Humans (Abantu)"),
            plantSymptoms = "Grasses themselves do not exhibit leaf necrosis, but low-lying pasture leaves and soil-encrusted root crowns harbor highly resistant bacterial endospores. Spores concentrate near the root collar after soil disturbance or drought followed by heavy flash rains.",
            animalSymptoms = "Peracute sudden death in cattle and goats: animal was seemingly healthy hours before and found dead with dark, non-clotting blood oozing from mouth, nostrils, and rectum. Rapid bloating and absence of rigor mortis (stiffening). In humans: severe black necrotic skin ulcers (cutaneous anthrax) or respiratory failure.",
            crossTransmissionCycle = "Endospores survive in soils for over 50 years. During dry spells or overgrazing, livestock graze grasses down to soil level, ingesting spores with forage roots. If an infected animal dies and is illegally slaughtered or opened, millions of vegetative bacilli sporulate in air and permanently infect the pasture soil for decades.",
            practicalCropTreatment = "• Pasture management: Do not allow animals to graze pastures down to root base during drought.\n• Field decontamination: Quarantine contaminated grazing paddocks; apply 5% formaldehyde or quicklime (calcium oxide) to burial site under veterinary supervision.",
            animalRemedyAndDosage = "• DO NOT OPEN THE CARCASS! Opening releases spores into soil.\n• Prophylactic antibiotics: High-dose Long-Acting Oxytetracycline (20 mg/kg) or Penicillin G for in-contact herd mates under veterinary care.\n• Ring Vaccination: Annual RAB Blanthrax / Anthrax spore vaccine for all livestock in endemic sectors.",
            recommendedSuppliersAndHospitals = "EMERGENCY: Immediately notify Sector Veterinary Officer and RAB Hotline (114). If humans handled animal carcass or consumed meat, report immediately to nearest District Hospital (e.g., Nyagatare Hospital or Ruhengeri Hospital) for emergency post-exposure ciprofloxacin.",
            preventionForNextSeason = "Annual mandatory vaccination of livestock. Fence off low-lying flood-prone pastures where previous anthrax cases occurred. Never cut fodder grass from infected gravesites.",
            studySummaryRw = "Uburenge bwa Karande buri mu butaka no ku mizi y'ubwatsi. Bwica inka zitunguranye zikava amaraso adakoma mu mazuru no mu kanwa. NTIWIGEZE UBUSHAZA CYANGWA NGO UBAGE! Hamagara vuba umuganga w'amatungo (RAB 114) n'ibitaro by'akarere."
        ),
        CrossHostDisease(
            id = "pseudomonas_rot_mastitis",
            nameEn = "Pseudomonas Soft Rot & Livestock Mastitis",
            nameRw = "Bagiteri ya Sizomonasi (Ububore bw'imboga n'amashereka)",
            scientificName = "Pseudomonas aeruginosa & Pseudomonas syringae",
            pathogenCategory = "Bacterial Pathogen (Plant Soft Rot / Animal Mastitis)",
            plantHosts = listOf("Tomatoes (Inyanya)", "Onions (Ibitunguru)", "Cabbage (Amashu)", "Lettuce (Salade)"),
            animalHosts = listOf("Dairy Cows (Inka z'amata)", "Goats (Ihene)", "Pigs"),
            plantSymptoms = "Bacterial soft rot: water-soaked slimy brown lesions on tomato fruits, rotting onion neck, and foul-smelling liquefying heads of cabbage. Foliage displays dark water-soaked leaf spots with chlorotic yellow halos.",
            animalSymptoms = "Severe acute clinical mastitis in dairy cows: swollen, hot, painful quarter of the udder with watery, bloody, or purulent foul-smelling milk secretion. High fever, depression, toxemia, and refusal to stand.",
            crossTransmissionCycle = "Pseudomonas thrives in stagnant irrigation water, wet animal stall bedding, and wet soil. Contaminated irrigation wash water transmits bacteria onto vegetable surfaces. When dairy cows lie down in wet mud or manure-covered stalls, bacteria enter the teat orifice, creating severe gangrenous mastitis.",
            practicalCropTreatment = "• Organic: Spray fresh wood ash tea (1 kg per 10L water strained) or neem leaf extract to suppress surface bacterial films.\n• Chemical bactericide: Copper Hydroxide (Kocide 2000) at 40 grams per 20 Litre sprayer; ensure good plant spacing to lower canopy humidity.",
            animalRemedyAndDosage = "• Veterinary care: Intramammary infusion with approved veterinary broad-spectrum antibiotics (Gentamicin / Polymyxin B) as prescribed by vet.\n• Teat dip: Dip teats before and after milking in 0.5% povidone-iodine teat disinfectant solution.\n• Hygiene: Keep stall bedding clean, dry, and elevated.",
            recommendedSuppliersAndHospitals = "Kocide 2000 & Copper bactericides at Rubavu, Musanze, and Nyabugogo Agrodealers; Udder teat dips & intramammary tubes at District Veterinary Pharmacies; Contact RAB Hotline 114 for resistant mastitis sampling.",
            preventionForNextSeason = "Avoid overhead sprinkler irrigation on vegetable crops; disinfect pruning shears with 1:5 bleach solution; concrete or well-drained gravel bedding in cattle sheds.",
            studySummaryRw = "Sizomonasi iboza imboga (inyanya n'amashu) ikaba yaninjira mu mabere y'inka z'amata ikazana amashereka arwaye (mastite). Koresha umuti wa Kocide ku bihingwa kandi usukure neza amabere y'inka n'ikiraro."
        ),
        CrossHostDisease(
            id = "botulism_forage_intoxication",
            nameEn = "Botulism Forage Rot & Animal Paralysis",
            nameRw = "Uburozi bwa Botilisime mu bwatsi n'amatungo",
            scientificName = "Clostridium botulinum",
            pathogenCategory = "Anaerobic Spore-Forming Bacterial Toxin",
            plantHosts = listOf("Silage (Ibyatsi byokeje)", "Hay Bales (Icyatsi cyumye)", "Decaying Grass Residue"),
            animalHosts = listOf("Cattle (Inka)", "Goats (Ihene)", "Poultry (Limberneck in chickens)"),
            plantSymptoms = "Spoiled, blackish, or slimy anaerobic pockets inside silage pits or wrapped round bales with a foul rancid smell instead of sweet fermentation aroma. Decaying vegetation containing trapped carcasses of rodents or birds.",
            animalSymptoms = "Progressive flaccid paralysis in cattle and goats: inability to swallow, protruding tongue, weakness starting in hind legs, recumbency (downer cow), and death by respiratory failure while consciousness remains clear. In chickens: limp neck.",
            crossTransmissionCycle = "Spores naturally present on forage grass multiply anaerobically in poorly sealed silage pits or decaying vegetative compost. The neurotoxin formed in plant matter is among the most potent biological poisons known and paralyzes neuromuscular junctions upon ingestion.",
            practicalCropTreatment = "• Silage sanitation: Ensure strict anaerobic packing and compaction with a clean tractor or drum roller; maintain silage pH below 4.5.\n• Never bale wet forage that cannot dry quickly.\n• Discard and bury any black, slimy, or foul-smelling silage pockets.",
            animalRemedyAndDosage = "• Immediately switch all feed to fresh green elephant grass or clean dry hay.\n• Veterinary administration of Botulinum bivalent/trivalent antitoxin if detected in early stages.\n• Supportive IV fluids and rumen transfaunation by veterinarian.",
            recommendedSuppliersAndHospitals = "Silage inoculants and silage polythene sheeting available at Kigali Nyabugogo and Musanze Agrodealers; Emergency veterinary support via Sector Agronomist or RAB Station.",
            preventionForNextSeason = "Ensure clean cutting of grass at least 5cm above soil to avoid soil contamination. Inspect silage pits thoroughly for small dead animals before sealing.",
            studySummaryRw = "Ibyatsi byoze bibi mu bwatsi bwokeje (silage) bikora uburozi bwa Botilisime bugusha inka hasi zikaremera zigapfa ntizishobore kurya cyangwa kunywa. Wituburira inka ibyatsi byaboze, koresha isaso n'ibyatsi bisukuye."
        ),
        CrossHostDisease(
            id = "ergot_cereal_gangrene",
            nameEn = "Ergot of Cereals & Livestock Gangrene",
            nameRw = "Inzuki y'Ibinyampeke n'Uburozi bw'Amatungo (Ergot)",
            scientificName = "Claviceps purpurea",
            pathogenCategory = "Fungal Sclerotial Toxin (Ergot Alkaloids)",
            plantHosts = listOf("Rye", "Wheat (Ingano)", "Sorghum (Amasaka)", "Forage Grasses (Kikuyu grass, Rye grass)"),
            animalHosts = listOf("Cattle (Inka)", "Sheep (Intama)", "Horses", "Humans (St. Anthony's Fire)"),
            plantSymptoms = "Hard, dark purple-to-black spur-like fungal bodies (sclerotia) resembling rodent droppings that replace grain seeds inside the flower heads of sorghum, wheat, and pasture grasses. In early stages, sticky yellow 'honeydew' droplets drip from florets.",
            animalSymptoms = "Severe vasoconstriction in cattle: gangrene and loss of hooves, ear tips, and tail switch due to reduced blood circulation; lameness, high fever, and extreme heat intolerance (animals stand in water or shade panting continuously).",
            crossTransmissionCycle = "Fungal spores infect cereal flowers during cool, wet spring flowering periods. The fungus turns seeds into hard poisonous sclerotia. When harvested grain is milled with sclerotia or cattle graze flowering pasture grasses, ergot alkaloids cause systemic blood vessel constriction.",
            practicalCropTreatment = "• Certified seed cleaning: Float grain in 20% salt water solution before planting (ergot sclerotia float to surface and are skimmed off).\n• Pasture management: Mow pasture grasses before they produce flowering seed heads.",
            animalRemedyAndDosage = "• Immediately move livestock off infected pastures to cool shaded areas.\n• Provide clean uninfected grass fodder.\n• Veterinary administration of vasodilators and anti-inflammatory medications for lameness.",
            recommendedSuppliersAndHospitals = "Certified seed and seed-cleaning sieves available at SPF-Ikigega and Tubura branches; Veterinary treatment available through RAB district stations.",
            preventionForNextSeason = "Deep plowing (at least 20cm) to bury sclerotia so fungal fruiting bodies cannot reach air; practice 1-year rotation with non-grass crops like potatoes or beans.",
            studySummaryRw = "Inzuki y'ibinyampeke ihindura imbuto z'ingano n'amasaka zikaba umukara nk'imyanda y'imbeba. Iyo inka zibiririye mu bwatsi cyangwa mu binyampeke, amaguru n'amatwi birabora bikagwa kubera kubura amaraso. Gahoza ubwatsi budaye imbuto."
        )
    )

    fun getById(id: String): CrossHostDisease? {
        return DISEASES.find { it.id == id }
    }

    fun searchDiseases(query: String): List<CrossHostDisease> {
        val q = query.lowercase().trim()
        if (q.isBlank()) return DISEASES
        return DISEASES.filter {
            it.nameEn.lowercase().contains(q) ||
            it.nameRw.lowercase().contains(q) ||
            it.plantHosts.any { host -> host.lowercase().contains(q) } ||
            it.animalHosts.any { host -> host.lowercase().contains(q) } ||
            it.pathogenCategory.lowercase().contains(q)
        }
    }
}
