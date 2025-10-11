package com.example.foodly.core.uikit.component.slider

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object SliderComponentDefaults {
    val Default = Modifier
        .padding(horizontal = 16.dp, vertical = 8.dp)
    val VerticalOnly = Modifier
        .padding(horizontal = 0.dp, vertical = 8.dp)
    val BottomOnly = Modifier
        .padding(bottom = 8.dp)
}