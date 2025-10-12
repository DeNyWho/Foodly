package com.example.foodly.feature.home.model

import androidx.compose.runtime.Immutable
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType

@Immutable
internal data class HomeState(
    val popularRecipes: StateListWrapper<RecipeLight> = StateListWrapper.loading(),
    val fastRecipes: StateListWrapper<RecipeLight> = StateListWrapper.loading(),
    val mealTypeRecipes: StateListWrapper<RecipeLight> = StateListWrapper.loading(),
    val currentMealType: RecipeMealType = RecipeMealType.MainCourse,
    val healthyRecipes: StateListWrapper<RecipeLight> = StateListWrapper.loading(),
    val cuisineRecipes: StateListWrapper<RecipeLight> = StateListWrapper.loading(),
)