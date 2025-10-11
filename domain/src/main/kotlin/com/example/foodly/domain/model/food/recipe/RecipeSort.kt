package com.example.foodly.domain.model.food.recipe

sealed class RecipeSort(val value: String) {
    data object Popular: RecipeSort("popularity")
    data object Price: RecipeSort("price")
    data object Time: RecipeSort("time")
    data object Health: RecipeSort("healthiness")
    data object Energy: RecipeSort("energy")
    data object Calories: RecipeSort("calories")
}