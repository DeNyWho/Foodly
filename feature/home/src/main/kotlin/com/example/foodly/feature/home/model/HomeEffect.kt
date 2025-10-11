package com.example.foodly.feature.home.model

sealed interface HomeEffect {
    data class ShowError(val message: String): HomeEffect
}