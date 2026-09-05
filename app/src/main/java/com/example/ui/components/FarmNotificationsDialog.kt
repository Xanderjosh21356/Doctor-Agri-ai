package com.example.ui.components

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.data.model.AlertCategory
import com.example.data.model.FarmAlert
import com.example.data.notification.AgriNotificationHelper
import com.example.data.repository.FarmAlertRepository
import com.example.ui.theme.EmeraldGreen
import com.example.ui.theme.GeoPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmNotificationsDialog(
    isOpen: Boolean,
    isKinyarwanda: Boolean,
    farmerDistrict: String,
    onDismiss: () -> Unit,
    onNavigateAction: (actionType: String) -> Unit = {}
) {
    if (!isOpen) return

    val context = LocalContext.current
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var selectedCategoryFilter by remember { mutableStateOf<AlertCategory?>(null) }
    var alertsList by remember { mutableStateOf(FarmAlertRepository.INITIAL_ALERTS) }

    // Notification Preferences Toggles
    var weatherAlertsEnabled by remember { mutableStateOf(true) }
    var pestOutbreakEnabled by remember { mutableStateOf(true) }
    var vaccineRemindersEnabled by remember { mutableStateOf(true) }
    var growthAlertsEnabled by remember { mutableStateOf(true) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(
                context,
                if (isKinyarwanda) "Uruhushya rwo kumenyesha rwatanzwe!" else "Notification permission granted!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun triggerSystemNotification(alert: FarmAlert) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                return
            }
        }

        val success = AgriNotificationHelper.sendFarmAlertNotification(context, alert, isKinyarwanda)
        if (success) {
            Toast.makeText(
                context,
                if (isKinyarwanda) "Impuruza yoherejwe kuri telefoni!" else "Alert sent to system notification tray!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                context,
                if (isKinyarwanda) "Ubutumwa bwakiriwe muri porogaramu!" else "Alert logged in notification center.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    val filteredAlerts = alertsList.filter {
        selectedCategoryFilter == null || it.category == selectedCategoryFilter
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.testTag("farm_notifications_bottom_sheet")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .padding(horizontal = 16.dp)
        ) {
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = Color(0xFFD32F2F).copy(alpha = 0.15f),
                        modifier = Modifier.size(40.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.NotificationsActive,
                                contentDescription = null,
                                tint = Color(0xFFD32F2F),
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = if (isKinyarwanda) "Impuruza n'Iburira ry'Umuhinzi" else "Farm Alerts & Reminders",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = if (isKinyarwanda) "${alertsList.size} zireba $farmerDistrict n'u Rwanda" else "${alertsList.size} alerts for $farmerDistrict & national",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.testTag("close_notifications_btn")
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Quick Filter Chips
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == null,
                        onClick = { selectedCategoryFilter = null },
                        label = { Text(if (isKinyarwanda) "Byose" else "All") }
                    )
                }
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == AlertCategory.WEATHER,
                        onClick = { selectedCategoryFilter = AlertCategory.WEATHER },
                        leadingIcon = { Icon(imageVector = Icons.Default.Thunderstorm, contentDescription = null, modifier = Modifier.size(14.dp)) },
                        label = { Text(if (isKinyarwanda) "Ikirere" else "Weather") }
                    )
                }
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == AlertCategory.DISEASE_OUTBREAK,
                        onClick = { selectedCategoryFilter = AlertCategory.DISEASE_OUTBREAK },
                        leadingIcon = { Icon(imageVector = Icons.Default.Warning, contentDescription = null, modifier = Modifier.size(14.dp)) },
                        label = { Text(if (isKinyarwanda) "Ibyorezo" else "Outbreaks") }
                    )
                }
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == AlertCategory.VACCINE_REMINDER,
                        onClick = { selectedCategoryFilter = AlertCategory.VACCINE_REMINDER },
                        leadingIcon = { Icon(imageVector = Icons.Default.HealthAndSafety, contentDescription = null, modifier = Modifier.size(14.dp)) },
                        label = { Text(if (isKinyarwanda) "Inkingo" else "Vaccines") }
                    )
                }
                item {
                    FilterChip(
                        selected = selectedCategoryFilter == AlertCategory.GROWTH_STAGE,
                        onClick = { selectedCategoryFilter = AlertCategory.GROWTH_STAGE },
                        leadingIcon = { Icon(imageVector = Icons.Default.Agriculture, contentDescription = null, modifier = Modifier.size(14.dp)) },
                        label = { Text(if (isKinyarwanda) "Iterambere" else "Growth") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Alerts List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                // Test Notification Banner
                item {
                    Surface(
                        color = GeoPrimary.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = if (isKinyarwanda) "Gerageza Impuruza kuri Telefoni" else "Test Phone Notification",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 12.sp,
                                    color = GeoPrimary
                                )
                                Text(
                                    text = if (isKinyarwanda) "Ohereza ubutumwa bw'ikitegererezo mu kazu k'impuruza ka Android" else "Trigger an instant push alert to your device notification tray",
                                    style = MaterialTheme.typography.bodySmall,
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(
                                onClick = {
                                    val first = alertsList.firstOrNull() ?: return@Button
                                    triggerSystemNotification(first)
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = GeoPrimary),
                                modifier = Modifier.testTag("test_push_alert_btn")
                            ) {
                                Text(if (isKinyarwanda) "Ohereza" else "Send Test", fontSize = 11.sp)
                            }
                        }
                    }
                }

                items(filteredAlerts) { alert ->
                    val isCritical = alert.severity == "CRITICAL"
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isCritical) Color(0xFFFFEBEE) else MaterialTheme.colorScheme.surface
                        ),
                        border = CardDefaults.outlinedCardBorder()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            // Badge Row
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = if (isCritical) Color(0xFFD32F2F) else GeoPrimary
                                    ) {
                                        Text(
                                            text = alert.severity,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 10.sp,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = MaterialTheme.colorScheme.surfaceVariant
                                    ) {
                                        Text(
                                            text = alert.targetDistrict,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                        )
                                    }
                                }

                                Text(
                                    text = alert.timeFormatted,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = if (isKinyarwanda) alert.titleRw else alert.titleEn,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = if (isCritical) Color(0xFFB71C1C) else MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = if (isKinyarwanda) alert.messageRw else alert.messageEn,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // Action buttons
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextButton(
                                    onClick = { triggerSystemNotification(alert) }
                                ) {
                                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null, modifier = Modifier.size(14.dp), tint = GeoPrimary)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = if (isKinyarwanda) "Ohereza kuri Telefoni" else "Push to Tray",
                                        fontSize = 11.sp,
                                        color = GeoPrimary,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = GeoPrimary,
                                    modifier = Modifier.clickable {
                                        onDismiss()
                                        onNavigateAction(alert.category.name)
                                    }
                                ) {
                                    Text(
                                        text = if (isKinyarwanda) alert.actionPromptRw else alert.actionPromptEn,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        }
                    }
                }

                // Notification Preferences Card
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = if (isKinyarwanda) "Uburyo bwo Kwakira Impuruza (Alert Preferences)" else "Notification Preferences",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isKinyarwanda) "Impuruza z'Ikirere n'Imvura (Weather)" else "Severe Weather Warnings",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Switch(
                                    checked = weatherAlertsEnabled,
                                    onCheckedChange = { weatherAlertsEnabled = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = GeoPrimary)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isKinyarwanda) "Ibyorezo by'Ibihingwa n'Amatungo (Pests)" else "Pest & Disease Outbreaks",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Switch(
                                    checked = pestOutbreakEnabled,
                                    onCheckedChange = { pestOutbreakEnabled = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = GeoPrimary)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isKinyarwanda) "Inkingo n'Ubuvuzi bw'Amatungo (Vaccines)" else "Livestock Vaccination Reminders",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Switch(
                                    checked = vaccineRemindersEnabled,
                                    onCheckedChange = { vaccineRemindersEnabled = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = GeoPrimary)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isKinyarwanda) "Ibihe by'Ifumbire n'Isarura (Growth)" else "Crop Growth & Fertilizer Timing",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Switch(
                                    checked = growthAlertsEnabled,
                                    onCheckedChange = { growthAlertsEnabled = it },
                                    colors = SwitchDefaults.colors(checkedThumbColor = GeoPrimary)
                                )
                            }
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
