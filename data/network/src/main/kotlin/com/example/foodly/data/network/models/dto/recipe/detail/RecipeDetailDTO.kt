package com.example.foodly.data.network.models.dto.recipe.detail

import com.example.foodly.data.network.models.dto.recipe.ingredients.RecipeIngredientDTO
import com.example.foodly.data.network.models.dto.recipe.nutrition.RecipeNutritionDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDetailDTO(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("readyInMinutes")
    val readyInMinutes: Int = 0,
    @SerialName("vegetarian")
    val vegetarian: Boolean = false,
    @SerialName("glutenFree")
    val glutenFree: Boolean = false,
    @SerialName("dairyFree")
    val dairyFree: Boolean = false,
    @SerialName("veryHealthy")
    val veryHealthy: Boolean = false,
    @SerialName("cheap")
    val cheap: Boolean = false,
    @SerialName("veryPopular")
    val veryPopular: Boolean = false,
    @SerialName("preparationMinutes")
    val preparationMinutes: Int = 0,
    @SerialName("cookingMinutes")
    val cookingMinutes: Int = 0,
    @SerialName("healthScore")
    val healthScore: Double = 0.0,
    @SerialName("extendedIngredients")
    val extendedIngredients: List<RecipeIngredientDTO> = listOf(),
    @SerialName("nutrition")
    val nutrition: RecipeNutritionDTO = RecipeNutritionDTO(),
    @SerialName("summary")
    val summary: String = "",
)