package com.example.foodly.domain.usecase.recipe

import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.light.RecipeLight
import com.example.foodly.domain.repository.recipe.RecipesRepository
import kotlinx.coroutines.flow.Flow

class RandomRecipesUseCase(private val recipeRepository: RecipesRepository) {
    operator fun invoke(
        number: Int,
    ): Flow<StateListWrapper<RecipeLight>> {
        return recipeRepository.randomRecipes(
            number = number,
        )
    }
}