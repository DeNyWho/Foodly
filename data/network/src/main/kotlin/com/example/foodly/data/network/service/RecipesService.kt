package com.example.foodly.data.network.service

import com.example.foodly.data.network.api.ApiEndpoints
import com.example.foodly.data.network.models.dto.recipe.answer.RecipeAnswerDTO
import com.example.foodly.data.network.models.dto.recipe.detail.RecipeDetailDTO
import com.example.foodly.data.network.models.dto.recipe.light.RecipeLightDTO
import com.example.foodly.data.network.models.dto.recipe.random.RecipeRandomDTO
import com.example.foodly.data.network.models.dto.recipe.search.RecipeSearchDTO
import com.example.foodly.data.network.safeApiCall
import com.example.foodly.domain.model.common.request.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath

class RecipesService(private val client: HttpClient) {
    suspend fun recipesByQuery(
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
    ): Resource<RecipeSearchDTO<RecipeLightDTO>> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                encodedPath = "${ApiEndpoints.RECIPES}/${ApiEndpoints.RECIPES_COMPLEX_SEARCH}"

                parameter("offset", offset)
                parameter("number", number)
                parameter("addRecipeInformation", addRecipeInformation)
                parameter("fillIngredients", fillIngredients)

                if (query != null) parameter("query", query)
                if (cuisine != null) parameter("cuisine", cuisine)
                if (diet != null) parameter("diet", diet)
                if (intolerances != null) parameter("intolerances", intolerances)
                if (type != null) parameter("type", type)
                if (minReadyTime != null) parameter("minReadyTime", minReadyTime)
                if (maxReadyTime != null) parameter("maxReadyTime", maxReadyTime)
                if (minServings != null) parameter("minServings", minServings)
                if (maxServings != null) parameter("maxServings", maxServings)
                if (minCalories != null) parameter("minCalories", minCalories)
                if (maxCalories != null) parameter("maxCalories", maxCalories)
                if (minCarbs != null) parameter("minCarbs", minCarbs)
                if (minProtein != null) parameter("minProtein", minProtein)
                if (maxProtein != null) parameter("maxProtein", maxProtein)
                if (minFat != null) parameter("minFat", minFat)
                if (maxFat != null) parameter("maxFat", maxFat)
                if (sort != null) parameter("sort", sort)
                if (sortDirection != null) parameter("sortDirection", sortDirection)
                if (maxCarbs != null) parameter("maxCarbs", maxCarbs)
                if (maxCarbs != null) parameter("maxCarbs", maxCarbs)
            }
        }

        return safeApiCall<RecipeSearchDTO<RecipeLightDTO>>(client, request)
    }

    suspend fun randomRecipes(
        number: Int = 1,
    ): Resource<RecipeRandomDTO<RecipeLightDTO>> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                encodedPath = "${ApiEndpoints.RECIPES}/${ApiEndpoints.RECIPES_RANDOM}"

                parameter("number", number)
            }
        }

        return safeApiCall<RecipeRandomDTO<RecipeLightDTO>>(client, request)
    }

    suspend fun quickAnswer(
        q: String,
    ): Resource<RecipeAnswerDTO> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                encodedPath = "${ApiEndpoints.RECIPES}/${ApiEndpoints.RECIPES_QUICK_ANSWER}"

                parameter("q", q)
            }
        }

        return safeApiCall<RecipeAnswerDTO>(client, request)
    }

    suspend fun recipeInformation(
        id: Int,
        includeNutrition: Boolean = false,
    ): Resource<RecipeDetailDTO> {
        val request = HttpRequestBuilder().apply {
            method = HttpMethod.Get
            url {
                encodedPath = "${ApiEndpoints.RECIPES}/$id/${ApiEndpoints.RECIPES_INFORMATION}"

                parameter("includeNutrition", includeNutrition)
            }
        }

        return safeApiCall<RecipeDetailDTO>(client, request)
    }
}


