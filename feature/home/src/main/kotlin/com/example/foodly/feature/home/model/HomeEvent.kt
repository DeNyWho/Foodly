package com.example.foodly.feature.home.model

import androidx.compose.runtime.Immutable
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType

@Immutable
internal sealed interface HomeEvent {
    data object LoadInitialData: HomeEvent
    data object RefreshData: HomeEvent
    data class OnRecipeCardClick(val recipeId: Int): HomeEvent
    data class UpdateMealType(val mealType: RecipeMealType): HomeEvent
}