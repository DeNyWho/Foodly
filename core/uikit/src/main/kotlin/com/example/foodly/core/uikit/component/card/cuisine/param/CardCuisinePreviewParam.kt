package com.example.foodly.core.uikit.component.card.cuisine.param

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import com.example.foodly.core.uikit.component.card.cuisine.CardCuisineDefaults
import com.example.foodly.core.uikit.component.card.recipe.CardRecipeDefaults
import com.example.foodly.domain.model.food.recipe.type.RecipeCuisinesType

internal data class CardCuisinePreviewParam(
    val modifier: Modifier = Modifier,
    val data: RecipeCuisinesType,
    val thumbnailWidth: Dp = CardCuisineDefaults.Width.Default,
    val thumbnailHeight: Dp = CardCuisineDefaults.Height.Default,
    val onClick: (String) -> Unit = { },
)

internal class CardCuisineProvider: PreviewParameterProvider<CardCuisinePreviewParam> {
    override val values: Sequence<CardCuisinePreviewParam>
        get() = listOf(
            CardCuisinePreviewParam(
                modifier = Modifier.width(CardCuisineDefaults.Width.Default),
                data = RecipeCuisinesType.European,
                thumbnailHeight = CardCuisineDefaults.Height.Default,
            ),
            CardCuisinePreviewParam(
                modifier = Modifier.width(CardCuisineDefaults.Width.Min),
                data = RecipeCuisinesType.Indian,
                thumbnailHeight = CardCuisineDefaults.Height.Min,
            ),
            CardCuisinePreviewParam(
                modifier = Modifier.width(CardCuisineDefaults.Width.Small),
                data = RecipeCuisinesType.EasternEuropean,
                thumbnailHeight = CardCuisineDefaults.Height.Small,
            )
        ).asSequence()
}