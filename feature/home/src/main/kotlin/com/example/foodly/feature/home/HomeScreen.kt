package com.example.foodly.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.foodly.core.navigation.SharedScreen.*
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.component.slider.recipe.RecipeSliderComponent
import com.example.foodly.feature.home.components.category.CategorySliderComponent
import com.example.foodly.feature.home.components.cuisines.CuisinesSliderComponent
import com.example.foodly.feature.home.model.HomeAction
import com.example.foodly.feature.home.model.HomeEvent
import com.example.foodly.feature.home.model.HomeState

internal class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<HomeViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        val action by viewModel.action.collectAsStateWithLifecycle(initialValue = null)

        HomeUI(
            state = state,
            eventHandler = viewModel::handleEvent,
        )

        HomeActions(
            action = action,
        )
    }

    @Composable
    private fun HomeUI(
        modifier: Modifier = Modifier,
        lazyColumnState: LazyListState = rememberLazyListState(),
        state: HomeState,
        eventHandler: (HomeEvent) -> Unit,
    ) {
        println(state.popularRecipes.error)

        LazyColumn(
            modifier = modifier
                .fillMaxWidth(),
            state = lazyColumnState,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            item {
                CategorySliderComponent(
                    onCategoryClick = {},
                )
            }
            item {
                RecipeSliderComponent(
                    headerTitle = stringResource(R.string.feature_home_section_header_title_popular),
                    headerModifier = SliderComponentDefaults.Default,
                    contentState = state.popularRecipes,
                    onItemClick = { recipeId ->
                        eventHandler.invoke(HomeEvent.OnRecipeCardClick(recipeId))
                    },
                    isMoreVisible = true,
                    onMoreClick = {

                    },
                )
            }
            item {
                RecipeSliderComponent(
                    headerTitle = stringResource(R.string.feature_home_section_header_title_fast),
                    headerModifier = SliderComponentDefaults.Default,
                    contentState = state.fastRecipes,
                    onItemClick = { recipeId ->
                        eventHandler.invoke(HomeEvent.OnRecipeCardClick(recipeId))
                    },
                    isMoreVisible = true,
                    onMoreClick = {

                    },
                )
            }
            item {
                CuisinesSliderComponent(
                    onCuisineClick = {

                    },
                )
            }
            item {
                RecipeSliderComponent(
                    headerTitle = stringResource(R.string.feature_home_section_header_title_healthy),
                    headerModifier = SliderComponentDefaults.Default,
                    contentState = state.healthyRecipes,
                    onItemClick = { recipeId ->
                        eventHandler.invoke(HomeEvent.OnRecipeCardClick(recipeId))
                    },
                    isMoreVisible = true,
                    onMoreClick = {

                    },
                )
            }

        }
    }

    @Composable
    fun HomeActions(action: HomeAction?) {
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(action) {
            when(action) {
                null -> Unit
                is HomeAction.NavigateToRecipeDetail -> {
                    navigator.push(
                        item = ScreenRegistry.get(
                            provider = DetailScreen(id = action.recipeId)
                        )
                    )
                }
                is HomeAction.NavigateToCuisine -> {

                }
                is HomeAction.ShowError -> { }
            }
        }
    }
}