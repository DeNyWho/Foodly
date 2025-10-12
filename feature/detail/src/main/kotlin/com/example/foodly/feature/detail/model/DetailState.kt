package com.example.foodly.feature.detail.model

import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.model.food.recipe.RecipeDetail

internal data class DetailState(
    val recipe: StateWrapper<RecipeDetail> = StateWrapper.loading(),
)