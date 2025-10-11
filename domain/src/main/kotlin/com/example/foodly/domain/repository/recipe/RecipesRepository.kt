package com.example.foodly.domain.repository.recipe

import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.domain.model.food.recipe.RecipeLight
import kotlinx.coroutines.flow.Flow

interface RecipesRepository {
    fun recipesByQuery(
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
        fillIngredients: Boolean = false
    ): Flow<StateListWrapper<RecipeLight>>

    fun randomRecipes(number: Int = 1): Flow<StateListWrapper<RecipeLight>>
    fun quickAnswer(q: String): Flow<StateWrapper<String>>
    fun recipeInformation(
        id: Int,
        includeNutrition: Boolean = false
    ): Flow<StateWrapper<RecipeDetail>>
}