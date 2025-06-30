package com.example.foodly.core.uikit.icon

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun FoodlyIcon(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
    )
}