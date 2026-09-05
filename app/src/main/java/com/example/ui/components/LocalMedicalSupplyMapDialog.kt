package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
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
import com.example.ui.theme.EmeraldGreen
import com.example.ui.theme.GeoPrimary
import com.example.ui.theme.LeafGreen

@Composable
fun LocalMedicalSupplyMapDialog(
    isOpen: Boolean,
    isKinyarwanda: Boolean,
    farmerDistrict: String = "Musanze",
    onDismiss: () -> Unit
) {
    if (!isOpen) return

    val context = LocalContext.current
    var selectedRegion by remember { mutableStateOf<String?>(null) }
    var selectedType by remember { mutableStateOf<CenterType?>(null) }
    var searchQuery by remember { mutableStateOf("") }

    val allCenters = TreatmentCentersRepository.CENTERS

    val filteredCenters = remember(selectedRegion, selectedType, searchQuery) {
        allCenters.filter { center ->
            val matchRegion = selectedRegion == null ||
                    center.province.contains(selectedRegion!!, ignoreCase = true) ||
                    center.district.contains(selectedRegion!!, ignoreCase = true)
            val matchType = selectedType == null || center.type == selectedType
            val matchQuery = searchQuery.isBlank() ||
                    center.name.contains(searchQuery, ignoreCase = true) ||
                    center.localName.contains(searchQuery, ignoreCase = true) ||
                    center.district.contains(searchQuery, ignoreCase = true) ||
                    center.availableSupplies.any { it.contains(searchQuery, ignoreCase = true) }
            matchRegion && matchType && matchQuery
        }
    }

    var selectedCenter by remember(filteredCenters) {
        mutableStateOf(filteredCenters.find { it.district.contains(farmerDistrict, ignoreCase = true) } ?: filteredCenters.firstOrNull())
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .padding(vertical = 16.dp)
                .testTag("medical_supply_map_dialog"),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(GeoPrimary.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Map,
                                contentDescription = null,
                                tint = GeoPrimary,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = if (isKinyarwanda) "Ikarita y'Imiti n'Amavuriro" else "Medical Supplies & Treatment Map",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = if (isKinyarwanda) "Aho bagurisha imiti y'ibihingwa n'amatungo mu turere" else "Locate certified agrodealers, vets & clinics by region",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    IconButton(onClick = onDismiss) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text(
                            text = if (isKinyarwanda) "Shakisha umuti (urugero: Ridomil, Oxytet, Dithane)..." else "Search medical supply or district...",
                            fontSize = 12.sp
                        )
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Regional Filter Chips ("According to where they stay")
                Text(
                    text = if (isKinyarwanda) "Hitamo Intara/Akarere (Region):" else "Select Region (According to Where You Stay):",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    item {
                        FilterChip(
                            selected = selectedRegion == null,
                            onClick = { selectedRegion = null },
                            label = { Text(if (isKinyarwanda) "Rwanda Yose" else "All Rwanda", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedRegion == "Northern",
                            onClick = { selectedRegion = if (selectedRegion == "Northern") null else "Northern" },
                            label = { Text("Amajyaruguru (Musanze)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedRegion == "Eastern",
                            onClick = { selectedRegion = if (selectedRegion == "Eastern") null else "Eastern" },
                            label = { Text("Iburasirazuba (Nyagatare)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedRegion == "Western",
                            onClick = { selectedRegion = if (selectedRegion == "Western") null else "Western" },
                            label = { Text("Iburengerazuba (Rubavu)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedRegion == "Southern",
                            onClick = { selectedRegion = if (selectedRegion == "Southern") null else "Southern" },
                            label = { Text("Amajyepfo (Huye)", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                    item {
                        FilterChip(
                            selected = selectedRegion == "Kigali",
                            onClick = { selectedRegion = if (selectedRegion == "Kigali") null else "Kigali" },
                            label = { Text("Kigali City", fontSize = 11.sp) },
                            shape = RoundedCornerShape(10.dp),
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GeoPrimary, selectedLabelColor = Color.White)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Interactive Stylized Rwanda Map Canvas
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFE8F5E9))
                        .border(1.dp, Color(0xFFC8E6C9), RoundedCornerShape(20.dp))
                        .testTag("rwanda_medical_canvas_map")
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        val w = size.width
                        val h = size.height

                        // Rwanda stylized territory outline
                        val rwandaPath = Path().apply {
                            moveTo(w * 0.20f, h * 0.15f)
                            lineTo(w * 0.70f, h * 0.10f)
                            lineTo(w * 0.88f, h * 0.35f)
                            lineTo(w * 0.82f, h * 0.75f)
                            lineTo(w * 0.55f, h * 0.90f)
                            lineTo(w * 0.28f, h * 0.85f)
                            lineTo(w * 0.12f, h * 0.50f)
                            close()
                        }

                        // Fill territory
                        drawPath(rwandaPath, color = Color(0xFFC8E6C9).copy(alpha = 0.5f))
                        drawPath(rwandaPath, color = Color(0xFF2E7D32).copy(alpha = 0.35f), style = Stroke(width = 3f))

                        // Lake Kivu border on west
                        val kivuPath = Path().apply {
                            moveTo(w * 0.12f, h * 0.35f)
                            cubicTo(w * 0.18f, h * 0.45f, w * 0.10f, h * 0.65f, w * 0.16f, h * 0.78f)
                        }
                        drawPath(kivuPath, color = Color(0xFF81D4FA), style = Stroke(width = 6f))
                    }

                    // Watermark / Map Legend
                    Surface(
                        color = Color.White.copy(alpha = 0.85f),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "🇷🇼 RWANDA MEDICAL SUPPLY MAP",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = GeoPrimary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                        )
                    }

                    // Interactive Location Pin Markers
                    filteredCenters.forEach { center ->
                        val isSelected = selectedCenter?.id == center.id
                        val pinColor = when (center.type) {
                            CenterType.AGRODEALER_PESTICIDES -> EmeraldGreen
                            CenterType.VETERINARY_PHARMACY -> Color(0xFFE65100)
                            CenterType.DISTRICT_HOSPITAL -> Color(0xFFD32F2F)
                            CenterType.RAB_RESEARCH_STATION -> GeoPrimary
                        }

                        // Position marker proportionally
                        val posX = (center.mapXPercent * 0.85f + 0.07f).coerceIn(0.08f, 0.88f)
                        val posY = (center.mapYPercent * 0.75f + 0.10f).coerceIn(0.12f, 0.82f)

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .offset(
                                        x = (posX * 300).dp,
                                        y = (posY * 140).dp
                                    )
                                    .size(if (isSelected) 36.dp else 28.dp)
                                    .clip(CircleShape)
                                    .background(if (isSelected) pinColor else pinColor.copy(alpha = 0.9f))
                                    .border(
                                        width = if (isSelected) 2.5.dp else 1.5.dp,
                                        color = Color.White,
                                        shape = CircleShape
                                    )
                                    .clickable { selectedCenter = center },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = when (center.type) {
                                        CenterType.AGRODEALER_PESTICIDES -> Icons.Default.Agriculture
                                        CenterType.VETERINARY_PHARMACY -> Icons.Default.Pets
                                        CenterType.DISTRICT_HOSPITAL -> Icons.Default.LocalHospital
                                        CenterType.RAB_RESEARCH_STATION -> Icons.Default.Storefront
                                    },
                                    contentDescription = center.name,
                                    tint = Color.White,
                                    modifier = Modifier.size(if (isSelected) 18.dp else 14.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Active Center Card with "Call Location"
                selectedCenter?.let { center ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("active_center_card"),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)),
                        border = CardDefaults.outlinedCardBorder().copy(
                            width = 1.dp,
                            brush = androidx.compose.ui.graphics.SolidColor(GeoPrimary.copy(alpha = 0.4f))
                        )
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = if (isKinyarwanda) center.localName else center.name,
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "${center.district} • ${center.address}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                Surface(
                                    color = GeoPrimary.copy(alpha = 0.12f),
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = when (center.type) {
                                            CenterType.AGRODEALER_PESTICIDES -> if (isKinyarwanda) "Imiti y'Ubuhinzi" else "Agrodealer"
                                            CenterType.VETERINARY_PHARMACY -> if (isKinyarwanda) "Imiti y'Amatungo" else "Vet Pharmacy"
                                            CenterType.DISTRICT_HOSPITAL -> if (isKinyarwanda) "Ibitaro (Urgent)" else "Hospital"
                                            CenterType.RAB_RESEARCH_STATION -> "RAB Station"
                                        },
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.5.sp,
                                        color = GeoPrimary,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Available medical & crop supplies in stock
                            Text(
                                text = if (isKinyarwanda) "Imiti n'Ibikoresho Bihari (Supplies in Stock):" else "Medical Supplies in Stock:",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = center.availableSupplies.joinToString(" • "),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Action Buttons: CALL LOCATION and DIRECTIONS
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = {
                                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${center.phoneNumber}"))
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(44.dp)
                                        .testTag("call_center_button"),
                                    shape = RoundedCornerShape(14.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = GeoPrimary)
                                ) {
                                    Icon(imageVector = Icons.Default.Call, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(
                                        text = if (isKinyarwanda) "Hamagara Aho Bakorera (Call Location)" else "Call Location (${center.phoneNumber})",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp
                                    )
                                }

                                OutlinedButton(
                                    onClick = {
                                        val gmmIntentUri = Uri.parse("geo:${center.latitude},${center.longitude}?q=${Uri.encode(center.name)}")
                                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                                        context.startActivity(mapIntent)
                                    },
                                    modifier = Modifier
                                        .weight(0.7f)
                                        .height(44.dp)
                                        .testTag("directions_button"),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Icon(imageVector = Icons.Default.Navigation, contentDescription = null, modifier = Modifier.size(16.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(if (isKinyarwanda) "Kwereka Inzira" else "Directions", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Full center list in chosen region
                Text(
                    text = if (isKinyarwanda) "Ahandi Haboneka Imiti mu Gace Kanyu (${filteredCenters.size}):" else "Other Centers in This Region (${filteredCenters.size}):",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(6.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(filteredCenters) { center ->
                        Surface(
                            color = if (selectedCenter?.id == center.id) GeoPrimary.copy(alpha = 0.15f) else MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(12.dp),
                            border = CardDefaults.outlinedCardBorder().copy(
                                width = 1.dp,
                                brush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.outline.copy(alpha = 0.15f))
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedCenter = center }
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = if (isKinyarwanda) center.localName else center.name,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "${center.district} • ${center.availableSupplies.take(2).joinToString(", ")}...",
                                        fontSize = 10.5.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }

                                IconButton(
                                    onClick = {
                                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${center.phoneNumber}"))
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier.size(32.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Call,
                                        contentDescription = "Call",
                                        tint = GeoPrimary,
                                        modifier = Modifier.size(16.dp)
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
