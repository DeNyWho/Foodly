package com.example.foodly.feature.home.model

import androidx.compose.runtime.Immutable
import com.example.foodly.domain.model.food.recipe.type.RecipeCuisinesType

@Immutable
internal sealed interface HomeAction {
    data class ShowError(val message: String): HomeAction
    data class NavigateToRecipeDetail(val recipeId: Int): HomeAction
    data class NavigateToCuisine(val cuisine: RecipeCuisinesType): HomeAction
}