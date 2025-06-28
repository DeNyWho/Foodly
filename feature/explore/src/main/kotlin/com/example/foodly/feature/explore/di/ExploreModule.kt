package com.example.foodly.feature.explore.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.explore.ExploreScreen
import com.example.foodly.feature.explore.ExploreViewModel
import org.koin.dsl.module

val exploreModule = module {
    factory<ExploreViewModel> {
        ExploreViewModel()
    }
}

val exploreModuleScreen = screenModule {
    register<SharedScreen.ExploreScreen> { _ ->
        ExploreScreen()
    }
}

