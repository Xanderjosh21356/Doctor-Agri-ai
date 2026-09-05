package com.example.data.repository

import com.example.data.model.CropDiagnosis

object AgriKnowledgeBase {

    val SAMPLE_DIAGNOSES = listOf(
        CropDiagnosis(
            cropName = "Maize (Ibigori)",
            location = "Nyagatare, Eastern Province",
            problemDescription = "Leaves have ragged holes and saw-dust like powder. Small caterpillars inside the funnel.",
            photoUri = "android.resource://com.aistudio.agridoctor.rwnda/drawable/sample_maize_pest",
            isPhotoClear = true,
            clarificationNeeded = null,
            confidence = 94,
            isLowConfidence = false,
            visualObservation = "Clear window-pane feeding marks on whorl leaves and characteristic ragged chewing holes caused by early-to-mid instar larvae.",
            diseaseNameEn = "Fall Armyworm (Spodoptera frugiperda)",
            diseaseNameRw = "Nkongwa Idasanzwe (Nkongwa y'Ibigori)",
            causeExplanation = "A nocturnal moth lays eggs under the leaves. Caterpillars hatch and feed voraciously on the young tender central leaves (the whorl), especially during warm spells.",
            organicRemedy = "• Mix 1 cup of clean, dry wood ash with 1 cup of fine sand and drop a pinch directly into the whorl (funnel) of each attacked plant.\n• Or brew chili-garlic spray: crush 5 hot green/red chilies (piripiri) + 1 bulb of garlic in 2L water with 1 spoon of local soap (Omo/liquid soap); dilute into 10L water and spray in the late afternoon.",
            chemicalSolution = "• Rocket 44 EC (Profenofos 40% + Cypermethrin 4%) or Ampligo 150 ZC.\n• EXACT DOSAGE: Mix 30 ml of Rocket per 20 Litre knapsack sprayer.\n• SAFETY: Spray early morning (before 8 AM) or late evening when caterpillars come out. Wear rubber boots, long sleeves, and a mouth mask. Do not harvest green maize within 14 days of spraying.",
            preventionTips = "• Intercrop maize with desmodium or beans (push-pull method) to repel moths.\n• Plant certified early-maturing hybrid seeds from Tubura (One Acre Fund) or RAB agrodealers.\n• Deep plow fields after harvest to expose resting pupae to birds and sun.",
            localAgrodealers = "Available at licensed Agrodealers in Nyagatare town, Rwimiyaga, or Rukomo. Average price: 2,500 - 3,500 RWF for a 100ml bottle of Rocket.",
            closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
            summaryKinyarwanda = "Iki gihingwa cyatewe na Nkongwa idasanzwe. Shyira ivu mu mutwe w'ikigori cyangwa utere umuti wa Rocket (30ml muri litiro 20 z'amazi). Urabikora neza. Imana ikomeze ibihingwa byawe.",
            firstAidAlternativeMedicine = "• Wood Ash & Sand in Whorl: Sift 1 cup of dry, clean wood ash with 1 cup of fine sand and drop a small pinch directly into the heart (whorl) of each attacked maize plant. The abrasive sand and alkaline ash physically dehydrate and suffocate young armyworms.\n• Pounded Chili & Soap Spray: Crush 5 fiery red chilies (piripiri) + 1 bulb of garlic in 2L water with 1 teaspoon of local bar soap; let steep for 3 hours, filter through a cloth, and spray into the funnel in the late afternoon.",
            firstAidAlternativeMedicineRw = "• Ivu n'Umucanga mu Mutwe w'Ikigori: Vanga igikombe 1 cy'ivu ry'umunyota n'igikombe 1 cy'umusenyi munini, ushye akantu gato mu mutwe w'ikigori. Ivu ryumisha nkongwa vuba igapfa.\n• Umuti w'Urusenda n'Isabune: Sekura piri-piri 5 n'igitoki cya tungurusumu mu mazi ya litiro 2 arimo isabune nkeya, kanyungurure hanyuma utere mu mutwe w'ikigori bugorobye."
        ),
        CropDiagnosis(
            cropName = "Irish Potato (Ibirayi)",
            location = "Musanze, Northern Province",
            problemDescription = "Leaves turned black and water-soaked after the heavy rains. White mold under the leaves.",
            photoUri = "android.resource://com.aistudio.agridoctor.rwnda/drawable/sample_potato_blight",
            isPhotoClear = true,
            clarificationNeeded = null,
            confidence = 96,
            isLowConfidence = false,
            visualObservation = "Large, irregular dark brown/black water-soaked lesions on leaf tips and margins, surrounded by pale yellowish halos, with delicate fungal sporulation on the underside.",
            diseaseNameEn = "Late Blight (Phytophthora infestans)",
            diseaseNameRw = "Miyiridiyu / Imvura yangije ibirayi",
            causeExplanation = "A destructive water-mold fungus that spreads extremely fast in cold, wet, foggy weather typical of volcanic highland soils in Musanze and Nyabihu.",
            organicRemedy = "• Spray compost tea or diluted cow-milk whey (1 part whey or fermented sour milk to 9 parts clean water) as a natural protective bio-fungicide.\n• Immediately cut and remove heavily infected stems and burn them away from the field. Never throw diseased leaves in your compost heap.",
            chemicalSolution = "• Preventive: Dithane M-45 (Mancozeb 80% WP) or Ridomil Gold MZ.\n• EXACT DOSAGE: Measure exactly 50 grams of Dithane M-45 powder per 20 Litre knapsack sprayer (approx. 3 matchbox-fulls).\n• SAFETY: Apply preventive spray every 7-10 days during rainy spells. Ensure even coverage of both top and bottom of leaves. Wear protective face cover.",
            preventionTips = "• Plant certified disease-resistant potato varieties such as Kinigi, Cruza, or Victoria from RAB/SPF-Ikigega.\n• Ensure wide hilling (mounding) of soil around plant stems to prevent spores washing down into tubers.\n• Practice strict 3-year crop rotation with maize or beans.",
            localAgrodealers = "Found at SPF-Ikigega depots, Musanze Central Market Agrodealers, Kinigi agro-shops. Average price: 3,000 - 4,500 RWF per 500g sachet of Mancozeb.",
            closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
            summaryKinyarwanda = "Ibirayi byafashwe n'indwara y'imvura (Miyiridiyu). Fata Dithane M-45 (garama 50 muri pompe ya litiro 20) utere hakiri kare. Urabikora neza. Imana ikomeze ibihingwa byawe.",
            firstAidAlternativeMedicine = "• Milk & Baking Soda Bio-Spray: Mix 1 part fresh milk or fermented whey with 9 parts clean water and 1 tablespoon baking soda (sodium bicarbonate). Spray immediately on tops and undersides of leaves. Sunlight activates milk proteins to create natural antifungal antiseptics.\n• Wood Ash Soil Ridge Dusting: Sprinkle dry wood ash generously over the potato mounds/ridges to create an alkaline protective crust that stops rain from washing fungal spores into underground tubers.",
            firstAidAlternativeMedicineRw = "• Umuti w'Amata na Bicarbonate: Vanga igikombe 1 cy'amata cyangwa urwagwa rw'amata mu bikombe 9 by'amazi wonyereyemo akayiko ka bicarbonate de soude. Bitere ku mababi yose. Izuba rituma amata akora umusemburo wica imiyege.\n• Ivu ku Misozi y'Ibirayi: Minjagirira ivu ryumye ry'umunyota ku butaka buri munsi y'ibirayi ngo imvura itamanura imiyege mu birayi biri munsi."
        )
    )

    fun findMatchingDiagnosis(
        cropName: String,
        description: String,
        location: String
    ): CropDiagnosis {
        val lowerCrop = cropName.lowercase()
        val lowerDesc = description.lowercase()

        // 1. Cross-Kingdom Plant & Animal Diseases
        if (lowerCrop.contains("aflatoxin") || lowerDesc.contains("aflatoxin") || lowerDesc.contains("moldy maize") || lowerDesc.contains("milk drop") || lowerDesc.contains("poultry mortality")) {
            return CropDiagnosis(
                cropName = "Maize & Livestock (Ibigori n'Amatungo)",
                location = location.ifBlank { "Eastern / Southern Province" },
                problemDescription = description.ifBlank { "Olive-green mold on maize cobs; reduced animal milk yield and chick weakness" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 93,
                isLowConfidence = false,
                visualObservation = "Olive-green to yellow powdery Aspergillus mold on maize ear kernels; in livestock, severe hepatotoxicity, reduced feed intake, and drop in milk yield.",
                diseaseNameEn = "Aflatoxicosis (Aspergillus flavus - Plant & Animal Disease)",
                diseaseNameRw = "Uburozi bwa Aflatoxine mu Bigori n'Amatungo",
                causeExplanation = "Aspergillus flavus fungal mold infects maize and groundnuts in damp weather. When moldy grain or stover is fed to cattle or poultry, aflatoxin poisons animal livers and transmits into cow milk (Aflatoxin M1).",
                organicRemedy = "• Bio-control: Apply Aflasafe (10 kg/ha) 2-3 weeks before flowering to displace toxic mold with safe native strains.\n• Rapid Drying: Dry cobs immediately on clean tarpaulins (never on bare soil) to below 13.5% moisture.\n• Sorting: Hand-sort and burn all discolored or broken kernels.",
                chemicalSolution = "• Grain storage: Use hermetic PICS bags (no chemicals needed).\n• Animal Feed Binder: Mix 1% - 2% food-grade Bentonite clay or yeast cell wall glucomannan into animal concentrate (50g-100g/cow daily) to trap toxins in the gut.\n• Veterinary care: Vitamin E + Selenium injectable liver tonic from local vet.",
                preventionTips = "• Never feed moldy grain to dairy cows or poultry.\n• Harvest promptly at maturity; avoid leaving dry cobs in the rain.\n• Store in cool, raised, ventilated granaries.",
                localAgrodealers = "Agrodealers: Aflasafe at RAB stations & Tubura (3,000 RWF/kg); PICS bags at Nyabugogo & Nyagatare Agrodealers (2,000 RWF); Veterinary Pharmacies: Bentonite binders in Musanze & Huye; Emergency Hospital: CHUK or Ruhengeri Hospital (112) for human food poisoning.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe n'amatungo yawe.",
                summaryKinyarwanda = "Aflatoxine ifata ibigori igakora uburozi bwica umwijima w'inka n'inkoko kandi bukajya mu mata. Koresha Aflasafe, ntiwumishirize ku gitaka, kandi koresha imifuka ya PICS. Urabikora neza. Imana ikomeze ibihingwa n'amatungo byawe.",
                firstAidAlternativeMedicine = "• Animal Oral First Aid: Drench poisoned cattle, goats, or pigs with Activated Charcoal powder (50g finely crushed charcoal in 1L clean lukewarm water). Charcoal binds free aflatoxins in the stomach, preventing liver absorption. Also administer 200ml vegetable cooking oil to coat gut lining.\n• Crop First Aid: Immediately transfer moist or warm maize cobs onto raised clean tarpaulins in strong sun; never store moist ears in airtight heaps.",
                firstAidAlternativeMedicineRw = "• Ubutabazi bwa Mbere ku Matungo: Nyuza inka cyangwa ingurube amakara asukuye yaseye (garama 50 mu litiro y'amazi y'akazuyazi). Amakara afata uburozi mu nda ntibugere mu mwijima. Ushobora no kuyiha ibirahuri bibiri by'amavuta yo guteka asanzwe ngo arinde urura.\n• Ku Bigori: Bihute kubikura mu birundo bitose, byanike ku mashitingi ku zuba ryinshi."
            )
        }

        if (lowerCrop.contains("anthrax") || lowerDesc.contains("anthrax") || lowerCrop.contains("uburenge") || lowerDesc.contains("sudden death") || lowerDesc.contains("blood from nose")) {
            return CropDiagnosis(
                cropName = "Pasture Grass & Cattle (Ubwatsi n'Inka)",
                location = location.ifBlank { "Nyagatare / Gatsibo, Eastern Province" },
                problemDescription = description.ifBlank { "Pasture soil contamination and sudden livestock mortality with non-clotting blood" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 95,
                isLowConfidence = false,
                visualObservation = "Low-lying forage grass with soil-encrusted root collars harboring endospores; sudden death of cattle or goats with dark blood oozing from mouth, nose, or anus without rigor mortis.",
                diseaseNameEn = "Anthrax Pasture-Soil-Animal Cycle (Bacillus anthracis)",
                diseaseNameRw = "Uburenge bwa Karande (Bacillus anthracis)",
                causeExplanation = "Bacterial spores survive for decades in pasture soil and adhere to grass stems during floods or droughts. Grazing animals ingest spores with grass roots. Never open dead carcass as air exposure causes vegetative bacteria to form permanent spores in soil.",
                organicRemedy = "• Strict Pasture Quarantine: Immediately fence off low-lying flood pastures and previous burial mounds.\n• Never graze cattle down to root crowns during severe dry seasons.\n• Field sanitation: Deep bury animal remains (at least 2m) covered in quicklime under official veterinary supervision.",
                chemicalSolution = "• DO NOT OPEN CARCASS - Highly contagious to humans and livestock!\n• Animal treatment: High-dose Long-Acting Oxytetracycline (20mg/kg) for in-contact herd mates under veterinary care.\n• Ring Vaccination: Annual RAB Blanthrax spore vaccine for all herd animals.",
                preventionTips = "• Annual mandatory livestock vaccination by RAB.\n• Avoid harvesting fodder grass from historical anthrax burial spots.\n• Report any sudden unexplained animal death to Sector Vet immediately.",
                localAgrodealers = "EMERGENCY: Call RAB Hotline 114 or Sector Veterinary Officer immediately. For human skin sores or fever after handling meat, go urgently to Nyagatare Hospital or nearest District Hospital for emergency ciprofloxacin antibiotics.",
                closingBlessing = "Urabikora neza. Imana ikomeze amatungo n'imirima byanyu.",
                summaryKinyarwanda = "Uburenge bwa Karande ni icyorezo gikomeye kiri mu butaka no ku bwatsi. Bwica inka zikava amaraso adakoma. NTIWIGEZE UBUSHAZA! Hamagara vuba umuganga w'amatungo (RAB 114) n'ibitaro by'akarere. Urabikora neza.",
                firstAidAlternativeMedicine = "• IMMEDIATE FIRST AID SAFETY RULE: STRICT ZERO CUTTING of the dead animal. Air exposure causes spores to multiply.\n• Paddock Quarantine First Aid: Immediately isolate remaining live animals to dry, high-elevation pasture; drench herd mates with boiled garlic and ginger water for basic immune stimulation while awaiting emergency veterinary veterinary dispatch and RAB hotline 114.",
                firstAidAlternativeMedicineRw = "• UBUTABAZI BWIHUSE N'UBWIRINZI: Ntukingure intumbi y'itungo yapfuye na rimwe! Guhura n'umwuka bituma za mikorobe zikora imbuto zidakanguka mu butaka.\n• Ku Matungo Akiri Mazima: Yimurire hejuru ku musozi wumye, uhe amatungo amazi arimo tungurusumu n'urusenda mu gihe umuganga w'amatungo atarahagera (Hamagara 114)."
            )
        }

        if (lowerCrop.contains("fusarium") || lowerDesc.contains("fusarium") || lowerDesc.contains("pink mold") || lowerDesc.contains("pulmonary edema") || lowerDesc.contains("swine")) {
            return CropDiagnosis(
                cropName = "Maize & Pigs/Livestock (Ibigori n'Ingurube)",
                location = location.ifBlank { "Rwamagana / Musanze" },
                problemDescription = description.ifBlank { "Pink cottony mold on maize ear tips; respiratory distress and coughing in pigs" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 91,
                isLowConfidence = false,
                visualObservation = "Pinkish-white fungal mold at maize ear tips and stalk lodging; in pigs, respiratory failure and pulmonary edema caused by Fumonisin mycotoxin.",
                diseaseNameEn = "Fusarium Ear Rot & Swine Pulmonary Toxicosis",
                diseaseNameRw = "Fuzariyumu: Indwara y'Ibigori n'Uburozi mu Ngurube",
                causeExplanation = "Fusarium verticillioides and graminearum fungi attack maize ears through borer damage. Fumonisin toxin causes acute fluid buildup in pig lungs, reproductive failure, and liver damage in cattle.",
                organicRemedy = "• Hand-sort: Remove and burn all pink or cracked kernels before milling or feeding.\n• Chili-Marigold spray: 500g hot pepper + 500g Mexican marigold in 10L soapy water to deter borer moths that vector fungal spores.\n• Animal oral drench: Activated charcoal (1g/kg body weight in water) to bind mycotoxins in animal gut.",
                chemicalSolution = "• Field fungicide: Azoxystrobin + Difenoconazole (Amistar Top 325 SC) at 15 ml per 20L knapsack sprayer applied at silking.\n• Feed binder: Sodium bentonite or esterified glucomannan at 2 kg per tonne of feed.\n• Veterinary diuretic for pigs: Furosemide administered by licensed veterinary officer.",
                preventionTips = "• Deep plow to bury maize residue after harvest.\n• Practice 2-year crop rotation with non-cereal crops (beans, potatoes).\n• Store grain only when fully dry below 13.5% moisture.",
                localAgrodealers = "Agrodealers: Amistar Top & Rocket available at Nyabugogo Agrodealer Hub & Rwamagana Agro-shops (3,500 RWF); Veterinary Pharmacies: Charcoal drench & feed binders in Nyagatare & Huye; Emergency: District Hospital / RAB (114).",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe n'amatungo yawe.",
                summaryKinyarwanda = "Fuzariyumu izana agahu k'iroza ku bigori igakora uburozi bwa Fumonisine bwica ibihaha by'ingurube. Koresha Amistar Top (15ml muri litiro 20) kandi ntugaburire amatungo ibigori bishaje. Urabikora neza.",
                firstAidAlternativeMedicine = "• Swine / Animal First Aid: Instantly stop feeding moldy maize meal. Prepare an oral drench of 1 cup finely ground wood charcoal suspended in 1 liter clean milk or clean water; administer slowly by bottle to neutralize fumonisin absorption.\n• Ear Rot Field First Aid: Spray Mexican Marigold (Muvyuka) steeped tea onto green maize ear silks to ward off fungal-carrying beetles.",
                firstAidAlternativeMedicineRw = "• Ubutabazi ku Ngurube n'Amatungo: Hagarika ako kanya ibiryo bifite agahu k'iroza. Ha itungo amakara asukuye yaseye mu mata cyangwa amazi (igikombe 1 mu litiro y'amazi) ngo anyonze uburozi.\n• Ku Bihingwa: Fata amababi ya Muvyuka uyashyire mu mazi atotere hanyuma uyatere ku busuka bw'ikigori."
            )
        }

        if (lowerCrop.contains("pseudomonas") || lowerDesc.contains("pseudomonas") || lowerDesc.contains("soft rot") || lowerDesc.contains("mastitis") || lowerDesc.contains("amashereka")) {
            return CropDiagnosis(
                cropName = "Vegetables & Dairy Cattle (Imboga n'Inka z'Amata)",
                location = location.ifBlank { "Musanze / Rubavu / Kigali" },
                problemDescription = description.ifBlank { "Water-soaked slimy rot in tomatoes/cabbage; swollen hot udder and watery milk in cows" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 89,
                isLowConfidence = false,
                visualObservation = "Slimy water-soaked bacterial decay of tomato fruits and cabbage heads with foul odor; in cows, severe acute mastitis with swollen painful quarter and brownish watery milk.",
                diseaseNameEn = "Pseudomonas Soft Rot & Bovine Mastitis",
                diseaseNameRw = "Bagiteri ya Sizomonasi (Ububore n'Amashereka)",
                causeExplanation = "Pseudomonas bacteria persist in muddy irrigation water, manure-contaminated soils, and wet stall bedding. Bacteria infect damaged vegetable tissues and enter dairy cow teat canals when cows lie on damp manure.",
                organicRemedy = "• Vegetable beds: Drench soil beds with strained wood ash tea (1kg per 10L water) and improve ridge drainage.\n• Animal stall: Clean manure twice daily; apply dry sawdust or dry sand bedding.\n• Post-milking: Dip cow teats in 0.5% povidone-iodine solution after every milking.",
                chemicalSolution = "• Plant bactericide: Copper Hydroxide (Kocide 2000) at 40 grams per 20 Litre sprayer; spray foliage and stem bases.\n• Animal treatment: Veterinary intramammary antibiotic infusion (Gentamicin/Polymyxin tubes) prescribed by a vet.\n• Discard milk from treated cows for minimum 72 hours.",
                preventionTips = "• Do not use stagnant runoff water for irrigating vegetables or washing milking equipment.\n• Space vegetables generously for aeration.\n• Disinfect milking hands and teat cups between each cow.",
                localAgrodealers = "Agrodealers: Kocide 2000 available at Rubavu & Musanze Agro-shops (4,200 RWF per 250g); Veterinary Pharmacies: Intramammary tubes & iodine teat dips in Nyagatare & Kigali; RAB research stations for milk bacterial culture.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa n'amata byanyu.",
                summaryKinyarwanda = "Sizomonasi iboza imboga n'inyanya ikaba yaninjira mu mabere y'inka z'amata ikazana amashereka arwaye. Koresha Kocide 2000 (40g muri pompe ya litiro 20) kandi usukure amabere y'inka n'ikiraro. Urabikora neza.",
                firstAidAlternativeMedicine = "• Udder First Aid: Clean inflamed cow quarters with warm salt water (2 tablespoons clean cooking salt per 2L warm water). Gently apply crushed Aloe Vera (Igikakarubamba) leaf pulp directly on swollen quarters to cool fever and reduce inflammation.\n• Vegetable Bed First Aid: Dust fine wood ash along the soil collar of vegetables to dry up bacterial slime.",
                firstAidAlternativeMedicineRw = "• Ubutabazi ku Mabere y'Inka: Karaba ibere ryabyimbye ukoresheje amazi ashyushye arimo umunyu usanzwe. Hanyuma sigaho umushongi w'amababi y'Igikakarubamba kuko kigabanya uburibwe n'umuriro w'ibere.\n• Ku Mboga: Minjagira ivu ryumye ku mizi y'imboga ngo ryumishe ububore bwa bagiteri."
            )
        }

        // 2. Single Crop Specific Diagnoses
        if (lowerCrop.contains("potato") || lowerCrop.contains("ibirayi") || lowerCrop.contains("kinigi") || lowerDesc.contains("potato")) {
            return CropDiagnosis(
                cropName = "Irish Potato (Ibirayi)",
                location = location.ifBlank { "Musanze / Northern Province" },
                problemDescription = description.ifBlank { "Dark water-soaked spots on leaves with pale borders" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 88,
                isLowConfidence = false,
                visualObservation = "Dark brown to purplish-black water-soaked lesions developing rapidly along the leaf edges with wilting foliage.",
                diseaseNameEn = "Potato Late Blight (Phytophthora infestans)",
                diseaseNameRw = "Miyiridiyu y'ibirayi (Imvura)",
                causeExplanation = "A fungal-like water pathogen triggered by prolonged leaf wetness, high humidity, and cool highland temperatures.",
                organicRemedy = "• Dissolve 2 tablespoons of baking soda and 1 teaspoon of vegetable oil in 5 liters of water and spray weekly.\n• Prune out early affected lower leaves and hill soil firmly around tubers.",
                chemicalSolution = "• Dithane M-45 (Mancozeb 80% WP) or Ridomil Gold.\n• EXACT DOSAGE: 50 grams (3 matchboxes) per 20L knapsack sprayer.\n• Mix thoroughly in a bucket first before pouring through the sprayer filter.",
                preventionTips = "• Plant clean certified seed potatoes (Kinigi, Victoria) from approved cooperatives (e.g., SPF-Ikigega).\n• Rotate fields: avoid planting potatoes after tomatoes or peppers.",
                localAgrodealers = "Available at Musanze, Nyabihu, Rubavu, and Gicumbi Agrodealers. Price: 3,200 - 4,200 RWF per 500g.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                summaryKinyarwanda = "Miyiridiyu yibasiye ibirayi byawe kubera ubukonje n'imvura. Koresha Dithane M-45 (50g kuri litiro 20). Urabikora neza. Imana ikomeze ibihingwa byawe.",
                firstAidAlternativeMedicine = "• Milk & Baking Soda Bio-Spray: Mix 1 part fresh milk or whey with 9 parts water + 1 tablespoon baking soda (sodium bicarbonate). Spray immediately on tops and undersides of leaves. The milk proteins create natural antiseptics when exposed to sunlight.\n• Wood Ash Barrier: Dust fine wood ash along the soil ridges around potato stems to stop rain from washing fungal spores down to developing tubers.",
                firstAidAlternativeMedicineRw = "• Umuti w'Amata na Bicarbonate: Vanga igikombe 1 cy'amata cyangwa urwagwa rw'amata mu bikombe 9 by'amazi wonyereyemo akayiko ka bicarbonate de soude. Bitere ku mababi yombi kuko amata akora umusemburo wica imiyege.\n• Ivu ku Misozi y'Ibirayi: Minjagirira ivu ryumye ku butaka buri munsi y'ibirayi ngo imvura itamanura imiyege mu birayi."
            )
        }

        if (lowerCrop.contains("bean") || lowerCrop.contains("igishyimbo") || lowerCrop.contains("ibishyimbo")) {
            return CropDiagnosis(
                cropName = "Beans (Ibishyimbo)",
                location = location.ifBlank { "Huye / Southern Province" },
                problemDescription = description.ifBlank { "Dark reddish-brown spots along leaf veins and sunken spots on pods" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 86,
                isLowConfidence = false,
                visualObservation = "Dark brown to brick-red angular lesions along the veins on the underside of bean leaves and circular sunken cankers on bean pods.",
                diseaseNameEn = "Bean Anthracnose (Colletotrichum lindemuthianum)",
                diseaseNameRw = "Ububore bw'ibishyimbo / Ibibara by'amavuta",
                causeExplanation = "A seed-borne fungus that multiplies during cool, rainy weather and splashes from infected soil onto stems and pods.",
                organicRemedy = "• Prepare wood ash slurry: steep 1 kg of sieved wood ash in 10L water for 24 hours, strain through a cloth, and spray on foliage.\n• Avoid working in bean fields while plants are wet to prevent spreading spores.",
                chemicalSolution = "• Mancozeb 80% WP or Copper Oxychloride 50% WP.\n• EXACT DOSAGE: 40 grams per 20 Litre sprayer.\n• Spray at the first sign of vein discoloration; repeat after 10-14 days.",
                preventionTips = "• Never use saved seed from a diseased harvest; buy certified clean seeds from Tubura / RAB.\n• Practice staking for climbing beans (ibishyimbo by'imishingiriro) to improve airflow and dry leaves faster.",
                localAgrodealers = "Found at Agrodealer shops across Huye, Nyanza, Gisagara, and Muhanga. Price: 2,500 - 3,800 RWF per 500g.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                summaryKinyarwanda = "Ububore bw'ibishyimbo bwaterwa n'umwuka ukonje n'imbuto yanduye. Koresha Mancozeb (40g muri litiro 20). Urabikora neza. Imana ikomeze ibihingwa byawe.",
                firstAidAlternativeMedicine = "• Papaya & Tithonia Foliar First Aid: Pound 500g young pawpaw (papaya) leaves + 500g Tithonia diversifolia (Ikirogora) leaves in 5L water. Filter and add 1 teaspoon cooking oil. Spray foliage immediately. The papain enzyme in papaya breaks down fungal cell walls.\n• Fast Air Drying: Stake climbing beans (imishingiriro) right away to lift foliage away from moist soil splashes.",
                firstAidAlternativeMedicineRw = "• Amazi y'Amababi y'Ipapayi n'Ikirogora: Sekura amababi y'ipapayi n'ikirogora mu mazi ya litiro 5, akayungurure wonyereyemo akayiko k'amavuta. Umusemburo w'ipapayi (papain) wica imiyege y'amavuta.\n• Shingirira vuba ibishyimbo by'imishingiriro ngo umwuka wumishe amababi."
            )
        }

        if (lowerCrop.contains("banana") || lowerCrop.contains("igitoki") || lowerCrop.contains("ibitoki") || lowerCrop.contains("urutoki")) {
            return CropDiagnosis(
                cropName = "Banana (Urutoki / Ibitoki)",
                location = location.ifBlank { "Rwamagana / Eastern Province" },
                problemDescription = description.ifBlank { "Yellowing wilted leaves, premature ripening and rotten brown fruit pulp" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 91,
                isLowConfidence = false,
                visualObservation = "Dull yellowing and drooping of leaves, male bud premature drying, and pockets of dark brown bacterial staining inside the fruit fingers.",
                diseaseNameEn = "Banana Bacterial Wilt - BXW (Xanthomonas vasicola)",
                diseaseNameRw = "Kirabiranya y'Urutoki",
                causeExplanation = "A bacterial infection spread by insects visiting the male flower bud, or unsterilized machetes (umuhoro) used during pruning.",
                organicRemedy = "• Debudding: Break off the male flower bud (umutwe w'igitoki) using a forked wooden stick immediately after the last cluster forms—never use a knife!\n• Single Diseased Stem Removal (SDSR): Cut only the infected plant at ground level and sterilize your panga over fire or with jik bleach.",
                chemicalSolution = "• Note: There is NO chemical spray that cures bacterial wilt inside banana vascular tissues.\n• Sanitation Solution: Soak all cutting tools (umuhoro, imbugita) in 1 part JIK bleach to 5 parts water or flame them with fire between every tree.",
                preventionTips = "• Disinfect all tools with fire or bleach before moving between banana mats.\n• Report outbreaks to your Sector Agronomist (Agronome w'Umurenge) for community control.\n• Never move banana suckers from infected fields.",
                localAgrodealers = "Buy JIK disinfectant and farm tools at local hardware and Agrodealer shops in Rwamagana, Kayonza, or Ngoma. Price: 1,200 - 2,000 RWF.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                summaryKinyarwanda = "Kirabiranya y'urutoki ni icyorezo gikomeye. Caho umutwe w'igitoki ukoresheje igiti (udakoresheje umuhoro) kandi utwike ibiti byafashwe. Urabikora neza. Imana ikomeze ibihingwa byawe.",
                firstAidAlternativeMedicine = "• Mechanical Debudding First Aid: Instantly snap off the male bud (umutwe w'igitoki) with a forked stick (forked stick only, NO machete) to prevent honeybees and wasps from bringing bacteria from neighbors.\n• Ash & Flame Sterilization: Flame machetes directly in campfire flames until red hot, then pour 2 cups of dry wood ash over the cut banana stump to desiccate and seal bacteria.",
                firstAidAlternativeMedicineRw = "• Guca Umutwe w'Igitoki n'Igiti: Caho umutwe w'igitoki ukoresheje igiti cy'indabyo (ntukoreshe icyuma) ngo inzuki zitazana mikorobe zivuye mu baturanyi.\n• Gutwika Umuhoro no Gusuka Ivu ku Gishyitsi: Cyesha umuhoro mu muriro kugeza uhindutse umutuku, hanyuma usuke ivu ryinshi ry'umunyota ku gishyitsi waciye ngo ryumishe bagiteri."
            )
        }

        if (lowerCrop.contains("cassava") || lowerCrop.contains("imyumbati")) {
            return CropDiagnosis(
                cropName = "Cassava (Imyumbati)",
                location = location.ifBlank { "Bugesera / Eastern Province" },
                problemDescription = description.ifBlank { "Leaves are twisted, wrinkled with green and yellow mosaic patterns" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 90,
                isLowConfidence = false,
                visualObservation = "Severe leaf distortion, stunted plant growth, and bright yellow-green mosaic patterns across the leaf lamina.",
                diseaseNameEn = "Cassava Mosaic Disease - CMD (Begomovirus)",
                diseaseNameRw = "Ububembe bw'imyumbati",
                causeExplanation = "A viral pathogen transmitted by tiny whiteflies (isazi zera) feeding on the sap, and spread through planting infected cassava stem cuttings.",
                organicRemedy = "• Rogueing (Kurandura): Carefully uproot and burn completely any young cassava plant showing twisted mosaic leaves to protect surrounding plants.\n• Spray soapy neem extract to repel whiteflies from young fields.",
                chemicalSolution = "• Virus cannot be killed with fungicides. Target the insect vectors (whiteflies) with Cypermethrin 10% EC if severe.\n• EXACT DOSAGE: 30 ml per 20 Litre knapsack sprayer.\n• Best approach is resistant stems rather than continuous pesticide.",
                preventionTips = "• Plant RAB-certified CMD-resistant cassava varieties (e.g., Gahene, Ndamirabana, Mavumbuka, Bwanacyambwe).\n• Obtain clean disease-free planting stakes from RAB multipliers or recognized farmer cooperatives.",
                localAgrodealers = "Contact local Bugesera, Ruhango, or Kamonyi RAB offices and Agrodealer cooperatives for clean cassava cuttings. Stakes: 1,000 - 2,000 RWF per bundle.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                summaryKinyarwanda = "Ububembe bw'imyumbati buterwa n'isazi zera cyangwa imigozi yanduye. Randura ibirwaye ubitwike, uhinge imigozi yemejwe na RAB. Urabikora neza. Imana ikomeze ibihingwa byawe.",
                firstAidAlternativeMedicine = "• Garlic-Chili Whitefly Repellent: Pound 4 bulbs of garlic + 6 ripe chilies into 2 liters of soapy water; dilute with 10L clean water and spray every 4 days. The pungent sulfur and capsaicin deter whiteflies from feeding and transmitting the mosaic virus.\n• Uproot & Quarantine: Immediately pull out severely curled young plants and dry them away from cassava fields.",
                firstAidAlternativeMedicineRw = "• Umuti w'Urusenda na Tungurusumu: Sekura tungurusumu 4 n'urusenda 6 mu mazi arimo isabune nkeya, utere buri minsi 4. Impumuro ikaze yirukana isazi zera zitera ububembe.\n• Randura ako kanya ibiti byazanye amababi agwiriye ubyanike ku mabuye kure y'umurima."
            )
        }

        if (lowerCrop.contains("tomato") || lowerCrop.contains("inyanya")) {
            return CropDiagnosis(
                cropName = "Tomato (Inyanya)",
                location = location.ifBlank { "Rwamagana / Eastern Province" },
                problemDescription = description.ifBlank { "Plant wilts suddenly during the warm day while leaves are still green" },
                photoUri = null,
                isPhotoClear = true,
                confidence = 87,
                isLowConfidence = false,
                visualObservation = "Rapid irreversible daytime wilting of foliage without yellowing; stem vascular strands show brown discoloration when sliced.",
                diseaseNameEn = "Bacterial Wilt (Ralstonia solanacearum)",
                diseaseNameRw = "Urunyuzi rw'inyanya (Gucupira)",
                causeExplanation = "Soil-borne bacteria enter through root wounds or nematodes, clogging water-transporting xylem vessels inside the stem.",
                organicRemedy = "• Drench planting holes with bio-char and well-aged poultry compost before transplanting.\n• Immediately pull out wilting plants with surrounding soil ball into a bucket and remove from field to avoid contaminating irrigation water.",
                chemicalSolution = "• Copper Hydroxide (Kocide 2000) or Mancozeb for foliar protection.\n• EXACT DOSAGE: 40 grams of Kocide 2000 per 20 Litre sprayer.\n• Note: Chemicals cannot cure bacteria once inside the vascular stem; focus on preventive soil drainage.",
                preventionTips = "• Rotate with non-solanaceous crops (maize, sorghum, grass, onions) for at least 3 years.\n• Use raised nursery seedbeds with heat-sterilized soil.\n• Avoid flood irrigation that washes bacteria from plant to plant.",
                localAgrodealers = "Available at Agrodealer shops in Rwamagana, Kigali Nyabugogo Agrodealer hub, and Bugesera. Price: 3,500 - 5,000 RWF per tin.",
                closingBlessing = "Urabikora neza. Imana ikomeze ibihingwa byawe.",
                summaryKinyarwanda = "Urunyuzi rw'inyanya rwatewe na bagiteri zo mu butaka. Randura ibirwaye ubikure mu murima, uhinduranye n'ibigori cyangwa ibitunguru. Urabikora neza. Imana ikomeze ibihingwa byawe.",
                firstAidAlternativeMedicine = "• Wood Ash & Marigold Root Drench: Steep 1kg wood ash and 500g chopped Mexican Marigold (Muvyuka) leaves in 10L water for 12 hours. Pour 2 cups into the root soil of all neighboring healthy plants to form an antibacterial boundary.\n• Soil Containment: Dig a 15cm isolation trench around diseased tomato plants to stop irrigation water from washing bacteria to healthy rows.",
                firstAidAlternativeMedicineRw = "• Amazi y'Ivu na Muvyuka ku Mizi: Shyira ikilo 1 cy'ivu n'amababi ya Muvyuka mu mazi ya litiro 10 amaseha 12. Sukaho ibikombe bibiri ku mizi y'inyanya zikiri nzima zegeranye n'izarwaye.\n• Cukura akuferege gato gakikije inyanya zirwaye ngo amazi yo kuhira atandukiza izindi."
            )
        }

        // Default Fall Armyworm / General Maize diagnosis
        return SAMPLE_DIAGNOSES[0].copy(
            cropName = cropName.ifBlank { "Maize (Ibigori)" },
            location = location.ifBlank { "Rwanda / East Africa" },
            problemDescription = description.ifBlank { "Damaged leaves and pest holes observed in crop" }
        )
    }
}
