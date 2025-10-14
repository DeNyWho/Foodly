package com.example.foodly.core.uikit.param

import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.domain.model.food.recipe.RecipeIngredient
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.example.foodly.domain.model.food.recipe.nutrition.RecipeNutrient
import com.example.foodly.domain.model.food.recipe.nutrition.RecipeNutrition
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.serialization.SerialName

object GlobalParams {
    val DataRecipeLightSingle = RecipeLight(
        id = 0,
        title = "Pasta",
        image = "Image",
    )

    val DataRecipes: ImmutableList<RecipeLight> = persistentListOf(
        *(0 until 10).map { index ->
            DataRecipeLightSingle.copy(id = index)
        }.toTypedArray()
    )

    val DataRecipeDetail = RecipeDetail(
        title = "pasta",
        image = "pasta.jpg",
        readyInMinutes = 20,
        vegetarian = true,
        glutenFree = false,
        dairyFree = false,
        veryHealthy = false,
        cheap = false,
        veryPopular = true,
        preparationMinutes = 5,
        cookingMinutes = 15,
        healthScore = 3.5,
        extendedIngredients =  listOf(
            RecipeIngredient(
                id = "pasta",
                image = "pasta",
                name = "pasta",
                original = "pasta",
                amount = 2.2,
            )
        ),
        nutrition = RecipeNutrition(
            nutrients = listOf(
                RecipeNutrient(
                    name = "Calories",
                    amount = 400.0,
                    unit = "kcal",
                ),
                RecipeNutrient(
                    name = "Protein",
                    amount = 2.0,
                    unit = "g",
                ),
                RecipeNutrient(
                    name = "Fat",
                    amount = 14.7,
                    unit = "g",
                ),
                RecipeNutrient(
                    name = "Carbohydrates",
                    amount = 51.78,
                    unit = "g",
                ),
            )
        ),
        summary = "",
    )
}