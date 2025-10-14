package com.example.foodly.feature.detail.components.ingredients

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.RecipeDetail
import com.example.foodly.feature.detail.R

@Composable
internal fun RecipeIngredientsComponent(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = stringResource(R.string.feature_detail_ingredients_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
        )

        recipe.extendedIngredients.forEach { ingredient ->
            Text(
                text = ingredient.original,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }

}

@Preview
@Composable
private fun PreviewRecipeIngredientsComponent() {
    DefaultPreview {
        RecipeIngredientsComponent(
            recipe = GlobalParams.DataRecipeDetail,
        )
    }
}