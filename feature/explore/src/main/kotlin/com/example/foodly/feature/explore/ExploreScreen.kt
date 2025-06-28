package com.example.foodly.feature.explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

internal class ExploreScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<ExploreViewModel>()

        ExploreUI()
    }
}

@Composable
private fun ExploreUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Explore Screen",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}