package com.example.foodly.feature.detail.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.detail.DetailScreen
import com.example.foodly.feature.detail.DetailViewModel
import org.koin.dsl.module

val detailModule = module {
    factory<DetailViewModel> {
        DetailViewModel()
    }
}

val detailModuleScreen = screenModule {
    register<SharedScreen.DetailScreen> { _ ->
        DetailScreen()
    }
}

