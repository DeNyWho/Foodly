package com.example.foodly.data.network.models.dto.recipe.ingredients

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeIngredientDTO(
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