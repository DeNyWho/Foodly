package com.example.foodly.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.component.slider.recipe.RecipeSliderComponent
import com.example.foodly.feature.home.model.HomeState
import java.time.LocalDate

internal class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<HomeViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        HomeUI(
            state = state,
        )
    }
}

@Composable
private fun HomeUI(
    modifier: Modifier = Modifier,
    lazyColumnState: LazyListState = rememberLazyListState(),
    state: HomeState,
    onRecipeClick: (Int) -> Unit = { },
) {
    println(state.popularRecipes.error)

    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        state = lazyColumnState,
    ) {
        item {
            RecipeSliderComponent(
                headerTitle = stringResource(R.string.feature_home_section_header_title_popular),
                headerModifier = SliderComponentDefaults.Default,
                contentState = state.popularRecipes,
                onItemClick = onRecipeClick,
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
                onItemClick = onRecipeClick,
                isMoreVisible = true,
                onMoreClick = {

                },
            )
        }
        item {
            RecipeSliderComponent(
                headerTitle = stringResource(R.string.feature_home_section_header_title_healthy),
                headerModifier = SliderComponentDefaults.Default,
                contentState = state.healthyRecipes,
                onItemClick = onRecipeClick,
                isMoreVisible = true,
                onMoreClick = {

                },
            )
        }

    }
}