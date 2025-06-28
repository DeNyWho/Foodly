package com.example.foodly.feature.favourite.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.favourite.FavouriteScreen
import com.example.foodly.feature.favourite.FavouriteViewModel
import org.koin.dsl.module

val favouriteModule = module {
    factory<FavouriteViewModel> {
        FavouriteViewModel()
    }
}

val favouriteModuleScreen = screenModule {
    register<SharedScreen.FavouriteScreen> { _ ->
        FavouriteScreen()
    }
}

