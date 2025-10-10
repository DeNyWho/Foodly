package com.example.foodly.domain.usecase.recipe

import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.model.food.recipe.detail.RecipeDetail
import com.example.foodly.domain.repository.recipe.RecipesRepository
import kotlinx.coroutines.flow.Flow

class RecipeInformationUseCase(private val recipesRepository: RecipesRepository) {
    operator fun invoke(
        id: Int,
        includeNutrition: Boolean = false,
    ): Flow<StateWrapper<RecipeDetail>> {
        return recipesRepository.recipeInformation(
            id = id,
            includeNutrition = includeNutrition
        )
    }
}