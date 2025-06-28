package com.example.foodly.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data object HomeScreen : SharedScreen()
    data class DetailScreen(val id: Int) : SharedScreen()
    data object FavouriteScreen : SharedScreen()
    data object SearchScreen : SharedScreen()
    data object ExploreScreen : SharedScreen()
}