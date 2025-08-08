package com.example.foodly.data.network.models.dto.recipe.random

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeRandomDTO<T>(
    @SerialName("recipes")
    val recipes: List<T> = listOf(),
)