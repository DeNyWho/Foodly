package com.example.foodly.core.uikit.theme

import android.app.Activity
import android.view.Window
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.foodly.core.uikit.util.LocalScreenInfo
import com.example.foodly.domain.model.common.device.ThemeType
import com.example.foodly.domain.model.common.device.ThemeType.DARK
import com.example.foodly.domain.model.common.device.ThemeType.LIGHT
import com.example.foodly.domain.model.common.device.ThemeType.SYSTEM

/**
 * Dark default theme color scheme
 */
@VisibleForTesting
val DarkColorScheme = darkColorScheme(
    background = blue900,
    onBackground = grey50,
    surfaceVariant = grey800,
    onSurfaceVariant = grey400,
    scrim = grey900,
    onSurface = grey600,
    surface = grey700,
    onPrimary = grey50,
    surfaceContainer = blue900,
    onPrimaryContainer = grey50,
    error = grey50,
)

/**
 * Light default theme color scheme
 */
@VisibleForTesting
val LightColorScheme = lightColorScheme(
    background = grey50,
    onBackground = blue900,
    surfaceVariant = grey200,
    onSurfaceVariant = grey400,
    scrim = grey900,
    onSurface = grey600,
    surface = grey700,
    onPrimary = grey50,
    surfaceContainer = grey50,
    onPrimaryContainer = grey50,
    error = Color.Red,
)

@Composable
fun FoodlyTheme(
    themeType: ThemeType = SYSTEM,
    content: @Composable () -> Unit,
) {
   val isDarkTheme = when(themeType) {
       DARK ->  true
       LIGHT -> false
       SYSTEM -> isSystemInDarkTheme()
   }

    val colorScheme = if(isDarkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as? Activity)?.window?.let { window ->
                with(WindowCompat.getInsetsController(window, view)) {
                    isAppearanceLightStatusBars = !isDarkTheme
                    isAppearanceLightNavigationBars = !isDarkTheme
                }
            }
        }
    }

    val screenInfo = LocalScreenInfo.current
    val fontSizePrefs = screenInfo.fontSizePrefs

    MaterialTheme(
        colorScheme = colorScheme,
        typography = foodlyTypography(fontSizePrefs = fontSizePrefs),
        content = content,
    )
}