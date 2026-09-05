package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.CrossHostDisease
import com.example.data.repository.CrossHostDiseasesRepository
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrossHostStudyDialog(
    onDismiss: () -> Unit,
    onSelectDiseaseToDiagnose: (CrossHostDisease) -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val diseases = remember(searchQuery) {
        CrossHostDiseasesRepository.searchDiseases(searchQuery)
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.92f)
                .testTag("cross_host_study_dialog"),
            shape = RoundedCornerShape(28.dp),
            color = GeoBackground,
            border = CardDefaults.outlinedCardBorder().copy(
                width = 1.dp,
                brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
            ),
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            color = GeoChemical,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Biotech,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Study: Plant & Animal Diseases",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = GeoTextDark
                            )
                            Text(
                                text = "Indwara Zifatira Hamwe Ibihingwa n'Amatungo",
                                style = MaterialTheme.typography.labelSmall,
                                color = GeoChemical,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color(0xFF64748B)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Informational study notice
                Surface(
                    color = GeoSageContainer.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = GeoPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Cross-Kingdom Pathogens: Organisms that bridge agriculture and veterinary health, transmitting mycotoxins or bacteria between crop fields, animal feed, livestock, and humans.",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.5.sp,
                            color = GeoTextDark,
                            lineHeight = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Search field
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            text = "Search (Aflatoxin, Anthrax, Fusarium, Inka...)",
                            fontSize = 13.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = GeoPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    },
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = GeoCardWhite,
                        unfocusedContainerColor = GeoCardWhite,
                        focusedBorderColor = GeoPrimary,
                        unfocusedBorderColor = GeoBorderLight
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("cross_host_search_input"),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(14.dp))

                // Disease Study Cards
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(diseases, key = { it.id }) { disease ->
                        StudyDiseaseCard(
                            disease = disease,
                            onDiagnose = {
                                onSelectDiseaseToDiagnose(disease)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StudyDiseaseCard(
    disease: CrossHostDisease,
    onDiagnose: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("study_card_${disease.id}"),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(containerColor = GeoCardWhite),
        border = CardDefaults.outlinedCardBorder().copy(
            width = 1.dp,
            brush = androidx.compose.ui.graphics.SolidColor(GeoSageBorder)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Row: Category Badge + Dual Host Indicator
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = GeoChemical.copy(alpha = 0.12f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = disease.pathogenCategory.uppercase(),
                        color = GeoChemical,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        fontSize = 9.sp,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Surface(
                    color = GeoOrganic.copy(alpha = 0.12f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "🌾 Plant + 🐄 Animal",
                        color = GeoOrganic,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Disease Name
            Text(
                text = disease.nameEn,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = GeoTextDark
            )
            Text(
                text = disease.nameRw,
                style = MaterialTheme.typography.bodySmall,
                color = GeoPrimary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = disease.scientificName,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF64748B),
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Hosts Summary Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Plant hosts
                Surface(
                    color = GeoSageContainer,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "🌾 Crops Affected:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = GeoPrimary
                        )
                        Text(
                            text = disease.plantHosts.joinToString(", "),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = GeoTextDark
                        )
                    }
                }

                // Animal hosts
                Surface(
                    color = GeoSageContainer,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "🐄 Animals Affected:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = GeoOrganic
                        )
                        Text(
                            text = disease.animalHosts.joinToString(", "),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.sp,
                            color = GeoTextDark
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Short summary in Kinyarwanda
            Surface(
                color = GeoBackground,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = disease.studySummaryRw,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 11.5.sp,
                    color = GeoTextDark,
                    modifier = Modifier.padding(10.dp)
                )
            }

            if (expanded) {
                Spacer(modifier = Modifier.height(12.dp))

                // Section: Symptoms on Plants
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(GeoSageContainer.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "1. Ibimenyetso ku Bihingwa (Symptoms on Crops):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = GeoPrimary
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = disease.plantSymptoms,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = GeoTextDark
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Section: Symptoms on Animals
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(GeoSageContainer.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "2. Ibimenyetso mu Matungo (Symptoms in Livestock):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = GeoOrganic
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = disease.animalSymptoms,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = GeoTextDark
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Section: Transmission Cycle
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(GeoSageContainer.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "3. Uko Byandura hagati y'Ibihingwa n'Amatungo (Cycle):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFB45309)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = disease.crossTransmissionCycle,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = GeoTextDark
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Section: Treatment & Places
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(GeoSageContainer.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "4. Aho Wagura n'Ubuvuzi (Treatments & Places):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = GeoChemical
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = disease.recommendedSuppliersAndHospitals,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 11.5.sp,
                        color = GeoTextDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action Buttons: Expand/Collapse & Load into Doctor
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = { expanded = !expanded },
                    contentPadding = PaddingValues(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = if (expanded) "Hisha Ibisobanuro ▲" else "Reba Ibisobanuro Byose ▼",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = GeoPrimary
                    )
                }

                Button(
                    onClick = onDiagnose,
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GeoPrimary),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Biotech,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Suzuma muri Agri-Doctor",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
