package com.example.foodly.data.network.models.dto.recipe.light

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeLightDTO(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("title")
    val title: String = "",
    @SerialName("image")
    val image: String = "",
)