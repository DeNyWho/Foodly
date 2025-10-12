package com.example.foodly.domain.model.food.recipe.type

sealed class RecipeCuisinesType(val value: String) {
    data object African: RecipeCuisinesType("African")
    data object Asian: RecipeCuisinesType("Asian")
    data object American: RecipeCuisinesType("American")
    data object British: RecipeCuisinesType("British")
    data object Cajun: RecipeCuisinesType("Cajun")
    data object Caribbean: RecipeCuisinesType("Caribbean")
    data object Chinese: RecipeCuisinesType("Chinese")
    data object EasternEuropean: RecipeCuisinesType("Eastern European")
    data object European: RecipeCuisinesType("European")
    data object French: RecipeCuisinesType("French")
    data object German: RecipeCuisinesType("German")
    data object Greek: RecipeCuisinesType("Greek")
    data object Indian: RecipeCuisinesType("Indian")
    data object Irish: RecipeCuisinesType("Irish")
    data object Italian: RecipeCuisinesType("Italian")
    data object Japanese: RecipeCuisinesType("Japanese")
    data object Jewish: RecipeCuisinesType("Jewish")
    data object Korean: RecipeCuisinesType("Korean")
    data object LatinAmerican: RecipeCuisinesType("Latin American")
    data object Mediterranean: RecipeCuisinesType("Mediterranean")
    data object Mexican: RecipeCuisinesType("Mexican")
    data object MiddleEastern: RecipeCuisinesType("Middle Eastern")
    data object Nordic: RecipeCuisinesType("Nordic")
    data object Southern: RecipeCuisinesType("Southern")
    data object Spanish: RecipeCuisinesType("Spanish")
    data object Thai: RecipeCuisinesType("Thai")
    data object Vietnamese: RecipeCuisinesType("Vietnamese")

    companion object {
        private const val CDN_BASE = "https://s3.twcstorage.ru/302c64e9-737c3e3e-4977-41f9-bceb-cca468e0257c/foodly/Cuisines"
    }

    val imageUrl: String
        get() = "$CDN_BASE/${value}/${value.replace(" ", "_")}.png"
}