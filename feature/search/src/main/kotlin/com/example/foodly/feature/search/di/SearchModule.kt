package com.example.foodly.feature.search.di

import cafe.adriel.voyager.core.registry.screenModule
import com.example.foodly.core.navigation.SharedScreen
import com.example.foodly.feature.search.SearchScreen
import com.example.foodly.feature.search.SearchViewModel
import org.koin.dsl.module

val searchModule = module {
    factory<SearchViewModel> {
        SearchViewModel()
    }
}

val searchModuleScreen = screenModule {
    register<SharedScreen.SearchScreen> { _ ->
        SearchScreen()
    }
}

