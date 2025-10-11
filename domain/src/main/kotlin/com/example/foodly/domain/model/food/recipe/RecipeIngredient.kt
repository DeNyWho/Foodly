package com.example.foodly.domain.model.food.recipe

import kotlinx.serialization.SerialName

data class RecipeIngredient(
    @SerialName("id")
    val id: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("original")
    val original: String = "",
    @SerialName("amount")
    val amount: Double = 0.0,
)