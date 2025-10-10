package com.example.foodly.data.source.di

import com.example.foodly.domain.usecase.recipe.RandomRecipesUseCase
import com.example.foodly.domain.usecase.recipe.RecipeInformationUseCase
import com.example.foodly.domain.usecase.recipe.RecipesByQueryUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::RecipesByQueryUseCase)
    singleOf(::RandomRecipesUseCase)
    singleOf(::RecipeInformationUseCase)
    singleOf(::RecipesByQueryUseCase)
}