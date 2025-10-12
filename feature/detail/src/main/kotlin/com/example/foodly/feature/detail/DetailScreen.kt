package com.example.foodly.feature.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.example.foodly.feature.detail.navigation.DetailNavigation
import org.koin.compose.getKoin

internal class DetailScreen(val recipeId: Int) : Screen {
    @Composable
    override fun Content() {
        getKoin().setProperty(DetailNavigation.RECIPE_ID_KOIN_PROPERTY, recipeId)

        val viewModel = koinScreenModel<DetailViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        DetailUI()
    }
}

@Composable
private fun DetailUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Detail Screen",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}