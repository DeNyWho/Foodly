package com.example.foodly.data.network.mappers.recipe

import com.example.foodly.data.network.models.dto.recipe.detail.RecipeDetailDTO
import com.example.foodly.data.network.models.dto.recipe.ingredients.RecipeIngredientDTO
import com.example.foodly.data.network.models.dto.recipe.nutrition.RecipeNutrientDTO
import com.example.foodly.data.network.models.dto.recipe.nutrition.RecipeNutritionDTO
import com.example.foodly.domain.model.food.recipe.detail.RecipeDetail
import com.example.foodly.domain.model.food.recipe.ingredients.RecipeIngredient
import com.example.foodly.domain.model.food.recipe.nutrition.RecipeNutrient
import com.example.foodly.domain.model.food.recipe.nutrition.RecipeNutrition

fun RecipeDetailDTO.toDetail(): RecipeDetail = RecipeDetail(
    id = id,
    title = title,
    image = image,
    readyInMinutes = readyInMinutes,
    vegetarian = vegetarian,
    glutenFree = glutenFree,
    dairyFree = dairyFree,
    veryHealthy = veryHealthy,
    cheap = cheap,
    veryPopular = veryPopular,
    preparationMinutes = preparationMinutes,
    cookingMinutes = cookingMinutes,
    healthScore = healthScore,
    extendedIngredients = extendedIngredients.map { it.toIngredient() },
    nutrition = nutrition.toNutrition(),
    summary = summary,
)

fun RecipeIngredientDTO.toIngredient(): RecipeIngredient = RecipeIngredient(
    id = id,
    image = image,
    name = name,
    original = original,
    amount = amount,
)

fun RecipeNutritionDTO.toNutrition(): RecipeNutrition = RecipeNutrition(
    nutrients = nutrients.map { it.toNutrient() }
)

fun RecipeNutrientDTO.toNutrient(): RecipeNutrient = RecipeNutrient(
    name = name,
    amount = amount,
    unit = unit,
)