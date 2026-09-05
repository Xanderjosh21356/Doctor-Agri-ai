package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.data.model.CenterType
import com.example.data.model.TreatmentCenter
import com.example.data.repository.TreatmentCentersRepository
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentPlacesDialog(
    initialType: CenterType? = null,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    var selectedType by remember { mutableStateOf(initialType) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredCenters = remember(selectedType, searchQuery) {
        val byType = if (selectedType == null) {
            TreatmentCentersRepository.CENTERS
        } else {
            TreatmentCentersRepository.getCentersByType(selectedType!!)
        }

        if (searchQuery.isBlank()) {
            byType
        } else {
            val q = searchQuery.lowercase().trim()
            byType.filter {
                it.district.lowercase().contains(q) ||
                it.province.lowercase().contains(q) ||
                it.name.lowercase().contains(q) ||
                it.localName.lowercase().contains(q) ||
                it.availableSupplies.any { s -> s.lowercase().contains(q) }
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.90f)
                .testTag("treatment_places_dialog"),
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
                            color = GeoPrimary,
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.size(42.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Storefront,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                        Column {
                            Text(
                                text = "Aho Wagura Imiti n'Ibitaro",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = GeoTextDark
                            )
                            Text(
                                text = "Pesticides, Hospitals & Vet Centers in Rwanda",
                                style = MaterialTheme.typography.labelSmall,
                                color = GeoPrimary,
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

                Spacer(modifier = Modifier.height(14.dp))

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            text = "Search by district (Musanze, Nyagatare, Kigali...)",
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
                        .testTag("places_search_input"),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Filter Category Chips
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        FilterChip(
                            selected = selectedType == null,
                            onClick = { selectedType = null },
                            label = { Text("All (${TreatmentCentersRepository.CENTERS.size})", fontSize = 12.sp) },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GeoPrimary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedType == CenterType.AGRODEALER_PESTICIDES,
                            onClick = { selectedType = CenterType.AGRODEALER_PESTICIDES },
                            label = { Text("🧪 Agrodealers (Pesticides)", fontSize = 12.sp) },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GeoPrimary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedType == CenterType.DISTRICT_HOSPITAL,
                            onClick = { selectedType = CenterType.DISTRICT_HOSPITAL },
                            label = { Text("🏥 Hospitals & Poison", fontSize = 12.sp) },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GeoChemical,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedType == CenterType.VETERINARY_PHARMACY,
                            onClick = { selectedType = CenterType.VETERINARY_PHARMACY },
                            label = { Text("🐄 Veterinary / Dual", fontSize = 12.sp) },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GeoOrganic,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedType == CenterType.RAB_RESEARCH_STATION,
                            onClick = { selectedType = CenterType.RAB_RESEARCH_STATION },
                            label = { Text("🏛️ RAB Stations", fontSize = 12.sp) },
                            shape = RoundedCornerShape(16.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = GeoPrimary,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // List of Centers
                if (filteredCenters.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Nta vuriro cyangwa Agrodealer ihuye n'ibyo ushakishije.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFF64748B)
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filteredCenters, key = { it.id }) { center ->
                            CenterItemCard(center = center, context = context)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CenterItemCard(
    center: TreatmentCenter,
    context: Context
) {
    val badgeColor = when (center.type) {
        CenterType.AGRODEALER_PESTICIDES -> GeoPrimary
        CenterType.DISTRICT_HOSPITAL -> GeoChemical
        CenterType.VETERINARY_PHARMACY -> GeoOrganic
        CenterType.RAB_RESEARCH_STATION -> Color(0xFF1E6091)
    }

    val typeLabel = when (center.type) {
        CenterType.AGRODEALER_PESTICIDES -> "AGRODEALER"
        CenterType.DISTRICT_HOSPITAL -> "HOSPITAL / POISON"
        CenterType.VETERINARY_PHARMACY -> "VETERINARY"
        CenterType.RAB_RESEARCH_STATION -> "RAB STATION"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("center_card_${center.id}"),
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
            // Top Row: Type badge + District
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = badgeColor.copy(alpha = 0.12f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = typeLabel,
                        color = badgeColor,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }

                Surface(
                    color = GeoSageContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "📍 ${center.district}",
                        color = GeoTextDark,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Title and local name
            Text(
                text = center.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = GeoTextDark
            )
            Text(
                text = center.localName,
                style = MaterialTheme.typography.bodySmall,
                color = GeoPrimary,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = center.address,
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF64748B)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Supplies / Products
            Surface(
                color = GeoSageContainer.copy(alpha = 0.5f),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Ibicuruzwa n'Imiti (Available Supplies / Pesticides):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = GeoTextDark
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    center.availableSupplies.forEach { supply ->
                        Text(
                            text = "• $supply",
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 11.5.sp,
                            color = Color(0xFF334155)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Ibiciro (Average Prices): ${center.averagePricesRwf}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = GeoPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Call / Action Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (center.isEmergency24h) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.HealthAndSafety,
                            contentDescription = null,
                            tint = GeoChemical,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "24/7 Emergency",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = GeoChemical
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.width(1.dp))
                }

                Button(
                    onClick = {
                        val uri = if (center.phoneNumber.startsWith("*")) {
                            Uri.parse("tel:" + Uri.encode(center.phoneNumber))
                        } else {
                            Uri.parse("tel:${center.phoneNumber}")
                        }
                        val intent = Intent(Intent.ACTION_DIAL, uri)
                        context.startActivity(intent)
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = badgeColor),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Hamagara (${center.phoneNumber})",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
