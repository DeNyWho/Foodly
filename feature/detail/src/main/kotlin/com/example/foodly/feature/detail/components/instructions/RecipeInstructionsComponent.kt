package com.example.foodly.feature.detail.components.instructions

import android.text.Html
import android.text.Spanned
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

@Composable
internal fun RecipeInstructionsComponent(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(R.string.feature_detail_instructions_title),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleMedium,
        )

        Text(
            text = Html.fromHtml(recipe.instructions, Html.FROM_HTML_MODE_LEGACY).toString(),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
private fun PreviewRecipeInstructionsComponent() {
    DefaultPreview {
        RecipeInstructionsComponent(
            recipe = GlobalParams.DataRecipeDetail,
        )
    }
}