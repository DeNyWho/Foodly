package com.example.foodly.feature.detail.components.time

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodly.domain.model.food.recipe.RecipeDetail

@Composable
internal fun RecipeTimeComponent(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
    verticalArrangement: Arrangement.Vertical,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = verticalArrangement,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = "Prep Time  - ${recipe.preparationMinutes} mins",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = "Cook Time  - ${recipe.cookingMinutes} mins",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge,
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 4.dp,
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = "Total Time - ${recipe.readyInMinutes} mins",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }

}