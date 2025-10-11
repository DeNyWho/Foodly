package com.example.foodly.domain.model.food.recipe.type

sealed class RecipeMealType(val value: String) {
    data object MainCourse: RecipeMealType("main course")
    data object SideDish: RecipeMealType("side dish")
    data object Dessert: RecipeMealType("dessert")
    data object Appetizer: RecipeMealType("appetizer")
    data object Salad: RecipeMealType("salad")
    data object Bread: RecipeMealType("bread")
    data object Breakfast: RecipeMealType("breakfast")
    data object Soup: RecipeMealType("soup")
    data object Beverage: RecipeMealType("beverage")
    data object Sauce: RecipeMealType("sauce")
    data object Marinade: RecipeMealType("marinade")
    data object FingerFood: RecipeMealType("fingerfood")
    data object Snack: RecipeMealType("snack")
    data object Drink: RecipeMealType("drink")
}