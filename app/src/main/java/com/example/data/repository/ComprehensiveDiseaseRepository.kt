package com.example.data.repository

import com.example.data.model.ComprehensiveDisease
import com.example.data.model.DiseaseDomain

object ComprehensiveDiseaseRepository {

    val diseases: List<ComprehensiveDisease> = listOf(
        // ================= PLANT DISEASES =================
        ComprehensiveDisease(
            id = "plant_late_blight",
            nameEn = "Potato & Tomato Late Blight",
            nameRw = "Miyiridiyu mu Birayi n'Inyanya",
            scientificOrCausativeAgent = "Phytophthora infestans (Oomycete pathogen)",
            domain = DiseaseDomain.PLANT,
            affectedHosts = "Irish Potatoes (Ibirayi - Kinigi, Cruza, Victoria), Tomatoes (Inyanya)",
            causesEn = "Airborne sporangia spread rapidly during cool, damp weather with prolonged relative humidity above 90% and temperatures between 12°C and 18°C. Overwintering in infected seed tubers.",
            causesRw = "Imbuto zanduye n'agasimba ka Phytophthora gakwirakwizwa n'umuyaga mu gihe cy'ubukonje buvanze n'ubuhehere bwinshi n'imvura y'urujojo mu birunga.",
            symptomsEn = "Water-soaked dark lesions on leaf tips and margins; delicate white fungal growth visible underneath leaves in morning mist; purplish-brown tuber rot.",
            symptomsRw = "Ibizinga by'umukara ku mpera z'amababi, ubwoya bwera munsi y'amababi mugitondo cy'igihu, no kubora kw'ibirayi mu butaka bibyara impumuro mbi.",
            preventionsEn = "Plant certified clean seeds (e.g., RAB Kinigi or Victoria varieties); practice a minimum 3-year crop rotation; hill volcanic soil up high to protect tubers; avoid overhead irrigation.",
            preventionsRw = "Tera imbuto zizewe z'ubwoko bwa Kinigi cyangwa Cruza; teganya imyaka 3 uhinduranya ibihingwa; sesera ubutaka bwinshi ku birayi kugira ngo amazi atidika.",
            organicTreatmentsEn = "Spray baking soda and potassium bicarbonate solution (5g/L water); copper sulfate bouillie bordelaise (Bordeaux mixture); fermented stinging nettle and Tithonia compost tea.",
            organicTreatmentsRw = "Fuhira umushongi w'amazi arimo soda yo guteka cyangwa umuti w'umuringa (Bouillie Bordelaise); vanga icyenyenyenge n'isununu mu mazi ubifuhire.",
            chemicalTreatmentsEn = "Preventative: Mancozeb 80% WP (Dithane M-45) at 2.5 kg/ha every 7-10 days. Curative systemic: Ridomil Gold (Mefenoxam + Mancozeb) at 2 kg/ha or Acrobat MZ.",
            chemicalTreatmentsRw = "Umuti wo kwirinda: Dithane M-45 (Mancozeb). Umuti wo kuvura igihe yafashwe: Ridomil Gold cyangwa Acrobat MZ ifuhiwe mu masaha ya mugitondo.",
            requiredMedicalSupplies = listOf("Knapsack Sprayer (Pompe)", "Ridomil Gold / Mancozeb powder", "Protective Mask & Nitrile Gloves", "Measuring Cup / Dose spoon"),
            regionalPrevalence = "Northern Province (Musanze, Burera, Nyabihu) & Western Province (Rubavu)"
        ),
        ComprehensiveDisease(
            id = "plant_banana_wilt",
            nameEn = "Banana Bacterial Xanthomonas Wilt (BXW)",
            nameRw = "Kirabiranya y'Ibitoki (BXW)",
            scientificOrCausativeAgent = "Xanthomonas vasicola pv. musacearum (Bacterium)",
            domain = DiseaseDomain.PLANT,
            affectedHosts = "Cooking Bananas (Ibitoki), Beer Bananas (Imyembe), Plantains",
            causesEn = "Transmission via contaminated farm machetes/pruning knives, insect pollinators feeding on male banana flower buds, and infected banana suckers.",
            causesRw = "Gukoresha imihoro n'ibiti byakase igitoki kirwaye utabyoze, inzuki n'isazi zikwirakwiza udukoko mu mutima w'indabyo z'igitoki, n'insina zanduye.",
            symptomsEn = "Progressive yellowing and drooping of leaves resembling drought stress; premature uneven ripening of fruit fingers with internal dark brown bacterial discoloration; yellowish bacterial oozing when pseudostem is cut.",
            symptomsRw = "Amababi ahinduka umuhondo akangirika nk'ayishwe n'amapfa, intoki zihisha imburagihe zikarura imbere, kandi ugatemye insina ubona amashyira y'umuhondo acicikana.",
            preventionsEn = "De-budding: Remove male flower buds immediately using a wooden forked stick (never a metal knife); sterilize all farm tools with fire or bleach/Jik; plant certified clean tissue-culture banana suckers.",
            preventionsRw = "Guhongora umutwe w'igitoki ukoresheje igiti gifite ingobe (ntugakoreshe umuhoro); gushyira ibikoresho mu muriro cyangwa mu mazi arimo Eau de Javel; gutera insina z'isuku.",
            organicTreatmentsEn = "Single Diseased Stem Removal (SDSR): Cut only the visibly affected banana stem at ground level, leave root mat, and apply wood ash on stump. Disinfect cutting machete with 20% household bleach.",
            organicTreatmentsRw = "Uburyo bwa SDSR: Rimbura gusa urusina rugaragaza ibimenyetso uhereye hasi ku butaka, usukemo ivu ryinshi ku gishyitsi, kandi ukojeje umuhoro mu mazi arimo Jik cyangwa umuriro.",
            chemicalTreatmentsEn = "There are no approved chemical antibiotics for field systemic application in Rwanda. Strict phytosanitary sanitation and sodium hypochlorite tool dips are legally required by RAB.",
            chemicalTreatmentsRw = "Nta muti w'amazi wo gufuhira uvura kirabiranya. Itegeko rya RAB ritegeka gusa gukoresha Eau de Javel ku mihoro no gutwika ibisate byanduye.",
            requiredMedicalSupplies = listOf("Disinfectant Jik / Chlorine Bleach", "Forked Debudding Wooden Poles", "Rubber Gloves & Boot Washes"),
            regionalPrevalence = "Eastern Province (Rwamagana, Kayonza) & Western Province (Rubavu, Rusizi)"
        ),
        ComprehensiveDisease(
            id = "plant_maize_necrosis",
            nameEn = "Maize Lethal Necrosis (MLN) & Fall Armyworm",
            nameRw = "Indwara y'Ibigori ya MLN n'Inyenzi (Fall Armyworm)",
            scientificOrCausativeAgent = "Dual viral synergism (MCMV + Potyvirus) & Spodoptera frugiperda",
            domain = DiseaseDomain.PLANT,
            affectedHosts = "Maize (Ibigori), Sorghum (Amasaka), Sweet Corn",
            causesEn = "Viral transmission by maize thrips and chrysomelid beetles combined with voracious night-feeding nocturnal moths laying eggs under leaves in hot seasons.",
            causesRw = "Udukoko tw'isazi n'udusimba two mu butaka dukwirakwiza za virusi, hamwe n'inyenzi ziturika mu birindiro zikarya imitima y'ibigori mu gihe cy'ubushyuhe.",
            symptomsEn = "Mottling and chlorosis starting from the margins of young leaves; premature drying and 'dead-heart'; heavy ragged holes in leaves with characteristic sawdust-like frass in the funnel.",
            symptomsRw = "Amababi abanza kurabirana akazana imirongo y'umuhondo no gucika ibipande; imitima y'ibigori irabora ikazanamo uducungwa n'ibishingwe by'inyenzi.",
            preventionsEn = "Rotate with legumes (beans, soya); observe strict closed planting season (synchronous planting); intercrop with Desmodium (Push-Pull technology).",
            preventionsRw = "Hingana n'ibishyimbo cyangwa soya; tera ku gihe kimwe n'abandi bahinzi bose bo muri ako gace; koresha uburyo bwa Push-Pull uhinga urubingo n'isununu.",
            organicTreatmentsEn = "Pour fine dry wood ash mixed with ground red chili pepper directly inside each maize funnel; spray bio-pesticide neem seed oil extract (50ml in 15L water).",
            organicTreatmentsRw = "Sukamo mu mutima w'ikigori ivu ry'urushishi ruvanze na piripiri iseye; cyangwa ufuhire amazi arimo amavuta y'ibibabi by'inturusu na Neem.",
            chemicalTreatmentsEn = "Spray Rocket 44 EC (Profenofos + Cypermethrin) or Emamectin Benzoate 5% WDG inside whorls when caterpillars are small (<1 cm). Spray early morning or dusk.",
            chemicalTreatmentsRw = "Fuhira umuti wa Rocket 44 EC cyangwa Emamectin Benzoate (Belt/Ampligo) mu mutima w'ikigori mu rukerera cyangwa nimugoroba izuba rirenze.",
            requiredMedicalSupplies = listOf("Rocket 44 EC or Emamectin Benzoate", "Knapsack Sprayer with cone nozzle", "Safety Goggles & Mask"),
            regionalPrevalence = "Eastern Province (Nyagatare, Gatsibo, Kirehe) & Southern Province (Ruhango)"
        ),
        ComprehensiveDisease(
            id = "plant_cassava_mosaic",
            nameEn = "Cassava Mosaic Disease (CMD) & Brown Streak (CBSD)",
            nameRw = "Ububembe n'Imbavuzo mu Myumbati (CMD & CBSD)",
            scientificOrCausativeAgent = "African Cassava Mosaic Begomovirus & CBSV",
            domain = DiseaseDomain.PLANT,
            affectedHosts = "Cassava / Manioc (Imyumbati)",
            causesEn = "Feeding by Whiteflies (Bemisia tabaci) and multiplication through vegetative propagation of symptomless but infected cassava stem cuttings.",
            causesRw = "Isazi zera (Whiteflies) zikwirakwiza virusi mu bihe by'izuba, no gukoresha imyumbati yo gutera yafashwe.",
            symptomsEn = "Severe leaf distortion, wrinkling, asymmetrical chlorotic mosaic patterns; stunted stem growth; hard yellowish necrotic rot inside roots (CBSD).",
            symptomsRw = "Amababi arapfunyarara akaba mato agasa n'ayanduye umuhondo, ibiti by'imyumbati bikagwingira, imizi ikazanamo ibibyimba byirabura biyibora imbere.",
            preventionsEn = "Plant solely RAB-certified virus-free resistant varieties (e.g. Ndamirabana, Gahene, Nsizehabagara); rogue and immediately burn infected young plants.",
            preventionsRw = "Gukoresha imbuto y'imyumbati yemewe n'ikigo cya RAB yihanganira indwara (urugero: Ndamirabana, Gahene); kurandura no gutwika imyumbati igaragaje ububembe.",
            organicTreatmentsEn = "Immediate sanitary roguing of infected plants; companion planting with aromatic repellent herbs like basil and marigold to deter whitefly populations.",
            organicTreatmentsRw = "Kurandura insina n'imyumbati irwaye ako kanya; guhinga hafi y'imirima indabyo zihumura cyane zituma isazi zera zitahagera.",
            chemicalTreatmentsEn = "Insecticidal control of whitefly vectors in nursery multiplication fields using Acetamiprid 20% SP or Imidacloprid 200 SL.",
            chemicalTreatmentsRw = "Kurwanya isazi zera mu mirima y'ingemwe hakoreshejwe Acetamiprid cyangwa Confidor (Imidacloprid).",
            requiredMedicalSupplies = listOf("Certified Cassava Cuttings from RAB", "Acetamiprid Whitefly Insecticide", "Pruning Shears"),
            regionalPrevalence = "Southern Province (Kamonyi, Muhanga, Ruhango) & Bugesera District"
        ),

        // ================= ANIMAL & LIVESTOCK DISEASES =================
        ComprehensiveDisease(
            id = "animal_east_coast_fever",
            nameEn = "East Coast Fever / Theileriosis (ECF)",
            nameRw = "Amakore mu Nka (Theileriosis)",
            scientificOrCausativeAgent = "Theileria parva (Protozoan blood parasite carried by ticks)",
            domain = DiseaseDomain.ANIMAL,
            affectedHosts = "Dairy Cattle (Inka z'inzungu, Inyambo), Calves (Inyana)",
            causesEn = "Bite of the brown ear tick (Rhipicephalus appendiculatus) which thrives in dense unmanaged pastures and overgrown bush during the rainy season.",
            causesRw = "Ukurumwa n'ikizinda (ibishorobwa n'udusimba) two mu mirizo no mu matwi y'inka dukwirakwiza amaraso arimo parasitique mu gihe cy'imvura.",
            symptomsEn = "High fever (40-42°C); severe swelling of the prescapular and parotid lymph nodes (behind ear and in front of shoulder); frothy nasal discharge, heavy breathing, loss of appetite, death within 14 days if untreated.",
            symptomsRw = "Umuriro mwinshi urenze 40°C; kubyimba kw'inturugunzu (munsi y'amatwi no mu bitugu); ibimyira biza n'ifuro mu mazuru, guhumeka nabi no gupfa vuba.",
            preventionsEn = "Strict weekly tick dipping or spray application using certified acaricides (Deltamethrin or Amitraz); clear tall bush around paddocks; vaccinate calves with Muguga Cocktail (ECF-ITM).",
            preventionsRw = "Kwoza inka buri cyumweru mu kiziba cyangwa no gufuhira umuti w'udusimba (Amitraz / Cypermethrin); guca ibihuru; gukingiza inyana umuti w'amakore.",
            organicTreatmentsEn = "Traditional supportive care only: provide shade, cool fresh water with mineral salts, and fresh green forage. (Note: Definitive cure requires specialized veterinary antiprotozoal drugs).",
            organicTreatmentsRw = "Kuhira inka amazi akonje arimo umunyu, kuyishyira mu gicucu, no kuyiha ubwatsi bworohereye; ariko biba ngombwa guhamagara muganga w'amatungo ako kanya.",
            chemicalTreatmentsEn = "First-line Veterinary Medicine: Buparvaquone (Butalex / Bupatest) at 2.5 mg/kg (1 ml per 20 kg body weight) deep intramuscular injection. If detected late, repeat after 48 hours accompanied by Oxytetracycline 20% LA.",
            chemicalTreatmentsRw = "Umuti w'ibanze wa muganga: Butalex (Buparvaquone) guterwa mu nyama z'ijosi, ikongerwaho Oxytetracycline 20% LA yo kurwanya umusonga wo mu bihaha.",
            requiredMedicalSupplies = listOf("Acaricide (Amitraz / Deltamethrin dip)", "Buparvaquone (Butalex) injection", "Oxytetracycline 20% LA", "Sterile Veterinary Syringes & 16G Needles", "Digital Animal Thermometer"),
            regionalPrevalence = "All Rwanda dairy zones: Gicumbi, Nyagatare, Musanze, Ruhango, Kayonza"
        ),
        ComprehensiveDisease(
            id = "animal_foot_and_mouth",
            nameEn = "Foot-and-Mouth Disease (FMD)",
            nameRw = "Uburenge mu Nka n'Ihene (FMD)",
            scientificOrCausativeAgent = "Aphthovirus (Picornaviridae)",
            domain = DiseaseDomain.ANIMAL,
            affectedHosts = "Cattle (Inka), Goats (Ihene), Sheep (Intama), Pigs (Ingurube)",
            causesEn = "Highly contagious airborne viral spread through direct contact with infected livestock saliva, milk, feed, boots, and vehicle tires at communal cattle markets.",
            causesRw = "Virusi yandura cyane mu buhumekero, amacandwe, amata, no gukoranaho kw'amatungo mu masoko n'amazi yo mu biyaga n'imigezi.",
            symptomsEn = "Painful blisters (vesicles) and erosions on tongue, dental pad, and inside hooves; severe drooling/foaming at mouth; lameness and reluctance to stand; sudden drop in milk yield.",
            symptomsRw = "Ibibyimba n'ubushye mu kanwa, ku rurimi no mu minwa y'ibinono; amacandwe menshi amara amaguru; gucumbagira no kwanga guhagarara; amata ahita ashira.",
            preventionsEn = "Strict quarantine enforcement; mandatory biannual ring vaccination coordinated by RAB; disinfecting hoof baths at farm entry gates using 4% sodium carbonate or citric acid.",
            preventionsRw = "Gushyira amatungo mu kato; gukingiza inka inshuro 2 mu mwaka na gahunda ya Leta ya RAB; gushyira amavuta cyangwa umuti wica udukoko mu birenge ku muryango w'ikiraro.",
            organicTreatmentsEn = "Wash mouth and hooves gently with warm saltwater, diluted alum, and natural honey/propolis to soothe lesions and speed healing of blisters.",
            organicTreatmentsRw = "Koza mu kanwa no ku binono n'amazi ashyushye arimo umunyu muke n'ubuki bwa gakondo kugira ngo ubushye bukire vuba inka ibashe kurya.",
            chemicalTreatmentsEn = "Antibiotic cover to prevent fatal secondary bacterial infections: Penicillin-Streptomycin (PenStrep) injection for 3-5 days. Spray topical oxytetracycline wound spray (Blue spray) on hooves.",
            chemicalTreatmentsRw = "Gutera inshinge za PenStrep (Penicillin-Streptomycin) yo kurinda uduce tw'ubwandu, no gufuhira ibinono umuti w'ubururu (Oxytetracycline Blue Spray).",
            requiredMedicalSupplies = listOf("PenStrep Antibiotic Vial", "Oxytetracycline Topical Blue Spray", "Footbath Disinfectant (Soda Ash)", "Livestock Thermometer"),
            regionalPrevalence = "Eastern border districts: Nyagatare, Gatsibo, Kayonza, Kirehe"
        ),
        ComprehensiveDisease(
            id = "animal_mastitis",
            nameEn = "Bovine Mastitis (Udder Inflammation)",
            nameRw = "Amashereka mabi / Indwara y'Amabere y'Inka",
            scientificOrCausativeAgent = "Staphylococcus aureus, Streptococcus uberis, E. coli",
            domain = DiseaseDomain.ANIMAL,
            affectedHosts = "Milking Dairy Cows (Inka zikamirwa)",
            causesEn = "Bacteria entering open teat canals after milking due to dirty barn floors, contaminated milking towels, unwashed milkers' hands, and poor hygiene.",
            causesRw = "Imyanda n'amabyi yo mu kiraro byinjira mu nseke z'amabere y'inka nyuma yo gukama, gukoresha ibitambaro bidafite isuku, cyangwa intoki zanduye z'umukamyi.",
            symptomsEn = "Swollen, hard, hot, and painful udder quarters; watery, clotted, yellowish, or bloody milk; reduced milk production; cow kicking during milking.",
            symptomsRw = "Ibice by'ibere birabyimba bikakomera bigashyushya cyane; amata azamo ibibumbe by'amashyira cyangwa amaraso; inka irababara ikarwana mugihe ikamirwa.",
            preventionsEn = "Pre-milking and post-milking teat dipping in iodine solution; use individual clean dry towels per cow; keep shed concrete floors clean and dry with sawdust; strip-cup testing.",
            preventionsRw = "Kwinjiza amabere mu mazi y'umuti wa Yode (Iodine dip) mbere na nyuma yo gukama; gukoresha igitambaro cy'isuku kuri buri nka; gusukura ikiraro no gupima amata.",
            organicTreatmentsEn = "Apply warm herbal compresses with castor oil or clean lard; frequent manual strip-milking of the infected quarter (every 2-3 hours) into a waste container to evacuate bacterial toxins.",
            organicTreatmentsRw = "Gukanda ibere n'igitambaro cyinzwe mu mazi ashyushye; gukama ibere ryanduye kenshi ku munsi (buri masaha 2) amata ukayamena kure kugira ngo amashyira ashiremo.",
            chemicalTreatmentsEn = "Intramammary Infusion: Multiject or Mastijet Forte teat syringe infused directly into infected teat after complete milking for 3 days. Systemic Penicillin or Tylosin injection if cow has fever.",
            chemicalTreatmentsRw = "Umuti w'umuyoboro w'ibere: Kwinjiza urushinge rw'umuti wa Mastijet Forte mu museke w'ibere ryanduye nyuma yo kurikama ryose, mu minsi 3.",
            requiredMedicalSupplies = listOf("Mastijet Forte intramammary tubes", "Iodine Teat Dip Cup", "California Mastitis Test (CMT) Paddle", "Disposable Milking Gloves"),
            regionalPrevalence = "Intensive Dairy Zones: Musanze, Gicumbi, Nyagatare, Rulindo"
        ),
        ComprehensiveDisease(
            id = "animal_newcastle",
            nameEn = "Newcastle Disease in Poultry",
            nameRw = "Umusonga w'Inkoko / Ikiza cya Newcastle",
            scientificOrCausativeAgent = "Avian Paramyxovirus Serotype 1 (APMV-1)",
            domain = DiseaseDomain.ANIMAL,
            affectedHosts = "Chickens (Inkoko z'amagi n'iz'inyama), Turkeys, Pigeons",
            causesEn = "Inhalation of virus particles or ingestion of droppings and feed contaminated by sick birds, wild pigeons, and visitors' contaminated shoes.",
            causesRw = "Guhumeka umwuka wanduye cyangwa kurya ibiryo byaranzwe n'amase y'inkoko zirwaye cyangwa inuma zo mu gasozi, n'inkweto zanduye z'abinjira mu kiraro.",
            symptomsEn = "Gasping for air, coughing, and rattling breathing sounds; greenish diarrhea; twisted necks (torticollis) and circling; sudden mortality up to 90% in flock within 48 hours.",
            symptomsRw = "Inkoko zicisha umutwe hasi, guhumeka nabi zasamye akanwa; guhitamo amase y'icyatsi kibisi; gukorora no kugwa agahanga zikapfa ari nyinshi icyarimwe.",
            preventionsEn = "Mandatory flock eye-drop or drinking water vaccination schedule: Hitchner B1 at day 7, LaSota at day 21, and repeat every 3 months; strict biosecurity footbaths.",
            preventionsRw = "Gukingiza inkoko zikiri ntoya ku munsi wa 7 n'uwa 21 hakoreshejwe urukingo rwo mu maso n'amazi rwa LaSota; gufunga ikiraro abashyitsi ntibinjiremo.",
            organicTreatmentsEn = "Add crushed fresh garlic and aloe vera (Igikakarubamba) juice to the flock drinking water to stimulate immune response and curb secondary gut infections.",
            organicTreatmentsRw = "Gucagagura igitunguru gituku, tungurusumu n'igikakarubamba mu mazi inkoko zinywa kugira ngo zongere ubudahangarwa mu mubiri.",
            chemicalTreatmentsEn = "No antiviral cure exists once birds display nervous signs. Provide broad-spectrum water-soluble antibiotic and multivitamin powder (e.g. Aliseryl, Oxytetracycline HCl + Vitamins) to prevent secondary bacterial collapse.",
            chemicalTreatmentsRw = "Nta muti wishe virusi ya Newcastle iyo yageze mu bwonko. Zihabwe umuti w'ifu ya Aliseryl cyangwa Oxytetracycline ivanze na Vitamini mu mazi yo kunywa.",
            requiredMedicalSupplies = listOf("Newcastle LaSota Vaccine Vials", "Aliseryl Water-Soluble Antibiotic", "Poultry Multivitamin drops", "Dropper Pipette"),
            regionalPrevalence = "Bugesera, Rwamagana, Gasabo, Kicukiro, Musanze"
        ),
        ComprehensiveDisease(
            id = "animal_anthrax",
            nameEn = "Anthrax / Splenic Fever (Zoonotic)",
            nameRw = "Ikinyoro cyangwa Anthrax mu Matungo n'Abantu",
            scientificOrCausativeAgent = "Bacillus anthracis (Spore-forming lethal bacterium)",
            domain = DiseaseDomain.ANIMAL,
            affectedHosts = "Cattle, Goats, Sheep, Humans (Transmissible to farmers and butchers)",
            causesEn = "Ingestion of bacterial spores that survive in alkaline soils for decades. Brought to surface by heavy seasonal flooding or soil excavation.",
            causesRw = "Irobeza n'utubuto tw'amaraso dushobora kumara imyaka irenga 40 mu butaka, twongera kuzamuka mu gihe cy'imyuzure n'isuri.",
            symptomsEn = "Sudden unexplained death with non-clotting dark tarry blood oozing from mouth, nose, and anus; absence of rigor mortis (carcass does not stiffen). In humans: black necrotic skin ulcers.",
            symptomsRw = "Inka ipfa itarwaye, amaraso y'umukara adakoma agasohoka mu mazuru, mu kanwa no mu kibuno; umurambo ntukomere. Ku bantu: ibibyimba by'umukara ku ruhu.",
            preventionsEn = "Annual prophylactic vaccination by District Veterinary Services; NEVER OPEN OR SLICING AN ANTHRAX SUSPECTED CARCASS (prevents spore release); bury carcass 2 meters deep covered with quicklime.",
            preventionsRw = "Gukingiza amatungo buri mwaka; KUTAZA NA RIMWE GUSATURA CYANGWA KURYA INYAMA Z'INPFIRO (ntugafungure umurambo); gushyingura intumbi hasi muri metero 2 ushyizemo ishwagara.",
            organicTreatmentsEn = "No home remedy. Anthrax is an urgent international notifiable emergency. Immediately evacuate farm hands and dial RAB Emergency 114.",
            organicTreatmentsRw = "Nta muti gakondo ubaho. Ni indwara y'icyorezo yica n'abantu; hita uhamagara muganga na RAB 114 ako kanya.",
            chemicalTreatmentsEn = "High-dose Procaine Penicillin or Oxytetracycline 20% administered immediately by licensed veterinarians to in-contact herd members exhibiting fever before terminal collapse.",
            chemicalTreatmentsRw = "Gutera inshinge z'umuti wa Penicillin ifite imbaraga nyinshi mu buryo bwihuse ku yandi matungo abana n'iyapfuye mbere y'uko nayo afatwa.",
            requiredMedicalSupplies = listOf("Quicklime (Ishwagara)", "Heavy Duty Rubber PPE & Aprons", "High-titer Penicillin G vials", "Official RAB Notification Report"),
            regionalPrevalence = "Eastern savannah pasture zones: Nyagatare, Gatsibo, Kirehe"
        )
    )

    fun getByDomain(domain: DiseaseDomain): List<ComprehensiveDisease> {
        return diseases.filter { it.domain == domain }
    }

    fun search(query: String, domain: DiseaseDomain? = null): List<ComprehensiveDisease> {
        val q = query.trim().lowercase()
        return diseases.filter { item ->
            val matchDomain = domain == null || item.domain == domain
            val matchText = q.isBlank() ||
                    item.nameEn.lowercase().contains(q) ||
                    item.nameRw.lowercase().contains(q) ||
                    item.affectedHosts.lowercase().contains(q) ||
                    item.symptomsEn.lowercase().contains(q) ||
                    item.symptomsRw.lowercase().contains(q) ||
                    item.causesEn.lowercase().contains(q) ||
                    item.causesRw.lowercase().contains(q)
            matchDomain && matchText
        }
    }
}
