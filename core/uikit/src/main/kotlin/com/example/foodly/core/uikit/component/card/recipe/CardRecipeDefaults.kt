package com.example.foodly.core.uikit.component.card.recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.dp

object CardRecipeDefaults {
    object Width {
        val Min = 80.dp
        val Default = 140.dp
        val Small = 120.dp
    }

    object Height {
        val Min = 80.dp
        val Default = 140.dp
        val Small = 120.dp
    }

    object HorizontalArrangement {
        val Default = Arrangement.spacedBy(12.dp)
    }

    object Limit {
        const val SLIDER_LIMIT = 12
    }
}