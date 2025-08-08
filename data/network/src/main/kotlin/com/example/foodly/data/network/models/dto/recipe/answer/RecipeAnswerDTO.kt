package com.example.foodly.data.network.models.dto.recipe.answer

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeAnswerDTO(
    @SerialName("answer")
    val answer: String = "",
)