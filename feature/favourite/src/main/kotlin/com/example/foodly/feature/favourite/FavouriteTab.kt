package com.example.foodly.feature.favourite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions

object FavouriteTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(R.string.feature_favourite_navigation_tab_title)
            val icon = painterResource(R.drawable.feature_favourite_icon_tab)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = FavouriteScreen())
    }

    private fun readResolve(): Any = FavouriteTab
}