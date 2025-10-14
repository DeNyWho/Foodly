package com.example.foodly.feature.detail.model

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface DetailEvent {
    data object LoadInitialData: DetailEvent
    data object RefreshData: DetailEvent
}