package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Biotech
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Healing
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.data.model.ComprehensiveDisease
import com.example.data.model.DiseaseDomain
import com.example.data.repository.ComprehensiveDiseaseRepository
import com.example.ui.theme.EmeraldGreen
import com.example.ui.theme.GeoChemical
import com.example.ui.theme.GeoOrganic
import com.example.ui.theme.GeoPrimary
import com.example.ui.theme.LeafGreen

@Composable
fun DiseaseEncyclopediaDialog(
    isOpen: Boolean,
    isKinyarwanda: Boolean,
    onDismiss: () -> Unit,
    onOpenMedicalMap: (district: String?) -> Unit
) {
    if (!isOpen) return

    var selectedDomain by remember { mutableStateOf<DiseaseDomain?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    var expandedDiseaseId by remember { mutableStateOf<String?>("plant_late_blight") }

    val diseases = remember(selectedDomain, searchQuery) {
        ComprehensiveDiseaseRepository.search(searchQuery, selectedDomain)
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .padding(vertical = 20.dp)
                .testTag("disease_encyclopedia_dialog"),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Dialog Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(GeoPrimary.copy(alpha = 0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Biotech,
                                contentDescription = null,
                                tint = GeoPrimary,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (isKinyarwanda) "Indwara z'Ibihingwa n'Amatungo" else "Disease Causes, Prevention & Treatments",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (isKinyarwanda) "Impamvu, ibimenyetso, kwirinda n'imiti ya gakondo n'iya kizungu" else "Comprehensive plant & animal pathology manual",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            text = if (isKinyarwanda) "Shakisha indwara, igihingwa cyangwa itungo..." else "Search by disease, crop, animal or symptom...",
                            fontSize = 12.sp
                        )
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("disease_search_field"),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Domain Filter Chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = selectedDomain == null,
                        onClick = { selectedDomain = null },
                        label = { Text(if (isKinyarwanda) "Byose (${ComprehensiveDiseaseRepository.diseases.size})" else "All") },
                        shape = RoundedCornerShape(12.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = GeoPrimary,
                            selectedLabelColor = Color.White
                        )
                    )

                    FilterChip(
                        selected = selectedDomain == DiseaseDomain.PLANT,
                        onClick = { selectedDomain = DiseaseDomain.PLANT },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Eco, contentDescription = null, modifier = Modifier.size(16.dp))
                        },
                        label = { Text(if (isKinyarwanda) "Ibihingwa (Plants)" else "Crops") },
                        shape = RoundedCornerShape(12.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = EmeraldGreen,
                            selectedLabelColor = Color.White
                        )
                    )

                    FilterChip(
                        selected = selectedDomain == DiseaseDomain.ANIMAL,
                        onClick = { selectedDomain = DiseaseDomain.ANIMAL },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Pets, contentDescription = null, modifier = Modifier.size(16.dp))
                        },
                        label = { Text(if (isKinyarwanda) "Amatungo (Animals)" else "Livestock") },
                        shape = RoundedCornerShape(12.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFFC2410C),
                            selectedLabelColor = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Disease List
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(diseases, key = { it.id }) { disease ->
                        val isExpanded = expandedDiseaseId == disease.id
                        val domainColor = if (disease.domain == DiseaseDomain.PLANT) EmeraldGreen else Color(0xFFC2410C)

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    expandedDiseaseId = if (isExpanded) null else disease.id
                                },
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isExpanded) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f) else MaterialTheme.colorScheme.surface
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                width = 1.dp,
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isExpanded) domainColor else MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(34.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(domainColor.copy(alpha = 0.15f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = if (disease.domain == DiseaseDomain.PLANT) Icons.Default.Eco else Icons.Default.Pets,
                                                contentDescription = null,
                                                tint = domainColor,
                                                modifier = Modifier.size(18.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column {
                                            Text(
                                                text = if (isKinyarwanda) disease.nameRw else disease.nameEn,
                                                style = MaterialTheme.typography.titleSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Text(
                                                text = disease.affectedHosts,
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }

                                    Icon(
                                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                        contentDescription = "Expand",
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                AnimatedVisibility(visible = isExpanded) {
                                    Column(modifier = Modifier.padding(top = 14.dp)) {
                                        // Causative agent
                                        Surface(
                                            color = domainColor.copy(alpha = 0.1f),
                                            shape = RoundedCornerShape(10.dp),
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(
                                                text = "Microorganism: ${disease.scientificOrCausativeAgent}",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = domainColor,
                                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        // 1. Causes
                                        Column {
                                            Text(
                                                text = if (isKinyarwanda) "1. Impamvu z'iyi ndwara (Causes):" else "1. Causes & Transmission Vectors:",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.5.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = if (isKinyarwanda) disease.causesRw else disease.causesEn,
                                                style = MaterialTheme.typography.bodySmall,
                                                lineHeight = 19.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        // 2. Symptoms
                                        Column {
                                            Text(
                                                text = if (isKinyarwanda) "2. Ibimenyetso biboneka (Symptoms):" else "2. Observable Symptoms:",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.5.sp,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = if (isKinyarwanda) disease.symptomsRw else disease.symptomsEn,
                                                style = MaterialTheme.typography.bodySmall,
                                                lineHeight = 19.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(10.dp))

                                        // 3. Preventions
                                        Column {
                                            Text(
                                                text = if (isKinyarwanda) "3. Uburyo bwo Kwirinda (Prevention Protocols):" else "3. Prevention & Biosecurity Protocols:",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 12.5.sp,
                                                color = EmeraldGreen
                                            )
                                            Spacer(modifier = Modifier.height(3.dp))
                                            Text(
                                                text = if (isKinyarwanda) disease.preventionsRw else disease.preventionsEn,
                                                style = MaterialTheme.typography.bodySmall,
                                                lineHeight = 19.sp,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                        }

                                        Spacer(modifier = Modifier.height(12.dp))

                                        // 4. Treatments: Organic vs Certified Chemical
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            // Organic
                                            Surface(
                                                color = GeoOrganic.copy(alpha = 0.12f),
                                                shape = RoundedCornerShape(14.dp),
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Column(modifier = Modifier.padding(10.dp)) {
                                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                                        Icon(imageVector = Icons.Default.Eco, contentDescription = null, tint = GeoOrganic, modifier = Modifier.size(14.dp))
                                                        Spacer(modifier = Modifier.width(4.dp))
                                                        Text(
                                                            text = if (isKinyarwanda) "Umuti Gakondo" else "Organic / Home Remedy",
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = 11.sp,
                                                            color = GeoOrganic
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.height(4.dp))
                                                    Text(
                                                        text = if (isKinyarwanda) disease.organicTreatmentsRw else disease.organicTreatmentsEn,
                                                        fontSize = 11.sp,
                                                        lineHeight = 16.sp,
                                                        color = MaterialTheme.colorScheme.onSurface
                                                    )
                                                }
                                            }

                                            // Chemical / Vet
                                            Surface(
                                                color = GeoChemical.copy(alpha = 0.12f),
                                                shape = RoundedCornerShape(14.dp),
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Column(modifier = Modifier.padding(10.dp)) {
                                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                                        Icon(imageVector = Icons.Default.Medication, contentDescription = null, tint = GeoChemical, modifier = Modifier.size(14.dp))
                                                        Spacer(modifier = Modifier.width(4.dp))
                                                        Text(
                                                            text = if (isKinyarwanda) "Umuti wa Kizungu" else "Certified Agrochemical / Vet",
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = 11.sp,
                                                            color = GeoChemical
                                                        )
                                                    }
                                                    Spacer(modifier = Modifier.height(4.dp))
                                                    Text(
                                                        text = if (isKinyarwanda) disease.chemicalTreatmentsRw else disease.chemicalTreatmentsEn,
                                                        fontSize = 11.sp,
                                                        lineHeight = 16.sp,
                                                        color = MaterialTheme.colorScheme.onSurface
                                                    )
                                                }
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(12.dp))

                                        // Required Medical Supplies
                                        Surface(
                                            color = MaterialTheme.colorScheme.surfaceVariant,
                                            shape = RoundedCornerShape(12.dp),
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Column(modifier = Modifier.padding(10.dp)) {
                                                Text(
                                                    text = if (isKinyarwanda) "Ibikoresho n'Imiti bikenewe ku Murima:" else "Required Supplies & Agrochemicals:",
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 11.5.sp,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                                Spacer(modifier = Modifier.height(4.dp))
                                                Text(
                                                    text = disease.requiredMedicalSupplies.joinToString(" • "),
                                                    fontSize = 11.sp,
                                                    fontWeight = FontWeight.SemiBold,
                                                    color = MaterialTheme.colorScheme.primary
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(12.dp))

                                        // Map Shortcut button
                                        Button(
                                            onClick = {
                                                onDismiss()
                                                onOpenMedicalMap(null)
                                            },
                                            modifier = Modifier.fillMaxWidth(),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = GeoPrimary)
                                        ) {
                                            Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = if (isKinyarwanda) "Shaka Aho Bagurisha iyi Miti ku Ikarita (Find on Map)" else "Locate Medical Suppliers on Local Map",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 11.5.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
