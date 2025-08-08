package com.example.foodly.data.network.models.dto.recipe.nutrition

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeNutrientDTO(
    @SerialName("name")
    val name: String = "",
    @SerialName("amount")
    val amount: Double = 0.0,
    @SerialName("unit")
    val unit: String = "",
)