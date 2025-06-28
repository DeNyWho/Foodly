package com.example.foodly

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.foodly.feature.detail.di.detailModule
import com.example.foodly.feature.detail.di.detailModuleScreen
import com.example.foodly.feature.explore.di.exploreModule
import com.example.foodly.feature.explore.di.exploreModuleScreen
import com.example.foodly.feature.favourite.di.favouriteModule
import com.example.foodly.feature.favourite.di.favouriteModuleScreen
import com.example.foodly.feature.home.di.homeModule
import com.example.foodly.feature.home.di.homeModuleScreen
import com.example.foodly.feature.search.di.searchModule
import com.example.foodly.feature.search.di.searchModuleScreen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FoodlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FoodlyApplication)
            modules(
                homeModule,
                searchModule,
                detailModule,
                favouriteModule,
                exploreModule,
            )
        }

        ScreenRegistry {
            homeModuleScreen()
            searchModuleScreen()
            detailModuleScreen()
            favouriteModuleScreen()
            exploreModuleScreen()
        }
    }
}