package com.example.data.repository

import com.example.data.model.FarmGrowthGuide
import com.example.data.model.GrowthCategory
import com.example.data.model.GrowthStageStep

object GrowthTipsRepository {

    val GUIDES = listOf(
        FarmGrowthGuide(
            id = "crop_maize",
            nameEn = "Maize (Ibigori)",
            nameRw = "Ibigori",
            scientificName = "Zea mays",
            category = GrowthCategory.CROP,
            seasonOrCycleTextEn = "Season A & B (110 - 130 Days)",
            seasonOrCycleTextRw = "Igihembwe cya A na B (Iminsi 110 - 130)",
            generalDescriptionEn = "High-yielding staple grain grown across Nyagatare, Gatsibo, Ruhango, and Musanze highlands. Requires good soil fertility and timely weeding.",
            generalDescriptionRw = "Igihingwa fatizo kera mu Rwanda hose cyane cyane mu Burasirazuba no mu Majyepfo. Gisaba ubutaka bwera neza n'isasira ry'ifumbire ku gihe.",
            optimalZoneRwanda = "Nyagatare, Gatsibo, Rwamagana, Ruhango, Musanze",
            stages = listOf(
                GrowthStageStep(
                    stageNumber = 1,
                    stageNameEn = "Land Prep & Liming",
                    stageNameRw = "Gutegura Umurima n'Ishwagara",
                    durationTextEn = "3 - 4 weeks before planting",
                    durationTextRw = "Ibyumweru 3 - 4 mbere yo gutera",
                    descriptionEn = "Plow soil deeply (25-30cm) to break hardpan. Apply agricultural lime (Ishwagara) at 2 to 2.5 tonnes/ha on acidic soils (pH < 5.5) common in Northern and Southern provinces.",
                    descriptionRw = "Hinga byimbitse (cm 25-30). Shyiramo ishwagara (toni 2 kugeza kuri 2.5 kuri hegitari) niba ubutaka bwawe busharira (mu Majyaruguru n'Amajyepfo).",
                    keyPracticesEn = listOf(
                        "Deep plowing and residue incorporation",
                        "Broadcast agricultural limestone 30 days prior to rains",
                        "Dig anti-erosion trenches (Imikero) on terraced hills"
                    ),
                    keyPracticesRw = listOf(
                        "Guhinda ubutaka buziye",
                        "Gusasira ishwagara iminsi 30 mbere y'imvura",
                        "Guca imikero irwanya isuri ku materasi"
                    ),
                    inputSuppliesNeededEn = "Agricultural lime (Ishwagara), Compost/FYM (10-15 tonnes/ha)",
                    inputSuppliesNeededRw = "Ishwagara, Imborera iboze neza (toni 10-15 kuri hegitari)",
                    warningOrRisksEn = "Never apply chemical DAP simultaneously with unslaked lime; lime will gas off nitrogen.",
                    warningOrRisksRw = "Ntukavange ishwagara n'ifumbire ya DAP icyarimwe kuko ituma azote ihunguka."
                ),
                GrowthStageStep(
                    stageNumber = 2,
                    stageNameEn = "Planting & Basal Fertilizer (DAP)",
                    stageNameRw = "Gutera no Gushyiramo DAP",
                    durationTextEn = "Days 1 - 7",
                    durationTextRw = "Iminsi 1 - 7",
                    descriptionEn = "Plant certified hybrid seed (e.g. SC 403, Bazooka, Hybrid 628 from Tubura). Spacing: 75cm between rows, 25cm between plants (1 seed per hole) or 50cm (2 seeds). Apply DAP at 100 kg/ha.",
                    descriptionRw = "Tera imbuto y'indobanure (SC 403, Bazooka, Hybrid 628). Intera: cm 75 hagati y'imirongo na cm 25 hagati y'ingiga (imbuto 1 mu mwobo). Fumbira DAP (ibiro 100 kuri ha).",
                    keyPracticesEn = listOf(
                        "Depth: 4 - 5 cm in moist soil",
                        "Mix DAP with soil before dropping seed to prevent root burn",
                        "Cover seed firmly with loose moist soil"
                    ),
                    keyPracticesRw = listOf(
                        "Ubujyakuzimu bwa cm 4 - 5 mu butaka buhehereye",
                        "Vanga DAP n'itaka mbere yo gushyiramo imbuto ngo idashya",
                        "Twikiriza itaka ryoroshye"
                    ),
                    inputSuppliesNeededEn = "Certified seed (25 kg/ha), DAP fertilizer (100 kg/ha)",
                    inputSuppliesNeededRw = "Imbuto y'indobanure (ibiro 25/ha), Ifumbire ya DAP (ibiro 100/ha)",
                    warningOrRisksEn = "Direct contact between fertilizer and seed causes seed rot and patchy germination.",
                    warningOrRisksRw = "Imbuto ikoze ku ifumbire itaka ritari hagati irabora ntigere hejuru."
                ),
                GrowthStageStep(
                    stageNumber = 3,
                    stageNameEn = "First Weeding & Thinning",
                    stageNameRw = "Kubagara bwa Mbere no Gucoca",
                    durationTextEn = "Days 14 - 21 (V3 - V4 stage)",
                    durationTextRw = "Iminsi 14 - 21 (Ibibabi 3 - 4)",
                    descriptionEn = "Weed aggressively while weeds are small. Thin extra seedlings leaving the strongest plant per station. Scout young whorls for early Fall Armyworm pinholes.",
                    descriptionRw = "Bagara hakiri kare ibyatsi bikiri bito. Coca usige igiti kimwe gikomeye mu mwobo. Reba niba nta nkongwa yatangiye kurya utwobo ku mababi.",
                    keyPracticesEn = listOf(
                        "Shallow hoeing around tender roots",
                        "Thinning when soil is moist",
                        "Pinch sand + wood ash in funnel for pest prevention"
                    ),
                    keyPracticesRw = listOf(
                        "Kubagara buhoro udakomeretsa imizi",
                        "Gucoca ubutaka buhehereye",
                        "Gushyira ivu n'umucanga mu mutwe w'ikigori"
                    ),
                    inputSuppliesNeededEn = "Clean hoes, Wood ash + sand mix",
                    inputSuppliesNeededRw = "Isuka isukuye, Ivu n'umucanga",
                    warningOrRisksEn = "Weed competition in the first 4 weeks cuts final grain yield by up to 50%.",
                    warningOrRisksRw = "Ibyatsi bibangamira ibigori mu byumweru 4 bya mbere bigabanya umusaruroho 50%."
                ),
                GrowthStageStep(
                    stageNumber = 4,
                    stageNameEn = "Top-Dressing (Urea) & Hilling",
                    stageNameRw = "Gusasira Urea no Kuririza",
                    durationTextEn = "Days 30 - 40 (Knee-high / V6 - V8)",
                    durationTextRw = "Iminsi 30 - 40 (Bigeze mu mavi)",
                    descriptionEn = "Apply Urea (50 - 100 kg/ha) when plants reach knee height. Band place fertilizer 5cm away from the stem and cover with soil immediately (hilling).",
                    descriptionRw = "Shyiramo ifumbire ya Urea (ibiro 50 - 100 kuri ha) ibigori bigeze mu mavi. Shyira ku ntera ya cm 5 uvuye ku gishyitsi hanyuma uririze (twikiriza itaka).",
                    keyPracticesEn = listOf(
                        "Apply right before rain or in moist soil",
                        "Hill up soil around base to support brace roots and prevent lodging",
                        "Keep fertilizer off wet leaves to prevent chemical leaf scorching"
                    ),
                    keyPracticesRw = listOf(
                        "Shyiramo ifumbire mbere gato y'imvura",
                        "Ririza itaka ku gishyitsi ngo kigire imizi ifata neza ntikigwe",
                        "Wirinde ko ifumbire igwa ku mababi atose"
                    ),
                    inputSuppliesNeededEn = "Urea fertilizer (46-0-0) 50-100 kg/ha",
                    inputSuppliesNeededRw = "Ifumbire ya Urea (ibiro 50-100 kuri ha)",
                    warningOrRisksEn = "Leaving Urea on dry surface soil causes up to 40% volatilization into the air.",
                    warningOrRisksRw = "Kureka Urea ku gitaka cyumye idatwikiriye bituma azote yose igenda mu mwuka."
                ),
                GrowthStageStep(
                    stageNumber = 5,
                    stageNameEn = "Tasseling, Silking & Cob Protection",
                    stageNameRw = "Kurabya, Gusuka no Kurinda Ikigori",
                    durationTextEn = "Days 55 - 75",
                    durationTextRw = "Iminsi 55 - 75",
                    descriptionEn = "Critical moisture requirement. Pollen sheds from tassels to silks. Prevent ear rots and stem borer entry. Maintain good soil drainage.",
                    descriptionRw = "Iki gihe ibigori bikenera amazi ahagije. Umwungu urasuka ugakora ikigori. Rinda ibyonnyi n'indwara z'ifu y'iroza (Fusarium).",
                    keyPracticesEn = listOf(
                        "Scout for ear borers and fungal ear rots",
                        "Ensure drainage channels are clear of standing water",
                        "Avoid cutting lower green leaves for fodder prematurely"
                    ),
                    keyPracticesRw = listOf(
                        "Gusuzuma ibyonnyi by'ibigori n'imiyege",
                        "Gusibura imikero ngo amazi adadama mu murima",
                        "Kwirinda guca amababi akiri icyatsi ngo ugaburire amatungo"
                    ),
                    inputSuppliesNeededEn = "Knapsack sprayer, organic neem or biopesticide if ear worms appear",
                    inputSuppliesNeededRw = "Pompe yo gutera, Umuti w'igiti cy'umunezero (Neem)",
                    warningOrRisksEn = "Moisture stress during silking causes barren cobs and poor kernel fill.",
                    warningOrRisksRw = "Kubura amazi igihe cyo kurabya bituma ibigori biba ingumba."
                ),
                GrowthStageStep(
                    stageNumber = 6,
                    stageNameEn = "Harvesting & Post-Harvest Curing",
                    stageNameRw = "Gusarura no Kumanika ku Mashitingi",
                    durationTextEn = "Days 110 - 130",
                    durationTextRw = "Iminsi 110 - 130",
                    descriptionEn = "Harvest when husks turn dry and brown and black layer forms at the grain base. Dry cobs immediately on clean plastic tarpaulins in sun to <13.5% moisture. Store in hermetic PICS bags.",
                    descriptionRw = "Sarura ibishingwe bimaze kuma, ikigori gifite umukara hasi ku ntete. Yanika ku mashitingi asukuye ku zuba kugeza wumye munsi ya 13.5%. Shyira mu mifuka ya PICS.",
                    keyPracticesEn = listOf(
                        "Never dry grain directly on bare ground (prevents Aspergillus mold)",
                        "Test dryness: grain should crack sharply under teeth without indentation",
                        "Pack in hermetic PICS bags without chemical insecticides"
                    ),
                    keyPracticesRw = listOf(
                        "Ntukajanike ku gitaka kitarimo ishitingi (birinda uburozi bwa Aflatoxine)",
                        "Pima ubumori: uhekenye intete igomba guturika idahamye",
                        "Bika mu mifuka ya PICS irinda udukoko idasaba imiti"
                    ),
                    inputSuppliesNeededEn = "Clean drying tarpaulins, Hermetic PICS bags, grain moisture meter",
                    inputSuppliesNeededRw = "Amashitingi yo kwanikaho, Imifuka ya PICS, igipimo cy'ubutose",
                    warningOrRisksEn = "Drying on bare soil causes dangerous aflatoxin contamination.",
                    warningOrRisksRw = "Kwanika ku gitaka bituma habaho uburozi bwica bwa Aflatoxine."
                )
            ),
            expertTipsEn = "RAB agronomists advise: Always test soil pH every 2 years. Using lime on Northern and Southern acidic soils doubles maize response to fertilizer.",
            expertTipsRw = "Inama z'Inzobere za RAB: Buri myaka 2 pima ubusharire bw'ubutaka. Gushyiramo ishwagara mu Majyaruguru n'Amajyepfo byongera umusaruro w'ibigori inshuro ebyiri."
        ),

        FarmGrowthGuide(
            id = "crop_potato",
            nameEn = "Irish Potato (Ibirayi)",
            nameRw = "Ibirayi",
            scientificName = "Solanum tuberosum",
            category = GrowthCategory.CROP,
            seasonOrCycleTextEn = "Season A & B (90 - 110 Days)",
            seasonOrCycleTextRw = "Igihembwe cya A na B (Iminsi 90 - 110)",
            generalDescriptionEn = "The volcanic golden crop of Musanze, Nyabihu, and Rubavu. High income potential with proper seed sprout selection and blight management.",
            generalDescriptionRw = "Igihingwa fatizo mu misozi y'ibirunga (Musanze, Nyabihu, Rubavu). Gitanga inyungu nyinshi iyo ukoresheje imbuto nziza yameze n'umuti w'imvura.",
            optimalZoneRwanda = "Musanze, Nyabihu, Rubavu, Gicumbi",
            stages = listOf(
                GrowthStageStep(
                    stageNumber = 1,
                    stageNameEn = "Sprouted Seed Selection & Ridging",
                    stageNameRw = "Guhitamo Imbuto Yameze no Gukora Imisozi",
                    durationTextEn = "Pre-planting",
                    durationTextRw = "Mbere yo gutera",
                    descriptionEn = "Use certified clean seed tubers (size 35-55mm) from SPF-Ikigega (Kinigi, Cruza, Victoria). Ensure multiple sturdy green/purple sprouts (1.5-2cm). Prepare mounds or ridges 75cm apart.",
                    descriptionRw = "Koresha imbuto y'indobanure (ingano ya mm 35-55) ivuye muri SPF-Ikigega (Kinigi, Cruza, Victoria). Yameje amashami akomeye. Kora imisozi ifite intera ya cm 75.",
                    keyPracticesEn = listOf(
                        "Diffuse Light Storage (DLS) for firm green sprouts",
                        "Never slice seed tubers; whole tubers resist soil rots",
                        "Incorporate well-rotted cattle manure in furrows"
                    ),
                    keyPracticesRw = listOf(
                        "Kwanika imbuto ahari urumuri rworoshye ngo imere neza",
                        "Ntugakatemo kabiri imbuto y'ibirayi ngo itaborera mu butaka",
                        "Shyira ifumbire y'imborera iboze mu mifuka"
                    ),
                    inputSuppliesNeededEn = "Certified seed (2 - 2.5 tonnes/ha), well-rotted manure",
                    inputSuppliesNeededRw = "Imbuto y'indobanure (toni 2 kugeza 2.5/ha), imborera iboze",
                    warningOrRisksEn = "Planting tubers with long, pale white sprouts stored in darkness leads to weak, brittle emergence.",
                    warningOrRisksRw = "Gutera ibirayi byameje amashami maremare y'umweru mu mwijima bituma bipfa."
                ),
                GrowthStageStep(
                    stageNumber = 2,
                    stageNameEn = "Planting & NPK Basal Fertilizer",
                    stageNameRw = "Gutera no Gufumbira NPK 17-17-17",
                    durationTextEn = "Day 1",
                    durationTextRw = "Umunsi wa 1",
                    descriptionEn = "Plant tubers at 30cm spacing within ridges, 10-12cm deep with sprouts facing upward. Apply NPK 17-17-17 at 250 - 300 kg/ha in the trench below/beside tubers.",
                    descriptionRw = "Tera ibirayi ku ntera ya cm 30 ku murongo, ubujyakuzimu bwa cm 10-12 amashami areba hejuru. Fumbira NPK 17-17-17 (ibiro 250 - 300 kuri ha) munsi y'ikirayi.",
                    keyPracticesEn = listOf(
                        "Place sprouts facing up gently",
                        "Keep chemical fertilizer from directly touching sprouts",
                        "Cover with 10cm of crumbly fertile topsoil"
                    ),
                    keyPracticesRw = listOf(
                        "Gushyira amashami areba hejuru witonze",
                        "Kwirinda ko ifumbire ikora ku mamera",
                        "Gupfundikiza itaka ry'ifumbire rya cm 10"
                    ),
                    inputSuppliesNeededEn = "NPK 17-17-17 fertilizer (250-300 kg/ha)",
                    inputSuppliesNeededRw = "Ifumbire ya NPK 17-17-17 (ibiro 250-300 kuri ha)",
                    warningOrRisksEn = "Planting too shallow exposes growing tubers to sunlight, creating toxic green solanine.",
                    warningOrRisksRw = "Gutera hejuru cyane bituma ibirayi bihinduka icyatsi bitewe n'izuba bikaba uburozi (Solanine)."
                ),
                GrowthStageStep(
                    stageNumber = 3,
                    stageNameEn = "First Hilling & Preventative Blight Spray",
                    stageNameRw = "Guhingirira bwa Mbere no Gutera Umuti w'Imvura",
                    durationTextEn = "Days 20 - 30 (Plants 15 - 20cm high)",
                    durationTextRw = "Iminsi 20 - 30 (Bifite cm 15-20 z'uburebure)",
                    descriptionEn = "Build wide, trapezoid soil mounds around plants to give space for stolons. Apply preventive Mancozeb (Dithane M-45, 50g / 20L) before rainfall.",
                    descriptionRw = "Hingirira ukore umusozi mugari ufasha ibirayi kwisanzura. Tera umuti w'imvura wa Dithane M-45 (garama 50 muri litiro 20) mbere y'uko imvura igwa.",
                    keyPracticesEn = listOf(
                        "Wide mounding around root crowns",
                        "Spray under and over leaves with fine mist",
                        "Repeat fungicide spray every 7-10 days in foggy weather"
                    ),
                    keyPracticesRw = listOf(
                        "Gukora imisozi migari ifunze",
                        "Gutera umuti munsi no hejuru y'amababi",
                        "Gusubiramo umuti buri minsi 7-10 mu gihe cy'igihu"
                    ),
                    inputSuppliesNeededEn = "Dithane M-45 (Mancozeb), knapsack sprayer, protective gear",
                    inputSuppliesNeededRw = "Dithane M-45, pompe yo gutera, imyenda y'ubwirinzi",
                    warningOrRisksEn = "Late blight can destroy an entire potato field in 72 hours if preventive spray is skipped during continuous rain.",
                    warningOrRisksRw = "Indwara y'imvura (Miyiridiyu) ishobora kwangiza umurima wose mu masaha 72 iyo utateye umuti ku gihe."
                ),
                GrowthStageStep(
                    stageNumber = 4,
                    stageNameEn = "Flowering & Tuber Bulking Protection",
                    stageNameRw = "Kurabya no Kurema Ibirayi",
                    durationTextEn = "Days 45 - 70",
                    durationTextRw = "Iminsi 45 - 70",
                    descriptionEn = "Plants enter maximum tuber bulking. Keep ridges covered and cracks sealed with loose soil so potato tuber moth (PTM) and blight spores cannot reach underground tubers.",
                    descriptionRw = "Ibirayi biri mu gihe cyo gukura no gutubuka mu butaka. Ziba imitutu yose y'itaka ngo udukoko n'imvura bitagera ku birayi munsi.",
                    keyPracticesEn = listOf(
                        "Top-up soil on ridges to cover any exposed tubers",
                        "Ensure soil stays consistently moist; drought causes cracked knobby tubers",
                        "Rotate fungicides (Ridomil Gold MZ if disease lesions appear)"
                    ),
                    keyPracticesRw = listOf(
                        "Kongera itaka ku misozi ngo ibirayi bitajya ku zuba",
                        "Gufasha ubutaka guhora buhehereye",
                        "Guhinduranya imiti (Ridomil Gold igihe indwara yagaragaye)"
                    ),
                    inputSuppliesNeededEn = "Ridomil Gold MZ or Mancozeb",
                    inputSuppliesNeededRw = "Ridomil Gold MZ cyangwa Mancozeb",
                    warningOrRisksEn = "Cracking soil allows tuber moth larvae to bore tunnels through underground potatoes.",
                    warningOrRisksRw = "Imitutu mu misozi ituma udukoko twinjira mu birayi munsi y'ubutaka bikabora."
                ),
                GrowthStageStep(
                    stageNumber = 5,
                    stageNameEn = "De-Haulming (Cutting Stems) & Harvest",
                    stageNameRw = "Guca Ibihingwa (De-haulming) no Gusarura",
                    durationTextEn = "Days 85 - 105",
                    durationTextRw = "Iminsi 85 - 105",
                    descriptionEn = "Cut and remove all potato vines (de-haulming) 14 days before harvest. This hardens tuber skin, stops blight spores from falling onto potatoes, and extends storage life by months.",
                    descriptionRw = "Katira hejuru ibiti byose by'ibirayi (de-haulming) hasigaye ibyumweru bibiri ngo usarure. Ibi bikomeza agahu k'ikirayi, bikarinda indwara kandi bikaramba mu bubiko.",
                    keyPracticesEn = listOf(
                        "Cut stems at soil level and remove vines from field",
                        "Wait full 10 - 14 days in dry ground to cure tuber skins",
                        "Dig using blunt forks on a dry, sunny morning",
                        "Sort out damaged tubers before bagging"
                    ),
                    keyPracticesRw = listOf(
                        "Gukata amashami hasi no kuyavana mu murima",
                        "Gutegereza iminsi 10-14 ubutaka bwumye ngo agahu gakomere",
                        "Gusarura ukoresheje ikanya idakomeretsa ku gitondo cy'izuba",
                        "Gutoranya ibirayi byakomeretse mbere yo kubipakira"
                    ),
                    inputSuppliesNeededEn = "Sickles for de-haulming, harvesting forks, wooden crates/mesh bags",
                    inputSuppliesNeededRw = "Umuhoro wo gukata, ikanya yo gucukura, ibitebo n'imifuka y'umwuka",
                    warningOrRisksEn = "Harvesting immediately without de-haulming causes skin peeling, rapid rotting, and market loss.",
                    warningOrRisksRw = "Gusarura utaciye ibihingwa mbere bituma agahu gacika vuba, bikabora mu nzira zijya ku isoko."
                )
            ),
            expertTipsEn = "Kinigi variety commands top market price in Kigali but requires rigorous blight spraying. Cruza variety is naturally blight-resistant and requires 50% less fungicide.",
            expertTipsRw = "Imbuto ya Kinigi igurishwa amafaranga menshi i Kigali ariko isaba gutera umuti kenshi. Imbuto ya Cruza yihanganira imyiridiyu igasaba umuti muke."
        ),

        // Livestock Guides
        FarmGrowthGuide(
            id = "livestock_dairy_cattle",
            nameEn = "Dairy Cattle (Inka z'Amata)",
            nameRw = "Inka z'Amata (Guhahirwa no Korora)",
            scientificName = "Bos taurus / Bos indicus",
            category = GrowthCategory.LIVESTOCK,
            seasonOrCycleTextEn = "Year-Round Zero-Grazing (Girinka / Modern Dairy)",
            seasonOrCycleTextRw = "Kororera mu Kiraro (Gahunda ya Girinka)",
            generalDescriptionEn = "High-grade Friesian, Jersey, and Sahiwal dairy cattle management for maximum milk production (15-25L/day) in modern Rwandan zero-grazing sheds.",
            generalDescriptionRw = "Uburyo bwo kororera inka z'amata z'inzungu (Friesian, Jersey) mu biraro bitanga umukamo uhagije (Litiro 15-25 ku munsi).",
            optimalZoneRwanda = "Nyagatare, Gicumbi, Musanze, Ruhango, Huye",
            stages = listOf(
                GrowthStageStep(
                    stageNumber = 1,
                    stageNameEn = "Calf Birth & First 2 Hours Colostrum",
                    stageNameRw = "Ivuka ry'Uruhinja n'Umuhondo w'Iminsi ya Mbere",
                    durationTextEn = "Hours 0 - 48",
                    durationTextRw = "Amasaha 0 - 48",
                    descriptionEn = "Feed minimum 2 to 3 liters of warm maternal colostrum (Umuhondo) within the FIRST 2 HOURS of birth. Clean and dip navel cord in 7% Iodine tincture immediately.",
                    descriptionRw = "Nyuza inyana litiro 2 kugeza kuri 3 z'umuhondo w'akazuyazi MU MASAHU 2 YA MBERE ivutse. Sukura kandi usige umukondo umuti wa Yode (Iodine 7%).",
                    keyPracticesEn = listOf(
                        "Measure 10% of body weight in colostrum on Day 1",
                        "Disinfect navel cord twice daily to prevent joint-ill",
                        "Keep calf in dry, warm bedded pen off concrete"
                    ),
                    keyPracticesRw = listOf(
                        "Kuyiha umuhondo ungana na 10% by'ibiro byayo ku munsi wa 1",
                        "Kwisiga umuti wa Yode ku mukondo kabiri ku munsi",
                        "Kuryamisha inyana ku binyatsi byumye birinda ubukonje"
                    ),
                    inputSuppliesNeededEn = "7% Tincture of Iodine, clean calf nursing bucket, warm clean water",
                    inputSuppliesNeededRw = "Umuti wa Yode (Iodine 7%), indobo isukuye yo konsesha, amazi meza",
                    warningOrRisksEn = "Calf gut closes to maternal antibodies after 6 hours; delayed colostrum causes fatal scours and septicemia.",
                    warningOrRisksRw = "Urura rw'inyana rwifunga nyuma y'amasaha 6; gutinda kuyiha umuhondo bituma irwara igapfa."
                ),
                GrowthStageStep(
                    stageNumber = 2,
                    stageNameEn = "Heifer Rearing & Parasite Control",
                    stageNameRw = "Kurera Inyana no Kurwanya Udukoko",
                    durationTextEn = "Months 2 - 14",
                    durationTextRw = "Amezi 2 - 14",
                    descriptionEn = "Deworm with Albendazole every 3 months. Spray with Amitraz / Deltamethrin acaricide weekly to prevent East Coast Fever (Amakore) transmitted by brown ticks.",
                    descriptionRw = "Nyuza umuti w'inzoka (Albendazole) buri mezi 3. Tera umuti w'imbaragasa (Amitraz) buri cyumweru ngo urinde Amakore yaterwa n'uturondwe.",
                    keyPracticesEn = listOf(
                        "Weekly tick spraying (ears, brisket, under tail)",
                        "Gradual weaning onto high-protein Calliandra and Rhodes grass",
                        "Vaccination against Blackquarter and Anthrax at 6 months"
                    ),
                    keyPracticesRw = listOf(
                        "Gutera umuti w'uturondwe buri cyumweru (mu matwi, munsi y'umurizo)",
                        "Kuyimenyereza ubwatsi bwa Kariyandara n'urwiri",
                        "Gukingiza uburenge bwa karande ku mezi 6"
                    ),
                    inputSuppliesNeededEn = "Amitraz/Deltamethrin acaricide, knapsack or spray race, Albendazole bolus",
                    inputSuppliesNeededRw = "Umuti w'uturondwe (Amitraz), ibinini by'inzoka (Albendazole)",
                    warningOrRisksEn = "East Coast Fever kills high-grade heifers in 10-14 days without prompt veterinary Buparvaquone treatment.",
                    warningOrRisksRw = "Indwara y'Amakore yica inka mu minsi 10-14 iyo idahawe umuti wa Buparvaquone hakiri kare."
                ),
                GrowthStageStep(
                    stageNumber = 3,
                    stageNameEn = "Lactation Ration & High-Milk Nutrition",
                    stageNameRw = "Indyo y'Umukamo Uhagije n'Amazi Meza",
                    durationTextEn = "Active Milking Cycle",
                    durationTextRw = "Igihe cy'Umukamo",
                    descriptionEn = "Feed a 70:30 dry matter ratio of chopped wilted Napier grass / maize silage and protein fodder (Calliandra, Desmodium, Leucaena). Provide continuous clean drinking water (60-100L/day) and mineral salt licks.",
                    descriptionRw = "Gaburira inka ubwatsi bw'urubingo rwagasizwe (silage) buvanze na Kariyandara cyangwa Desmodium. Yihe amazi meza adashira (Litiro 60-100 ku munsi) n'umunyu wo kurigata.",
                    keyPracticesEn = listOf(
                        "Chop fodder into 2-3 cm lengths before feeding to maximize intake",
                        "Add 1kg commercial dairy meal for every 2 liters of milk produced above 5L",
                        "Hang mineral lick brick at eye level in the feeding stall"
                    ),
                    keyPracticesRw = listOf(
                        "Gukata ubwatsi bwa cm 2-3 ngo itungo ryose riburye neza",
                        "Kongeraho ikiro 1 cy'ifu y'inka ku buri litiro 2 z'umukamo urenze litiro 5",
                        "Kumanika ibuye ry'umunyu mu kiraro ahantu igera neza"
                    ),
                    inputSuppliesNeededEn = "Fodder chopper machine, mineral salt licks, clean automatic water trough",
                    inputSuppliesNeededRw = "Imashini ikata ubwatsi, ibuye ry'umunyu, urwogero rw'amazi meza",
                    warningOrRisksEn = "Water restriction drops milk output by 20% within 24 hours.",
                    warningOrRisksRw = "Kubura amazi meza bigabanya umukamo ku kigero cya 20% mu masaha 24 gusa."
                ),
                GrowthStageStep(
                    stageNumber = 4,
                    stageNameEn = "Milking Hygiene & Mastitis Prevention",
                    stageNameRw = "Isuku yo Gukama no Kwirinda Amashereka",
                    durationTextEn = "Twice Daily Routine",
                    durationTextRw = "Buri Munsi mu Gitondo no Nimugoroba",
                    descriptionEn = "Wash udder with warm sanitized water and dry with single-use towel. Strip 2 squirts into strip cup to check for mastitis clots. Dip teats in antiseptic iodine teat-dip immediately AFTER milking.",
                    descriptionRw = "Karaba umubyimba n'amazi y'akazuyazi asukuye hanyuma wumutishe igitambaro cyumye. Kama imigongo ibiri mu gikombe cyo gupima amashereka. Yisige umuti w'isuku ku minwa y'umubyimba ukimara gukama.",
                    keyPracticesEn = listOf(
                        "California Mastitis Test (CMT) monthly",
                        "Post-milking teat dipping with 0.5% chlorhexidine / iodine",
                        "Keep cow standing for 30 minutes after milking while teat sphincter closes"
                    ),
                    keyPracticesRw = listOf(
                        "Gupima amashereka (CMT) rimwe mu kwezi",
                        "Gusiga umuti w'isuku ku minwa y'amabere nyuma yo gukama",
                        "Gufasha inka guhagarara iminota 30 ikimara gukamwa ngo imyenge ifunge"
                    ),
                    inputSuppliesNeededEn = "Strip cup, iodine teat dip cup, clean food-grade aluminum milk cans",
                    inputSuppliesNeededRw = "Igikombe cyo gupima amashereka, umuti w'isuku y'amabere, amandege y'icyuma asukuye",
                    warningOrRisksEn = "Subclinical mastitis robs 15-30% of total milk yield and turns milk acidic for collection centers.",
                    warningOrRisksRw = "Indwara y'amashereka igabanya umukamo kandi ikangiza amata ku makusanyirizo (MCC)."
                )
            ),
            expertTipsEn = "RAB Girinka veterinarian advice: Plant Calliandra calothyrsus along terrace borders. 3kg of fresh Calliandra daily substitutes 1kg of expensive commercial dairy meal.",
            expertTipsRw = "Inama z'Inzobere za RAB Girinka: Tera ibiti bya Kariyandara ku nkengero z'amaterasi. Ibiro 3 bya Kariyandara buri munsi bisimbura ikiro 1 cy'ifu ihenze yo mu ruganda."
        ),

        FarmGrowthGuide(
            id = "livestock_poultry",
            nameEn = "Poultry & Chicken (Inkoko z'Amagi n'Inyama)",
            nameRw = "Inkoko z'Amagi n'Inyama (Ubworozi)",
            scientificName = "Gallus gallus domesticus",
            category = GrowthCategory.LIVESTOCK,
            seasonOrCycleTextEn = "Broiler (42 Days) / Kuroiler / Layers (18 Months)",
            seasonOrCycleTextRw = "Inkoko z'inyama (Iminsi 42) n'iz'amagi (Amezi 18)",
            generalDescriptionEn = "Profitable commercial poultry husbandry in Rwanda. Requires warm brooding, clean wood shavings litter, and strict vaccination against Newcastle & Gumboro.",
            generalDescriptionRw = "Ubworozi bw'inkoko butanga inyungu vuba mu Rwanda. Busaba ubushyuhe mu kiraro, ibyatsi byumye hasi no gukingiza indwara z'ibicurane na Gumboro.",
            optimalZoneRwanda = "Kigali periphery, Bugesera, Rwamagana, Huye, Musanze",
            stages = listOf(
                GrowthStageStep(
                    stageNumber = 1,
                    stageNameEn = "Brooding Heat & Glucose Water",
                    stageNameRw = "Ubushyuhe mu Kiraro n'Amazi ya Sukari",
                    durationTextEn = "Days 1 - 14",
                    durationTextRw = "Iminsi 1 - 14",
                    descriptionEn = "Pre-heat brooding room to 32°C - 35°C before chicks arrive. Provide clean lukewarm water mixed with glucose + multi-vitamins on Day 1 to restore energy.",
                    descriptionRw = "Shyushya ikiraro kigere kuri dogere 32°C - 35°C mbere y'uko imishwi ihagera. Yihe amazi y'akazuyazi arimo isukari na vitamine ku munsi wa 1.",
                    keyPracticesEn = listOf(
                        "Charcoal stove / infrared lamp with chick guard ring",
                        "Dry, absorbent pine wood shavings (5cm deep)",
                        "Watch chick behavior: evenly spread = ideal temperature; huddling near stove = too cold"
                    ),
                    keyPracticesRw = listOf(
                        "Imbabura y'amakara cyangwa itara ry'ubushyuhe",
                        "Ibishyitsi by'ibiti byumye hasi (cm 5)",
                        "Reba uko imishwi yifashe: ikwirakwiriye hose = ubushyuhe bumeze neza; yirundanije ku mbabura = hakonje cyane"
                    ),
                    inputSuppliesNeededEn = "Brooder thermometer, chick feeders & drinkers, glucose powder, chick starter mash",
                    inputSuppliesNeededRw = "Igipimo cy'ubushyuhe, ibiriro by'imishwi, isukari ya glucose, ifu y'imishwi (starter)",
                    warningOrRisksEn = "Chilling kills up to 40% of baby chicks in the first week.",
                    warningOrRisksRw = "Ubukonje bwica imishwi ku kigero kigera kuri 40% mu cyumweru cya mbere."
                ),
                GrowthStageStep(
                    stageNumber = 2,
                    stageNameEn = "Mandatory Vaccination Schedule",
                    stageNameRw = "Gahunda y'Inkingo z'Inkoko (Newcastle na Gumboro)",
                    durationTextEn = "Days 7 - 28",
                    durationTextRw = "Iminsi 7 - 28",
                    descriptionEn = "Day 7: Newcastle (Hitchner B1) eye drop or drinking water. Day 14: Gumboro (Infectious Bursal Disease). Day 21: Newcastle Booster (LaSota). Day 28: Gumboro Booster.",
                    descriptionRw = "Umunsi wa 7: Urukingo rw'Ibicurane by'inkoko (Newcastle). Umunsi wa 14: Urukingo rwa Gumboro. Umunsi wa 21: Gusubiramo Newcastle (LaSota). Umunsi wa 28: Gusubiramo Gumboro.",
                    keyPracticesEn = listOf(
                        "Mix vaccine only in chlorine-free, unchlorinated well/spring water with skimmed milk powder",
                        "Withdraw water for 2 hours beforehand so flock drinks vaccine within 90 minutes",
                        "Keep vaccine vials cold on ice packs until mixing"
                    ),
                    keyPracticesRw = listOf(
                        "Vanga urukingo mu mazi adafite umuti wa chlorine urimo ifu y'amata y'ifu",
                        "Yime amazi amasaha 2 mbere ngo inywe urukingo vuba mu minota 90",
                        "Bika urukingo kuri barafoni (ice) kugeza ugiye kurutera"
                    ),
                    inputSuppliesNeededEn = "Newcastle & Gumboro vaccines (from vet pharmacy), skimmed milk powder, cooler box",
                    inputSuppliesNeededRw = "Inkingo za Newcastle na Gumboro, amata y'ifu, agasanduku kabika barafoni",
                    warningOrRisksEn = "Using tap water with chlorine kills the live vaccine virus completely.",
                    warningOrRisksRw = "Gukoresha amazi ya robinet arimo chlorine yica urukingo rugapfa ubusa."
                ),
                GrowthStageStep(
                    stageNumber = 3,
                    stageNameEn = "Biosecurity, Nutrition & Disease Prevention",
                    stageNameRw = "Ubuziranenge, Isuku n'Imirire Yuzuye",
                    durationTextEn = "Grower to Laying Cycle",
                    durationTextRw = "Kuva ikura kugeza itangiye gutera amagi",
                    descriptionEn = "Maintain disinfectant footbath at poultry door (Virukill or local caustic soda). Prevent wild birds and rodents from feed troughs. Introduce crushed oyster shells for strong eggshells in layers.",
                    descriptionRw = "Shyira umuti wica udukoko ku muryango w'ikiraro aho buri wese akandagira mbere yo kwinjira. Rinda inyoni zo hanze no gushyiramo ifu y'ibikonsho by'ibishishwa by'amagi (calcium).",
                    keyPracticesEn = listOf(
                        "Disinfectant footbath changed every 3 days",
                        "Keep litter dry; turn damp shavings to avoid coccidiosis",
                        "Provide 16 hours of daily light for laying hens"
                    ),
                    keyPracticesRw = listOf(
                        "Guhindura umuti w'ibirenge ku muryango buri minsi 3",
                        "Kureka hasi humye birinda indwara y'impiswi y'amaraso (Coccidiose)",
                        "Kumurikira inkoko z'amagi amasaha 16 ku munsi zikabona amagi menshi"
                    ),
                    inputSuppliesNeededEn = "Footbath disinfectant, coccidiostat preventative, crushed oyster shell",
                    inputSuppliesNeededRw = "Umuti w'isuku ku birenge, umuti wa coccidiose, ibikonsho byasewe",
                    warningOrRisksEn = "Wet litter generates toxic ammonia fumes that cause blindness and respiratory infection.",
                    warningOrRisksRw = "Ibyatsi bitose hasi bizana umwuka mubi wa amoniya uhuma amaso y'inkoko ukayicisha ibihaha."
                )
            ),
            expertTipsEn = "Local agrodealers supply 50kg bags of balanced feeds (Gorillaz, Zamura). Keep feeding records daily: feed conversion ratio (FCR) is your primary profit indicator.",
            expertTipsRw = "Amaduka y'ubuhinzi acuruza ifu yuzuye (Zamura, Gorillaz). Bika amakuru y'ibiro by'ibiryo n'amagi bituma umenya inyungu yawe buri munsi."
        )
    )

    fun getGuideById(id: String): FarmGrowthGuide? {
        return GUIDES.find { it.id == id }
    }
}
