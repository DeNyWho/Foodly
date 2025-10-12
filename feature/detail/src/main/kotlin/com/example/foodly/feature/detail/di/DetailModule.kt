package com.example.foodly.feature.detail.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.detail.DetailScreen
import com.example.foodly.feature.detail.DetailViewModel
import com.example.foodly.feature.detail.navigation.DetailNavigation
import org.koin.dsl.module

val detailModule = module {
    factory<DetailViewModel> {
        DetailViewModel(
            recipeId = getProperty(DetailNavigation.RECIPE_ID_KOIN_PROPERTY),
            recipeInformationUseCase = get(),
        )
    }
}

val detailModuleScreen = screenModule {
    register<SharedScreen.DetailScreen> { provider ->
        DetailScreen(recipeId = provider.id)
    }
}

