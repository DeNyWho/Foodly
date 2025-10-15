package com.example.foodly.feature.detail.model

import androidx.compose.runtime.Immutable

@Immutable
internal sealed interface DetailAction {
    data class ShowError(val message: String): DetailAction
    data object NavigateUp: DetailAction
}