package com.example.foodly.core.uikit.param

import com.example.foodly.domain.model.food.recipe.RecipeLight
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

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
}