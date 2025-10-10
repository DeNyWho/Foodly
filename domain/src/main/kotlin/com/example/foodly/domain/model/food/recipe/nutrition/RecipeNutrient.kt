package com.example.foodly.domain.model.food.recipe.nutrition

import kotlinx.serialization.SerialName

data class RecipeNutrient(
    @SerialName("name")
    val name: String = "",
    @SerialName("amount")
    val amount: Double = 0.0,
    @SerialName("unit")
    val unit: String = "",
)