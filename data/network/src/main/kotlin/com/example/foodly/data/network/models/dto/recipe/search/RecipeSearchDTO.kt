package com.example.foodly.data.network.models.dto.recipe.search

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeSearchDTO<T>(
    @SerialName("results")
    val results: List<T> = listOf(),
)