package com.example.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.HelpCenter
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.automirrored.outlined.HelpOutline
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.example.R
import com.example.data.model.CropDiagnosis
import com.example.data.repository.AgriKnowledgeBase
import com.example.data.repository.CrossHostDiseasesRepository
import com.example.data.repository.TreatmentCentersRepository
import com.example.ui.AgriDoctorViewModel
import com.example.ui.AppLanguage
import com.example.ui.components.AgrodealerCard
import com.example.ui.components.BlessingCard
import com.example.ui.components.CrossHostStudyDialog
import com.example.ui.components.FirstAidRemedyCard
import com.example.ui.components.SectionHeader
import com.example.ui.components.TreatmentCard
import com.example.ui.components.TreatmentPlacesDialog
import com.example.ui.theme.EarthTerracotta
import com.example.ui.theme.EmeraldGreen
import com.example.ui.theme.FarmSurfaceLight
import com.example.ui.theme.ForestGreen
import com.example.ui.theme.GeoBackground
import com.example.ui.theme.GeoBorderLight
import com.example.ui.theme.GeoCardWhite
import com.example.ui.theme.GeoChemical
import com.example.ui.theme.GeoOrganic
import com.example.ui.theme.GeoPrimary
import com.example.ui.theme.GeoSageBorder
import com.example.ui.theme.GeoSageContainer
import com.example.ui.theme.GeoTextDark
import com.example.ui.theme.LeafGreen
import com.example.ui.theme.MintLight
import com.example.ui.theme.SunAmber
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val POPULAR_CROPS = listOf(
    "Maize (Ibigori)",
    "Irish Potato (Ibirayi)",
    "Beans (Ibishyimbo)",
    "Banana (Ibitoki)",
    "Cassava (Imyumbati)",
    "Tomato (Inyanya)",
    "Coffee (Ikawa)",
    "Sweet Potato (Ibijumba)"
)

private val DUAL_HOST_STUDY_DISEASES = listOf(
    "Aflatoxin (Maize & Cattle/Poultry)",
    "Anthrax (Pasture Grass & Livestock)",
    "Fusarium (Grain & Swine/Cattle)",
    "Pseudomonas (Vegetables & Dairy Mastitis)",
    "Botulism (Silage & Animals)",
    "Ergot (Cereals & Livestock)"
)

private val RWANDA_LOCATIONS = listOf(
    "Musanze (Northern)",
    "Nyabihu (Western)",
    "Huye (Southern)",
    "Nyagatare (Eastern)",
    "Bugesera (Eastern)",
    "Rwamagana (Eastern)",
    "Rubavu (Western)",
    "Gicumbi (Northern)",
    "Rulindo (Northern)",
    "Nyanza (Southern)",
    "Kigali City"
)

private val COMMON_SYMPTOMS = listOf(
    "Yellow spots on leaves",
    "Caterpillars eating leaves",
    "Wilting after heavy rain",
    "White or grey mold",
    "Twisted mosaic leaves",
    "Dark spots on stem & pods"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgriDoctorScreen(
    viewModel: AgriDoctorViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    var showHistoryDialog by remember { mutableStateOf(false) }
    var tempCameraUri by remember { mutableStateOf<Uri?>(null) }
    var cropCategoryTab by remember { mutableStateOf(0) } // 0: Standard Crops, 1: Plant + Animal Diseases (Study)

    // Photo pickers
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            viewModel.onPhotoSelected(uri)
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success && tempCameraUri != null) {
            viewModel.onPhotoSelected(tempCameraUri)
        }
    }

    fun launchCamera() {
        try {
            val photoFile = File.createTempFile("crop_leaf_", ".jpg", context.cacheDir)
            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                photoFile
            )
            tempCameraUri = uri
            cameraLauncher.launch(uri)
        } catch (e: Exception) {
            // fallback to photo picker
            photoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    }

    val isRw = uiState.language == AppLanguage.KINYARWANDA || uiState.isKinyarwandaFocus

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(GeoPrimary),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Agriculture,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Agri-Doctor AI",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = if (isRw) {
                                    "${uiState.selectedLocation.ifBlank { "Kigali, Rwanda" }} • Muganga w'Ibihingwa".uppercase()
                                } else {
                                    "${uiState.selectedLocation.ifBlank { "Kigali, Rwanda" }} • Plant Health Specialist".uppercase()
                                },
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                letterSpacing = 0.6.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                actions = {
                    // Language Switcher (English vs Kinyarwanda Mode)
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .clickable { viewModel.toggleLanguage() }
                            .testTag("language_toggle_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 9.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Translate,
                                contentDescription = "Language Mode",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.size(15.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = if (isRw) "🇷🇼 RW" else "🇬🇧 EN",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    // Dark Mode / Light Mode Toggle
                    IconButton(
                        onClick = { viewModel.toggleDarkMode() },
                        modifier = Modifier.testTag("theme_toggle_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (uiState.isDarkMode) Icons.Default.LightMode else Icons.Default.DarkMode,
                                    contentDescription = if (uiState.isDarkMode) "Light Mode" else "Dark Mode",
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }

                    // Field History
                    IconButton(
                        onClick = { showHistoryDialog = true },
                        modifier = Modifier.testTag("history_button")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.History,
                                    contentDescription = "Saved Field Diagnoses",
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp),
                color = MaterialTheme.colorScheme.surface,
                border = CardDefaults.outlinedCardBorder().copy(
                    width = 1.dp,
                    brush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Home (Active)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clickable { /* Active home */ }
                            .weight(1f)
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 2.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(vertical = 1.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (isRw) "AHABANZA" else "HOME",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            letterSpacing = 0.4.sp
                        )
                    }

                    // Places & Hospitals (Agrodealers, Vets, Hospitals)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clickable { viewModel.openPlacesDialog() }
                            .weight(1f)
                            .testTag("nav_places_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Storefront,
                            contentDescription = "Places & Hospitals",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (isRw) "AMAVURIRO" else "CLINICS",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            letterSpacing = 0.4.sp
                        )
                    }

                    // Study (Plant & Animal Shared Pathogens)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clickable { viewModel.openStudyDialog() }
                            .weight(1f)
                            .testTag("nav_study_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Biotech,
                            contentDescription = "Plant & Animal Diseases Study",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (isRw) "INYIGISHO" else "STUDY",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            letterSpacing = 0.4.sp
                        )
                    }

                    // Records (History)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clickable { showHistoryDialog = true }
                            .weight(1f)
                            .testTag("nav_history_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "Records",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = if (isRw) "AMATEKA" else "HISTORY",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            letterSpacing = 0.4.sp
                        )
                    }

                    // Expert Hotline (Call RAB 114)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .clickable {
                                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
                                context.startActivity(intent)
                            }
                            .weight(1f)
                            .testTag("nav_hotline_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Expert Hotline",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "RAB 114",
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            letterSpacing = 0.4.sp
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Hero Banner
            item {
                HeroBanner(
                    isKinyarwanda = isRw,
                    onCallRAB = {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
                        context.startActivity(intent)
                    },
                    onOpenPlaces = { viewModel.openPlacesDialog() },
                    onOpenStudy = { viewModel.openStudyDialog() }
                )
            }

            // 2. Input Form Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("input_form_card"),
                    shape = RoundedCornerShape(28.dp),
                    colors = CardDefaults.cardColors(containerColor = GeoCardWhite),
                    border = CardDefaults.outlinedCardBorder().copy(
                        width = 1.dp,
                        brush = androidx.compose.ui.graphics.SolidColor(GeoBorderLight)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        SectionHeader(
                            title = "1. Ifoto y'Igihingwa (Crop Photo)",
                            subtitle = "Fata ifoto y'amababi, umuti, cyangwa igihingwa cyose",
                            icon = Icons.Default.CameraAlt
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        // Selected Photo preview with Geometric Balance framing
                        if (uiState.selectedPhotoUri != null) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(230.dp)
                                    .clip(RoundedCornerShape(32.dp))
                                    .background(Color.White)
                                    .border(4.dp, Color.White, RoundedCornerShape(32.dp))
                            ) {
                                AsyncImage(
                                    model = uiState.selectedPhotoUri,
                                    contentDescription = "Selected crop photo",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(28.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                // Viewfinder dashed overlay
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                        .border(
                                            width = 1.5.dp,
                                            color = Color.White.copy(alpha = 0.55f),
                                            shape = RoundedCornerShape(18.dp)
                                        )
                                )

                                // Analysis status pill
                                Surface(
                                    color = Color.Black.copy(alpha = 0.45f),
                                    shape = RoundedCornerShape(20.dp),
                                    border = CardDefaults.outlinedCardBorder().copy(
                                        width = 1.dp,
                                        brush = androidx.compose.ui.graphics.SolidColor(Color.White.copy(alpha = 0.25f))
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                        .padding(14.dp)
                                ) {
                                    Text(
                                        text = "Photo Analysis Ready",
                                        color = Color.White,
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                                    )
                                }

                                IconButton(
                                    onClick = { viewModel.onPhotoSelected(null) },
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(12.dp)
                                        .background(Color.Black.copy(alpha = 0.55f), CircleShape)
                                        .size(34.dp)
                                        .testTag("remove_photo_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove photo",
                                        tint = Color.White,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        } else {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                OutlinedButton(
                                    onClick = { launchCamera() },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(52.dp)
                                        .testTag("camera_button"),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = GeoPrimary
                                    ),
                                    border = ButtonDefaults.outlinedButtonBorder.copy(
                                        brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
                                    )
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CameraAlt,
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = GeoPrimary
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Camera", fontWeight = FontWeight.Bold)
                                }

                                Button(
                                    onClick = {
                                        photoPickerLauncher.launch(
                                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                        )
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(52.dp)
                                        .testTag("gallery_button"),
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = GeoPrimary
                                    )
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.AddPhotoAlternate,
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp),
                                        tint = Color.White
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Gallery", fontWeight = FontWeight.Bold, color = Color.White)
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            // Quick test samples
                            Text(
                                text = "Cyangwa koresha ingero z'ifoto (Quick field samples):",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF64748B),
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        val sample = AgriKnowledgeBase.SAMPLE_DIAGNOSES[0]
                                        val sampleUri = Uri.parse("android.resource://${context.packageName}/${R.drawable.sample_maize_pest}")
                                        viewModel.selectSample(sample, sampleUri)
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("sample_maize_button"),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                                    border = ButtonDefaults.outlinedButtonBorder.copy(
                                        brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
                                    )
                                ) {
                                    Text("🌽 Ibigori (Maize)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = GeoPrimary)
                                }

                                OutlinedButton(
                                    onClick = {
                                        val sample = AgriKnowledgeBase.SAMPLE_DIAGNOSES[1]
                                        val sampleUri = Uri.parse("android.resource://${context.packageName}/${R.drawable.sample_potato_blight}")
                                        viewModel.selectSample(sample, sampleUri)
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .testTag("sample_potato_button"),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp),
                                    border = ButtonDefaults.outlinedButtonBorder.copy(
                                        brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
                                    )
                                ) {
                                    Text("🥔 Ibirayi (Potato)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = GeoPrimary)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(18.dp))
                        HorizontalDivider(color = GeoBorderLight)
                        Spacer(modifier = Modifier.height(16.dp))

                        // 2. Crop / Plant-Animal Disease Selector
                        SectionHeader(
                            title = "2. Igihingwa cyangwa Indwara (Target / Study)",
                            subtitle = if (cropCategoryTab == 0) "Hitamo ubwoko bw'igihingwa cyawe" else "Indwara zifatira hamwe ibihingwa n'amatungo (One-Health)",
                            icon = if (cropCategoryTab == 0) Icons.Default.Eco else Icons.Default.Biotech
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Category Tabs: Standard Crops vs Dual Plant-Animal Study
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            FilterChip(
                                selected = cropCategoryTab == 0,
                                onClick = { cropCategoryTab = 0 },
                                label = {
                                    Text(
                                        "🌱 Ibihingwa (Crops)",
                                        fontSize = 12.sp,
                                        fontWeight = if (cropCategoryTab == 0) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                shape = RoundedCornerShape(14.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = GeoPrimary,
                                    selectedLabelColor = Color.White
                                )
                            )

                            FilterChip(
                                selected = cropCategoryTab == 1,
                                onClick = { cropCategoryTab = 1 },
                                label = {
                                    Text(
                                        "🔬 Ibihingwa + Amatungo (Study)",
                                        fontSize = 12.sp,
                                        fontWeight = if (cropCategoryTab == 1) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                shape = RoundedCornerShape(14.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = GeoChemical,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }

                        // Study Hub Quick Shortcut if on dual host tab
                        if (cropCategoryTab == 1) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Surface(
                                color = GeoSageContainer.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { viewModel.openStudyDialog() }
                            ) {
                                Row(
                                    modifier = Modifier.padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.School,
                                        contentDescription = null,
                                        tint = GeoPrimary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "📖 Fungura Ishakiro ry'Inyigisho (Open Full Study Hub & Cycles) →",
                                        style = MaterialTheme.typography.labelMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = GeoPrimary,
                                        fontSize = 11.5.sp
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        val currentActiveList = if (cropCategoryTab == 0) POPULAR_CROPS else DUAL_HOST_STUDY_DISEASES
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.testTag("crop_selector_row")
                        ) {
                            items(currentActiveList) { crop ->
                                val isSelected = uiState.selectedCrop == crop
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { viewModel.onCropChanged(crop) },
                                    label = { Text(crop, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = if (cropCategoryTab == 0) GeoSageContainer else Color(0xFFFBEBEB),
                                        selectedLabelColor = if (cropCategoryTab == 0) GeoPrimary else GeoChemical,
                                        containerColor = GeoBackground,
                                        labelColor = GeoTextDark
                                    ),
                                    border = FilterChipDefaults.filterChipBorder(
                                        enabled = true,
                                        selected = isSelected,
                                        borderColor = if (isSelected) (if (cropCategoryTab == 0) GeoSageBorder else GeoChemical) else GeoBorderLight
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // 3. Location Selector
                        SectionHeader(
                            title = "3. Aho uri (Location in Rwanda)",
                            subtitle = "Akarere cyangwa Intara bikorerwamo",
                            icon = Icons.Default.LocationOn
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.testTag("location_selector_row")
                        ) {
                            items(RWANDA_LOCATIONS) { loc ->
                                val isSelected = uiState.selectedLocation == loc
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { viewModel.onLocationChanged(loc) },
                                    label = { Text(loc, fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal) },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = GeoSageContainer,
                                        selectedLabelColor = GeoPrimary,
                                        containerColor = GeoBackground,
                                        labelColor = GeoTextDark
                                    ),
                                    border = FilterChipDefaults.filterChipBorder(
                                        enabled = true,
                                        selected = isSelected,
                                        borderColor = if (isSelected) GeoSageBorder else GeoBorderLight
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // 4. Problem Description
                        SectionHeader(
                            title = "4. Ibisobanuro by'Ikibazo (Problem Description)",
                            subtitle = "Icyo ubona ku mababi, ku giti, cyangwa imbuto",
                            icon = Icons.AutoMirrored.Outlined.HelpOutline
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        // Quick symptom pills
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(COMMON_SYMPTOMS) { symptom ->
                                Surface(
                                    color = GeoSageContainer,
                                    shape = RoundedCornerShape(16.dp),
                                    modifier = Modifier
                                        .clickable {
                                            val current = uiState.problemDescription
                                            val updated = if (current.isBlank()) symptom else "$current, $symptom"
                                            viewModel.onProblemDescriptionChanged(updated)
                                        }
                                ) {
                                    Text(
                                        text = "+ $symptom",
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = GeoPrimary
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = uiState.problemDescription,
                            onValueChange = { viewModel.onProblemDescriptionChanged(it) },
                            placeholder = { Text("Sobanura ibimenyetso ubona (urugero: amababi yafashwe n'ububore cyangwa ibihumyo...)") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("problem_description_input"),
                            shape = RoundedCornerShape(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = GeoPrimary,
                                unfocusedBorderColor = GeoSageBorder,
                                focusedContainerColor = GeoBackground.copy(alpha = 0.5f),
                                unfocusedContainerColor = GeoBackground.copy(alpha = 0.5f)
                            ),
                            minLines = 2,
                            maxLines = 4
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Diagnose Button
                        Button(
                            onClick = { viewModel.diagnose() },
                            enabled = !uiState.isDiagnosing,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp)
                                .testTag("diagnose_button"),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GeoPrimary,
                                disabledContainerColor = GeoPrimary.copy(alpha = 0.5f)
                            ),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
                        ) {
                            if (uiState.isDiagnosing) {
                                CircularProgressIndicator(
                                    color = Color.White,
                                    modifier = Modifier.size(24.dp),
                                    strokeWidth = 2.5.dp
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "Agri-Doctor arasuzuma... (Analyzing)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Psychology,
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "VURA IGIHINGWA (Diagnose Crop)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 0.5.sp
                                )
                            }
                        }
                    }
                }
            }

            // Info notice if any
            if (uiState.infoMessage != null) {
                item {
                    Surface(
                        color = MintLight,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = ForestGreen,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = uiState.infoMessage ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = ForestGreen
                            )
                        }
                    }
                }
            }

            // 3. Results Section
            val currentDiag = uiState.currentDiagnosis
            if (currentDiag != null) {
                item {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn() + slideInVertically()
                    ) {
                        DiagnosisResultCard(
                            diagnosis = currentDiag,
                            isKinyarwandaFocus = uiState.isKinyarwandaFocus,
                            isSpeaking = uiState.isSpeaking,
                            onSpeakToggle = { viewModel.speakDiagnosis() },
                            onOpenPlaces = { viewModel.openPlacesDialog() },
                            onOpenStudy = { viewModel.openStudyDialog() }
                        )
                    }
                }
            }
        }
    }

    // History Dialog
    if (showHistoryDialog) {
        HistoryDialog(
            history = uiState.history,
            onDismiss = { showHistoryDialog = false },
            onSelectDiagnosis = { diag ->
                viewModel.viewDiagnosis(diag)
                showHistoryDialog = false
            },
            onDeleteDiagnosis = { id ->
                viewModel.deleteHistoryItem(id)
            }
        )
    }

    // Treatment Places & Hospitals Directory Dialog
    if (uiState.showPlacesDialog) {
        TreatmentPlacesDialog(
            initialType = uiState.selectedCenterType,
            onDismiss = { viewModel.closePlacesDialog() }
        )
    }

    // Cross-Host Plant & Animal Disease Study Dialog
    if (uiState.showStudyDialog) {
        CrossHostStudyDialog(
            onDismiss = { viewModel.closeStudyDialog() },
            onSelectDiseaseToDiagnose = { disease ->
                viewModel.loadCrossHostStudyItem(disease)
            }
        )
    }
}

@Composable
fun HeroBanner(
    onCallRAB: () -> Unit,
    onOpenPlaces: () -> Unit,
    onOpenStudy: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("hero_banner_card"),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = GeoPrimary),
        border = CardDefaults.outlinedCardBorder().copy(
            width = 1.dp,
            brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hero_rwanda_farm),
                    contentDescription = "Rwanda Terraced Hills Farmland",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    GeoPrimary.copy(alpha = 0.96f)
                                )
                            )
                        )
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = GeoSageContainer,
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "🇷🇼 RWANDA & EAST AFRICA",
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.ExtraBold,
                            color = GeoPrimary,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Muganga w'Ibihingwa byawe mu Rwanda",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Gusuzuma indwara z'ibihingwa, umuti gakondo, uwa kizungu n'aho ugurirwa mu karere kanyu.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = GeoSageContainer.copy(alpha = 0.95f),
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rwanda Agriculture Board:",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                    OutlinedButton(
                        onClick = onCallRAB,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White
                        ),
                        border = ButtonDefaults.outlinedButtonBorder.copy(
                            brush = androidx.compose.ui.graphics.SolidColor(Color.White.copy(alpha = 0.6f))
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 5.dp),
                        modifier = Modifier.testTag("hotline_call_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp),
                            tint = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Hotline 114 (Tolero)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Shortcuts for Places Directory and Study Guide
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Surface(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onOpenPlaces() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Storefront,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Column {
                                Text(
                                    text = "AMAVURIRO / PLACES",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                                Text(
                                    text = "Agrodealers & Vets",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    Surface(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onOpenStudy() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Biotech,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Column {
                                Text(
                                    text = "INYIGISHO / STUDY",
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                                Text(
                                    text = "Plant & Animal",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiagnosisResultCard(
    diagnosis: CropDiagnosis,
    isKinyarwandaFocus: Boolean,
    isSpeaking: Boolean,
    onSpeakToggle: () -> Unit,
    onOpenPlaces: () -> Unit = {},
    onOpenStudy: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .testTag("diagnosis_result_section"),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Unclear photo banner if applicable
        if (!diagnosis.isPhotoClear && !diagnosis.clarificationNeeded.isNullOrBlank()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("unclear_photo_alert"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3CD)),
                border = CardDefaults.outlinedCardBorder().copy(width = 1.dp, brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFE0A800)))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = Color(0xFF856404),
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Ifoto ntabwo igaragara neza (Photo Unclear)",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF856404)
                        )
                        Text(
                            text = diagnosis.clarificationNeeded,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF856404)
                        )
                    }
                }
            }
        }

        // Low confidence warning (<80% rule)
        if (diagnosis.isLowConfidence || diagnosis.confidence < 80) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("low_confidence_alert"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFBEBEB)),
                border = CardDefaults.outlinedCardBorder().copy(width = 1.dp, brush = androidx.compose.ui.graphics.SolidColor(GeoChemical.copy(alpha = 0.5f)))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = null,
                        tint = GeoChemical,
                        modifier = Modifier.size(26.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "This looks like ${diagnosis.diseaseNameEn}, but I recommend asking your local agronomist (Agronome w'Umurenge) to confirm.",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = GeoChemical
                    )
                }
            }
        }

        // Main Diagnosis Card (Geometric Balance aesthetic)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("main_diagnosis_card"),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = GeoSageContainer),
            border = CardDefaults.outlinedCardBorder().copy(
                width = 1.dp,
                brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Header with Disease Badge & TTS Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = diagnosis.diseaseNameEn,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = GeoTextDark
                            )
                            Surface(
                                color = GeoPrimary,
                                shape = RoundedCornerShape(6.dp)
                            ) {
                                Text(
                                    text = "DISEASE",
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = diagnosis.diseaseNameRw,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic,
                            color = GeoPrimary
                        )
                    }

                    // TTS button
                    OutlinedButton(
                        onClick = onSpeakToggle,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = GeoCardWhite,
                            contentColor = GeoPrimary
                        ),
                        border = ButtonDefaults.outlinedButtonBorder.copy(
                            brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
                        ),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                        modifier = Modifier.testTag("speak_button")
                    ) {
                        Icon(
                            imageVector = if (isSpeaking) Icons.Default.Stop else Icons.Default.PlayArrow,
                            contentDescription = "Speak diagnosis",
                            tint = if (isSpeaking) GeoChemical else GeoPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = if (isSpeaking) "Stop" else "Umva",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSpeaking) GeoChemical else GeoPrimary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Observation & Cause description in clear typography
                Text(
                    text = diagnosis.causeExplanation.ifBlank { diagnosis.visualObservation },
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF334155),
                    lineHeight = 20.sp
                )

                if (diagnosis.causeExplanation.isNotBlank() && diagnosis.visualObservation.isNotBlank()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Icyo tubona: ${diagnosis.visualObservation}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF475569),
                        lineHeight = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Confidence indicator pill
                Surface(
                    color = Color.White.copy(alpha = 0.8f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "ICYIZERE: ${diagnosis.confidence}% CONFIDENCE",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = GeoPrimary
                    )
                }
            }
        }

        // 3 Practical Treatment Options (Prompt Mandatory)
        SectionHeader(
            title = "UBURYO 3 BWO KUVURA (3 Practical Treatments)",
            subtitle = "Hitamo uburyo bukubereye bitewe n'ibyo ufite",
            icon = Icons.Default.Eco
        )

        // Treatment 1: Organic / Home Remedy
        TreatmentCard(
            tagNumber = 1,
            titleEn = "Organic / Home Remedy",
            titleRw = "Umuti Gakondo / Ibyo ufite mu rugo",
            description = diagnosis.organicRemedy,
            icon = Icons.Default.Eco,
            containerColor = GeoCardWhite,
            accentColor = GeoOrganic,
            testTag = "organic_remedy_card"
        )

        // Treatment 2: Low-Cost Chemical Solution + Exact Dosage per 20L Sprayer
        TreatmentCard(
            tagNumber = 2,
            titleEn = "Low-Cost Chemical + Exact 20L Dosage",
            titleRw = "Umuti wa Kizungu n'Igipimo muri Litiro 20",
            description = diagnosis.chemicalSolution,
            icon = Icons.Default.Science,
            containerColor = GeoCardWhite,
            accentColor = GeoChemical,
            testTag = "chemical_treatment_card"
        )

        // Treatment 3: Prevention Tips for Next Season
        TreatmentCard(
            tagNumber = 3,
            titleEn = "Prevention for Next Season",
            titleRw = "Kwirinda mu Gihembwe Gitaha",
            description = diagnosis.preventionTips,
            icon = Icons.Default.Shield,
            containerColor = GeoCardWhite,
            accentColor = GeoOrganic,
            testTag = "prevention_tips_card"
        )

        // Animal Health Impact (if cross-host pathogen like Aflatoxin, Anthrax, Fusarium)
        if (!diagnosis.animalImpact.isNullOrBlank()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenStudy() }
                    .testTag("animal_health_impact_card"),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFBEBEB)),
                border = CardDefaults.outlinedCardBorder().copy(
                    width = 1.dp,
                    brush = androidx.compose.ui.graphics.SolidColor(GeoChemical.copy(alpha = 0.45f))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(GeoChemical.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Biotech,
                                contentDescription = null,
                                tint = GeoChemical,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "INGARUKA KU MATUNGO • ANIMAL HEALTH IMPACT",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.ExtraBold,
                                color = GeoChemical,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = "Ubwirinde mu biryo by'amatungo",
                                style = MaterialTheme.typography.bodySmall,
                                color = GeoChemical.copy(alpha = 0.8f)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = diagnosis.animalImpact ?: "",
                        style = MaterialTheme.typography.bodyMedium,
                        color = GeoTextDark,
                        lineHeight = 21.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                        color = GeoChemical.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Iga uburyo iyi ndwara yandura (Study Life Cycle)",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = GeoChemical,
                                fontSize = 11.sp
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                tint = GeoChemical,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        }

        // Localization: Agrodealer, Vet Clinics & Hospitals (Clickable to open Directory)
        AgrodealerCard(
            content = diagnosis.localAgrodealers,
            onClick = onOpenPlaces
        )

        // Mandatory Closing Blessing Rule
        BlessingCard(blessingText = diagnosis.closingBlessing)
    }
}

@Composable
fun HistoryDialog(
    history: List<CropDiagnosis>,
    onDismiss: () -> Unit,
    onSelectDiagnosis: (CropDiagnosis) -> Unit,
    onDeleteDiagnosis: (Long) -> Unit
) {
    val dateFormat = remember { SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        shape = RoundedCornerShape(24.dp),
        containerColor = GeoCardWhite,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    color = GeoSageContainer,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = null,
                            tint = GeoPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Amateka y'Ibisuzumwa",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = GeoTextDark
                )
            }
        },
        text = {
            if (history.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Agriculture,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Nta bisuzumwa bibitse biraboneka.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(history) { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onSelectDiagnosis(item) },
                            colors = CardDefaults.cardColors(containerColor = GeoSageContainer),
                            shape = RoundedCornerShape(16.dp),
                            border = CardDefaults.outlinedCardBorder().copy(
                                width = 1.dp,
                                brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "${item.cropName}: ${item.diseaseNameEn}",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = GeoTextDark
                                    )
                                    Text(
                                        text = item.diseaseNameRw,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.SemiBold,
                                        fontStyle = FontStyle.Italic,
                                        color = GeoPrimary
                                    )
                                    Text(
                                        text = "${item.location} • ${dateFormat.format(Date(item.timestamp))}",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color(0xFF64748B)
                                    )
                                }
                                IconButton(
                                    onClick = { onDeleteDiagnosis(item.id) },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Delete,
                                        contentDescription = "Delete",
                                        tint = Color(0xFF94A3B8),
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Funga (Close)", fontWeight = FontWeight.Bold, color = GeoPrimary)
            }
        }
    )
}
