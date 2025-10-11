package com.example.foodly.domain.model.food.recipe

import kotlinx.serialization.SerialName

data class RecipeLight(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("image")
    val image: String = "",
)