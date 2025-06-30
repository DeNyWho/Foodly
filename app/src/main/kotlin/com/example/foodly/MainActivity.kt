package com.example.foodly

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.foodly.core.uikit.theme.FoodlyTheme
import com.example.foodly.core.uikit.util.LocalScreenInfo
import com.example.foodly.domain.model.common.device.FontSizePrefs
import com.example.foodly.domain.model.common.device.ScreenInfo
import com.example.foodly.domain.model.common.device.ScreenType
import com.example.foodly.navigation.NavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        enableEdgeToEdge()
        setContent {
            val screenInfo = remember { getScreenInfo() }

            val updatedScreenInfo = screenInfo.copy(fontSizePrefs = FontSizePrefs.MEDIUM)

            CompositionLocalProvider(LocalScreenInfo provides updatedScreenInfo) {
                FoodlyTheme {
                    NavHost()
                }
            }
        }
    }

    private fun getScreenInfo(): ScreenInfo {
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val density: Float = displayMetrics.density

        val widthDp: Float = displayMetrics.widthPixels / density
        val heightDp: Float = displayMetrics.heightPixels / density

        val (portraitWidthDp: Float, portraitHeightDp: Float) = if (widthDp < heightDp) {
            widthDp to heightDp
        } else {
            heightDp to widthDp
        }

        val screenType: ScreenType = when {
            portraitWidthDp < 360 -> ScreenType.SMALL
            portraitWidthDp in 360.0..480.0 -> ScreenType.MEDIUM
            portraitWidthDp in 480.0..600.0 -> ScreenType.LARGE
            else -> ScreenType.EXTRA_LARGE
        }

        return ScreenInfo(screenType, FontSizePrefs.MEDIUM, portraitWidthDp.toInt(), portraitHeightDp.toInt())
    }
}