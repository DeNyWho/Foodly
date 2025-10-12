package com.example.foodly.domain.model.food.recipe.type

sealed class RecipeMealType(val value: String, val title: String) {
    data object MainCourse: RecipeMealType("main course", "Main course")
    data object SideDish: RecipeMealType("side dish", "Side dish")
    data object Dessert: RecipeMealType("dessert", "Dessert")
    data object Appetizer: RecipeMealType("appetizer", "Appetizer")
    data object Salad: RecipeMealType("salad", "Salad")
    data object Bread: RecipeMealType("bread", "Bread")
    data object Breakfast: RecipeMealType("breakfast", "Breakfast")
    data object Soup: RecipeMealType("soup", "Soup")
    data object Beverage: RecipeMealType("beverage", "Beverage")
    data object Sauce: RecipeMealType("sauce", "Sauce")
    data object Marinade: RecipeMealType("marinade", "Marinade")
    data object FingerFood: RecipeMealType("fingerfood", "Finger food")
    data object Snack: RecipeMealType("snack", "Snack")
    data object Drink: RecipeMealType("drink", "Drink")

    companion object {
        fun allValues(): List<RecipeMealType> = listOf(
            MainCourse,
            SideDish,
            Dessert,
            Appetizer,
            Salad,
            Bread,
            Breakfast,
            Soup,
            Beverage,
            Sauce,
            Marinade,
            FingerFood,
            Snack,
            Drink
        )
    }
}