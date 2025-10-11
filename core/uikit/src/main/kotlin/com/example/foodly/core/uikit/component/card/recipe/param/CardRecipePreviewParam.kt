package com.example.foodly.core.uikit.component.card.recipe.param

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import com.example.foodly.core.uikit.component.card.recipe.CardRecipeDefaults
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.domain.model.food.recipe.RecipeLight

internal data class CardRecipePreviewParam(
    val modifier: Modifier = Modifier,
    val thumbnailHeight: Dp,
    val data: RecipeLight = GlobalParams.DataRecipeLightSingle,
    val onClick: () -> Unit = { },
)

internal class CardRecipeProvider: PreviewParameterProvider<CardRecipePreviewParam> {
    override val values: Sequence<CardRecipePreviewParam>
        get() = listOf(
            CardRecipePreviewParam(
                modifier = Modifier.width(CardRecipeDefaults.Width.Default),
                thumbnailHeight = CardRecipeDefaults.Height.Default,
            ),
            CardRecipePreviewParam(
                modifier = Modifier.width(CardRecipeDefaults.Width.Min),
                thumbnailHeight = CardRecipeDefaults.Height.Min,
            ),
            CardRecipePreviewParam(
                modifier = Modifier.width(CardRecipeDefaults.Width.Small),
                thumbnailHeight = CardRecipeDefaults.Height.Small,
            )
        ).asSequence()
}