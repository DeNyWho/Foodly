package com.example.foodly.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.home.HomeScreen
import com.example.foodly.feature.home.HomeViewModel
import org.koin.dsl.module

val homeModule = module {
    factory<HomeViewModel> {
        HomeViewModel()
    }
}

val homeModuleScreen = screenModule {
    register<SharedScreen.HomeScreen> { _ ->
        HomeScreen()
    }
}

