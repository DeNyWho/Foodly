package com.example.foodly.core.uikit.util

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.foodly.domain.model.common.device.ScreenInfo

val LocalScreenInfo = staticCompositionLocalOf<ScreenInfo> {
    error("LocalScreenInfo not provided")
}