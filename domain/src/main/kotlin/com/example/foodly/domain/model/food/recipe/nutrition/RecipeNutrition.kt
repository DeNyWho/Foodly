package com.example.foodly.domain.model.food.recipe.nutrition

import androidx.compose.runtime.Immutable

@Immutable
data class RecipeNutrition(
    val nutrients: List<RecipeNutrient> = listOf(),
)