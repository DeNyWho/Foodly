package com.example.foodly.data.network.mappers.recipe

import com.example.foodly.data.network.models.dto.recipe.light.RecipeLightDTO
import com.example.foodly.domain.model.food.recipe.RecipeLight

fun RecipeLightDTO.toLight(): RecipeLight = RecipeLight(
    id = id,
    title = title,
    image = image,
)