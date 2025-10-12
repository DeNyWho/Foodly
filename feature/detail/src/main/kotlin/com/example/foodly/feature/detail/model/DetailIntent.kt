package com.example.foodly.feature.detail.model

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface DetailIntent {
    data object LoadInitialData: DetailIntent
    data object RefreshData: DetailIntent
}