package com.example.foodly.feature.detail.components.nutrition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.feature.detail.R
import com.example.foodly.feature.detail.components.nutrition.item.RecipeNutritionItemComponent

@Composable
internal fun RecipeNutritionComponent(
    modifier: Modifier = Modifier,
    recipeDetail: RecipeDetail,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceEvenly
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = stringResource(R.string.feature_detail_nutrition_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
        )

        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = horizontalArrangement,
        ) {
            recipeDetail.nutrition.nutrients.forEach { nutrient ->
                when(nutrient.name) {
                    "Calories", "Protein", "Fat", "Carbohydrates" -> {
                        RecipeNutritionItemComponent(
                            recipeNutrient = nutrient,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PReviewRecipeNutritionComponent() {
    DefaultPreview {
        RecipeNutritionComponent(
            recipeDetail = GlobalParams.DataRecipeDetail,
        )
    }
}