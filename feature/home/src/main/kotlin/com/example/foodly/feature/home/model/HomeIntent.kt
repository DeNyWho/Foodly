package com.example.foodly.feature.home.model

import com.example.foodly.domain.model.food.recipe.type.RecipeMealType

sealed interface HomeIntent {
    data object LoadInitialData: HomeIntent
    data object RefreshData: HomeIntent
    data class UpdateMealType(val mealType: RecipeMealType): HomeIntent
}