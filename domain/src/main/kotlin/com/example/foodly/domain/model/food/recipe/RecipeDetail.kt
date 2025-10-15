package com.example.foodly.domain.model.food.recipe

import androidx.compose.runtime.Immutable
import com.example.foodly.domain.model.food.recipe.nutrition.RecipeNutrition
import kotlinx.serialization.SerialName

@Immutable
data class RecipeDetail(
    val id: Int = 0,
    val title: String = "",
    val image: String = "",
    val readyInMinutes: Int = 0,
    val vegetarian: Boolean = false,
    val glutenFree: Boolean = false,
    val dairyFree: Boolean = false,
    val veryHealthy: Boolean = false,
    val cheap: Boolean = false,
    val veryPopular: Boolean = false,
    val preparationMinutes: Int = 0,
    val cookingMinutes: Int = 0,
    val healthScore: Double = 0.0,
    val extendedIngredients: List<RecipeIngredient> = listOf(),
    val nutrition: RecipeNutrition = RecipeNutrition(),
    val summary: String = "",
    val instructions: String = "",
)