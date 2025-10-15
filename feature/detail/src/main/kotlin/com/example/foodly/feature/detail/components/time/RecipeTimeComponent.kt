package com.example.foodly.feature.detail.components.time

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ScheduleSend
import androidx.compose.material.icons.automirrored.rounded.ShowChart
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.icon.FoodlyIcon
import com.example.foodly.core.uikit.icon.FoodlyIconPrimary
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.feature.detail.components.top.RecipeImageComponent

@Composable
internal fun RecipeTimeComponent(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
    horizontalArrangement: Arrangement.Horizontal,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Prep",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )

            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.Default.Schedule,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "time",
            )

            Text(
                text = "${recipe.preparationMinutes}",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )

            Text(
                text = "mins",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Total",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )

            FoodlyIconPrimary(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.Default.Schedule,
                contentDescription = "time",
            )

            Text(
                text = "${recipe.readyInMinutes}",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "mins",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Cook",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )

            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = Icons.Default.Schedule,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "time",
            )

            Text(
                text = "${recipe.cookingMinutes}",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )

            Text(
                text = "mins",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
//    Column(
//        modifier = modifier
//            .fillMaxSize(),
//        verticalArrangement = verticalArrangement,
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth(),
//            elevation = CardDefaults.elevatedCardElevation(
//                defaultElevation = 4.dp,
//            ),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surfaceContainer,
//            ),
//            shape = MaterialTheme.shapes.medium,
//        ) {
//            Text(
//                modifier = Modifier
//                    .padding(horizontal = 24.dp, vertical = 8.dp),
//                text = "Prep Time  - ${recipe.preparationMinutes} mins",
//                color = MaterialTheme.colorScheme.onBackground,
//                style = MaterialTheme.typography.bodyLarge,
//            )
//        }
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth(),
//            elevation = CardDefaults.elevatedCardElevation(
//                defaultElevation = 4.dp,
//            ),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surfaceContainer,
//            ),
//            shape = MaterialTheme.shapes.medium,
//        ) {
//            Text(
//                modifier = Modifier
//                    .padding(horizontal = 24.dp, vertical = 8.dp),
//                text = "Cook Time  - ${recipe.cookingMinutes} mins",
//                color = MaterialTheme.colorScheme.onBackground,
//                style = MaterialTheme.typography.bodyLarge,
//            )
//        }
//
//        Card(
//            modifier = Modifier
//                .fillMaxWidth(),
//            elevation = CardDefaults.elevatedCardElevation(
//                defaultElevation = 4.dp,
//            ),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.surfaceContainer,
//            ),
//            shape = MaterialTheme.shapes.medium,
//        ) {
//            Text(
//                modifier = Modifier
//                    .padding(horizontal = 24.dp, vertical = 8.dp),
//                text = "Total Time - ${recipe.readyInMinutes} mins",
//                color = MaterialTheme.colorScheme.onBackground,
//                style = MaterialTheme.typography.bodyLarge,
//            )
//        }
//    }
}

@Preview
@Composable
private fun PreviewRecipeTimeComponent() {
    DefaultPreview {
        RecipeTimeComponent(
            recipe = GlobalParams.DataRecipeDetail,
            horizontalArrangement = Arrangement.SpaceAround,
        )
    }
}