package com.example.foodly.feature.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.foodly.core.uikit.component.topbar.SimpleTopBar
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.feature.detail.components.ingredients.RecipeIngredientsComponent
import com.example.foodly.feature.detail.components.instructions.RecipeInstructionsComponent
import com.example.foodly.feature.detail.components.nutrition.RecipeNutritionComponent
import com.example.foodly.feature.detail.components.time.RecipeTimeComponent
import com.example.foodly.feature.detail.components.top.RecipeImageComponent
import com.example.foodly.feature.detail.model.DetailAction
import com.example.foodly.feature.detail.model.DetailEvent
import com.example.foodly.feature.detail.model.DetailState
import com.example.foodly.feature.detail.navigation.DetailNavigation
import com.example.foodly.feature.detail.param.DetailScreenPreviewParam
import com.example.foodly.feature.detail.param.DetailScreenProvider
import org.koin.compose.getKoin

internal class DetailScreen(val recipeId: Int) : Screen {
    @Composable
    override fun Content() {
        getKoin().setProperty(DetailNavigation.RECIPE_ID_KOIN_PROPERTY, recipeId)

        val viewModel = koinScreenModel<DetailViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        val action by viewModel.action.collectAsStateWithLifecycle(initialValue = null)

        DetailUI(
            state = state,
            eventHandler = viewModel::handleEvent,
        )

        DetailActions(
            action = action,
        )
    }
}

@Composable
private fun DetailUI(
    modifier: Modifier = Modifier,
    state: DetailState,
    eventHandler: (DetailEvent) -> Unit,
) {
    when(state.recipe) {
        is StateWrapper.Loading -> {

        }
        is StateWrapper.Success -> {
            Scaffold(
                modifier = modifier
                    .fillMaxSize(),
                topBar = {
                    SimpleTopBar(
                        title = state.recipe.data.title,
                        onBackClick = {
                            eventHandler(
                                DetailEvent.OnBack
                            )
                        },
                    )
                }
            ) { padding ->
                DetailContentUI(
                    modifier = Modifier
                        .padding(padding),
                    recipe = state.recipe.data,
                )
            }
        }
        is StateWrapper.Error -> {

        }
    }
}

@Composable
private fun DetailContentUI(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
) {
    val configuration = LocalConfiguration.current
    val containerSize = LocalWindowInfo.current.containerSize
    val density = LocalDensity.current.density
    val screenWidth = containerSize.width.dp / density
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    when {
        screenWidth > 600.dp || (isLandscape && screenWidth > 480.dp) -> DetailContent(
            modifier = modifier
                .padding(horizontal = 20.dp),
            recipe = recipe,
        )
        else -> DetailContentCompact(
            modifier = modifier
                .padding(horizontal = 20.dp),
            recipe = recipe,
        )
    }

}

@Composable
private fun DetailContentCompact(
    modifier: Modifier = Modifier,
    lazyColumnState: LazyListState = rememberLazyListState(),
    recipe: RecipeDetail,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        state = lazyColumnState,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        item {
            RecipeImageComponent(
                recipe = recipe,
            )
        }
        item {
            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = recipe.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeTimeComponent(
                modifier = Modifier
                    .fillMaxWidth(),
                recipe = recipe,
                horizontalArrangement = Arrangement.SpaceAround,
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeIngredientsComponent(
                recipe = recipe,
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeNutritionComponent(
                recipeDetail = recipe,
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeInstructionsComponent(
                recipe = recipe,
            )
        }
    }
}

@Composable
private fun DetailContent(
    modifier: Modifier = Modifier,
    lazyColumnState: LazyListState = rememberLazyListState(),
    recipe: RecipeDetail,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        state = lazyColumnState,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        item {
            Row {
                RecipeImageComponent(
                    modifier = Modifier
                        .weight(1f)
                        .height(220.dp),
                    recipe = recipe,
                )

                Spacer(
                    modifier = Modifier
                        .width(16.dp),
                )

                Column(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = recipe.title,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    RecipeTimeComponent(
                        modifier = Modifier
                            .fillMaxWidth(),
                        recipe = recipe,
                        horizontalArrangement = Arrangement.spacedBy(40.dp),
                    )
                }
            }
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeIngredientsComponent(
                recipe = recipe,
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeNutritionComponent(
                recipeDetail = recipe,
                horizontalArrangement = Arrangement
                    .spacedBy(
                        space = 24.dp,
                        alignment = Alignment.Start,
                    ),
            )
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 8.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        item {
            RecipeInstructionsComponent(
                recipe = recipe,
            )
        }
    }
}

@Composable
private fun DetailActions(action: DetailAction?) {
    val navigator = LocalNavigator.currentOrThrow

    LaunchedEffect(action) {
        when(action) {
            null -> Unit
            DetailAction.NavigateUp -> navigator.pop()
            is DetailAction.ShowError -> {

            }
        }
    }
}


@PreviewScreenSizes
@Composable
private fun PreviewDetailUI(
    @PreviewParameter(DetailScreenProvider::class) param: DetailScreenPreviewParam,
) {
    DefaultPreview {
        DetailUI(
            state = param.state,
            eventHandler = { },
        )
    }
}