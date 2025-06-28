package com.example.foodly.feature.favourite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel

internal class FavouriteScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<FavouriteViewModel>()

        FavouriteUI()
    }
}

@Composable
private fun FavouriteUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Favourite Screen",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}