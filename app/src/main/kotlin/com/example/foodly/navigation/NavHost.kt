package com.example.foodly.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.foodly.core.uikit.component.navigation.FoodlyNavigationBar
import com.example.foodly.core.uikit.component.navigation.FoodlyNavigationBarItem
import com.example.foodly.core.uikit.icon.FoodlyIcon
import com.example.foodly.feature.favourite.FavouriteTab
import com.example.foodly.feature.home.HomeTab
import com.example.foodly.feature.search.SearchTab

@Composable
fun NavHost() {
    TabNavigator(
        tab = HomeTab,
        tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = listOf(
                    HomeTab,
                    SearchTab,
                    FavouriteTab,
                )
            )
        }
    ) { tabNavigator ->
        Scaffold(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .systemBarsPadding(),
            content = { padding ->
                Box(
                    Modifier.padding(padding)
                ) {
                    CurrentTab()
                }
            },
            bottomBar = {
                FoodlyNavigationBar (
                    modifier = Modifier
                        .height(64.dp)
                        .navigationBarsPadding(),
                ) {
                    TabNavigationItem(HomeTab)
                    TabNavigationItem(SearchTab)
                    TabNavigationItem(FavouriteTab)
                }
            }
        )
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    FoodlyNavigationBarItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        alwaysShowLabel = false,
        icon = {
            FoodlyIcon(
                modifier = Modifier.size(20.dp),
                painter = tab.options.icon!!,
                contentDescription = tab.options.title,
            )
        },
        label = {
            Text(
                text = tab.options.title,
                style = MaterialTheme.typography.titleSmall,
            )
        },
    )
}