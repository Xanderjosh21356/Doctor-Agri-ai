package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = Color(0xFF76C887),
    onPrimary = Color(0xFF0F3818),
    primaryContainer = Color(0xFF233B27),
    onPrimaryContainer = Color(0xFFBBE5C5),
    secondary = Color(0xFFE59850),
    onSecondary = Color(0xFF3E1F03),
    secondaryContainer = Color(0xFF4C2F15),
    onSecondaryContainer = Color(0xFFFFDCC0),
    tertiary = Color(0xFFA8B878),
    onTertiary = Color(0xFF263507),
    background = FarmSurfaceDark,
    surface = FarmCardDark,
    surfaceVariant = Color(0xFF232B21),
    onBackground = FarmTextLight,
    onSurface = FarmTextLight,
    onSurfaceVariant = Color(0xFFC7CEC4),
    outline = Color(0xFF445041)
  )

private val LightColorScheme =
  lightColorScheme(
    primary = GeoPrimary,
    onPrimary = Color.White,
    primaryContainer = GeoSageContainer,
    onPrimaryContainer = GeoPrimary,
    secondary = GeoOrganic,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFF1F4DD),
    onSecondaryContainer = Color(0xFF384319),
    tertiary = GeoChemical,
    onTertiary = Color.White,
    background = GeoBackground,
    surface = GeoCardWhite,
    surfaceVariant = Color(0xFFF2F4E8),
    onBackground = GeoTextDark,
    onSurface = GeoTextDark,
    onSurfaceVariant = Color(0xFF4F584C),
    outline = GeoSageBorder
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
