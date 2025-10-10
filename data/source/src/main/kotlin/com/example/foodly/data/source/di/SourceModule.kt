package com.example.foodly.data.source.di

import com.example.foodly.data.source.repository.recipe.RecipesRepositoryImpl
import com.example.foodly.domain.repository.recipe.RecipesRepository
import org.koin.dsl.module

val sourceModule = module {
    single<RecipesRepository> {
        RecipesRepositoryImpl(
            recipesService = get(),
        )
    }
}