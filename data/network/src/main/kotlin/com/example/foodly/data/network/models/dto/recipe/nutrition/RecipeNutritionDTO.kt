package com.example.foodly.data.network.models.dto.recipe.nutrition

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeNutritionDTO(
    @SerialName("nutrients")
    val nutrients: List<RecipeNutrientDTO> = listOf(),
)