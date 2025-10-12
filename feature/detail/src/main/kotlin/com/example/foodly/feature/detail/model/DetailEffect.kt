package com.example.foodly.feature.detail.model

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface DetailEffect {
    data class ShowError(val message: String): DetailEffect
}