package com.example.foodly.domain.usecase.recipe

import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.light.RecipeLight
import com.example.foodly.domain.repository.recipe.RecipesRepository
import kotlinx.coroutines.flow.Flow

class RecipesByQueryUseCase(private val recipeRepository: RecipesRepository) {
    operator fun invoke(
        query: String? = null,
        cuisine: List<String>? = null,
        diet: String? = null,
        intolerances: List<String>? = null,
        type: String? = null,
        minReadyTime: Int? = null,
        maxReadyTime: Int? = null,
        minServings: Int? = null,
        maxServings: Int? = null,
        minCalories: Int? = null,
        maxCalories: Int? = null,
        minCarbs: Int? = null,
        maxCarbs: Int? = null,
        minProtein: Int? = null,
        maxProtein: Int? = null,
        minFat: Int? = null,
        maxFat: Int? = null,
        sort: String? = null,
        sortDirection: String? = null,
        offset: Int = 0,
        number: Int = 12,
        addRecipeInformation: Boolean = true,
        fillIngredients: Boolean = false,
    ): Flow<StateListWrapper<RecipeLight>> {
        return recipeRepository.recipesByQuery(
            query = query,
            cuisine = cuisine,
            diet = diet,
            intolerances = intolerances,
            type = type,
            minReadyTime = minReadyTime,
            maxReadyTime = maxReadyTime,
            minServings = minServings,
            maxServings = maxServings,
            minCalories = minCalories,
            maxCalories = maxCalories,
            minCarbs = minCarbs,
            maxCarbs = maxCarbs,
            minProtein = minProtein,
            maxProtein = maxProtein,
            minFat = minFat,
            maxFat = maxFat,
            sort = sort,
            sortDirection = sortDirection,
            offset = offset,
            number = number,
            addRecipeInformation = addRecipeInformation,
            fillIngredients = fillIngredients,
        )
    }
}