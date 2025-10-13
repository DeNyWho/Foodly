package com.example.foodly.data.source.repository.recipe

import com.example.foodly.data.network.mappers.recipe.toDetail
import com.example.foodly.data.network.mappers.recipe.toLight
import com.example.foodly.data.network.service.RecipesService
import com.example.foodly.domain.model.common.request.Resource
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.example.foodly.domain.repository.recipe.RecipesRepository
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class RecipesRepositoryImpl(
    private val recipesService: RecipesService
): RecipesRepository {
    override fun recipesByQuery(
        query: String?,
        cuisine: List<String>?,
        diet: String?,
        intolerances: List<String>?,
        type: String?,
        minReadyTime: Int?,
        maxReadyTime: Int?,
        minServings: Int?,
        maxServings: Int?,
        minCalories: Int?,
        maxCalories: Int?,
        minCarbs: Int?,
        maxCarbs: Int?,
        minProtein: Int?,
        maxProtein: Int?,
        minFat: Int?,
        maxFat: Int?,
        sort: String?,
        sortDirection: String?,
        offset: Int,
        number: Int,
        addRecipeInformation: Boolean,
        fillIngredients: Boolean,
    ): Flow<StateListWrapper<RecipeLight>> {
        return flow {
            emit(StateListWrapper.loading())

            val recipesResult = recipesService.recipesByQuery(
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

            val state = when(recipesResult) {
                is Resource.Success -> {
                    val data = recipesResult.data.results.map { it.toLight() }.toPersistentList()

                    StateListWrapper.success(data = data)
                }

                is Resource.Error -> {
                    StateListWrapper.error(error = recipesResult.error)
                }

                is Resource.Loading -> {
                    StateListWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }

    override fun randomRecipes(
        number: Int,
    ): Flow<StateListWrapper<RecipeLight>> {
        return flow {
            emit(StateListWrapper.loading())

            val randomRecipesResult = recipesService.randomRecipes(number)

            val state = when(randomRecipesResult) {
                is Resource.Success -> {
                    val data = randomRecipesResult.data.recipes.map { it.toLight() }.toPersistentList()

                    StateListWrapper.success(data)
                }

                is Resource.Error -> {
                    StateListWrapper.error(error = randomRecipesResult.error)
                }

                is Resource.Loading -> {
                    StateListWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }

    override fun quickAnswer(
        q: String
    ): Flow<StateWrapper<String>> {
        return flow {
            emit(StateWrapper.loading())

            val quickAnswerResult = recipesService.quickAnswer(q)

            val state = when(quickAnswerResult) {
                is Resource.Success -> {
                    val data = quickAnswerResult.data.answer

                    StateWrapper.success(data)
                }

                is Resource.Error -> {
                    StateWrapper.error(error = quickAnswerResult.error)
                }

                is Resource.Loading -> {
                    StateWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }

    override fun recipeInformation(
        id: Int,
        includeNutrition: Boolean,
    ): Flow<StateWrapper<RecipeDetail>> {
        return flow {
            emit(StateWrapper.loading())

            val recipeInformationResult = recipesService.recipeInformation(
                id = id,
                includeNutrition = includeNutrition,
            )

            val state = when(recipeInformationResult) {
                is Resource.Success -> {
                    val data = recipeInformationResult.data.toDetail()

                    StateWrapper.success(data)
                }

                is Resource.Error -> {
                    StateWrapper.error(error = recipeInformationResult.error)
                }

                is Resource.Loading -> {
                    StateWrapper.loading()
                }
            }

            emit(state)
        }.flowOn(Dispatchers.IO)
    }
}
















