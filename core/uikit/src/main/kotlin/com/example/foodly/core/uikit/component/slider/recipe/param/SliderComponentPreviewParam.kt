package com.example.foodly.core.uikit.component.slider.recipe.param

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.component.card.recipe.CardRecipeDefaults
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.RecipeLight

internal data class SliderComponentPreviewParam(
    val modifier: Modifier = Modifier,
    val headerModifier: Modifier = SliderComponentDefaults.Default,
    val thumbnailHeight: Dp = CardRecipeDefaults.Height.Default,
    val thumbnailWidth: Dp = CardRecipeDefaults.Width.Default,
    val headerTitle: String = "Title",
    val contentState: StateListWrapper<RecipeLight>,
    val contentPadding: PaddingValues = PaddingValues(horizontal = 12.dp),
    val contentArrangement: Arrangement.Horizontal,
    val textAlign: TextAlign = TextAlign.Start,
    val onHeaderClick: () -> Unit = { },
    val onItemClick: (Int) -> Unit = { },
    val isMoreVisible: Boolean = true,
)

internal class SliderComponentProvider :
    PreviewParameterProvider<SliderComponentPreviewParam> {
    override val count: Int
        get() = super.count
    override val values: Sequence<SliderComponentPreviewParam>
        get() = listOf(
            SliderComponentPreviewParam(
                modifier = Modifier,
                headerModifier = SliderComponentDefaults.Default,
                headerTitle = "Scrollable Default",
                contentArrangement = CardRecipeDefaults.HorizontalArrangement.Default,
                contentState = StateListWrapper.loading()
            ),
            SliderComponentPreviewParam(
                modifier = Modifier,
                headerModifier = SliderComponentDefaults.Default,
                headerTitle = "Scrollable Default",
                contentArrangement = CardRecipeDefaults.HorizontalArrangement.Default,
                contentState = StateListWrapper.success(
                    data = GlobalParams.DataRecipes,
                )
            ),
        ).asSequence()
}


