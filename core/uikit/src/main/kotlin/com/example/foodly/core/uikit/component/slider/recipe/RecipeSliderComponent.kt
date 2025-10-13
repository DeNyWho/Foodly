package com.example.foodly.core.uikit.component.slider.recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.component.card.recipe.CardRecipe
import com.example.foodly.core.uikit.component.card.recipe.CardRecipeDefaults
import com.example.foodly.core.uikit.component.card.recipe.showCardRecipeShimmer
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.component.slider.header.SliderHeader
import com.example.foodly.core.uikit.component.slider.header.SliderHeaderShimmer
import com.example.foodly.core.uikit.component.slider.recipe.param.SliderComponentPreviewParam
import com.example.foodly.core.uikit.component.slider.recipe.param.SliderComponentProvider
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer

@Composable
fun RecipeSliderComponent(
    modifier: Modifier = Modifier,
    headerModifier: Modifier = SliderComponentDefaults.BottomOnly,
    shimmer: Shimmer = rememberShimmer(ShimmerBounds.View),
    thumbnailHeight: Dp = CardRecipeDefaults.Height.Default,
    thumbnailWidth: Dp = CardRecipeDefaults.Width.Default,
    headerTitle: String,
    contentState: StateListWrapper<RecipeLight>,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    contentArrangement: Arrangement.Horizontal = CardRecipeDefaults.HorizontalArrangement.Default,
    textAlign: TextAlign = TextAlign.Start,
    onItemClick: (Int) -> Unit,
    isMoreVisible: Boolean = false,
    onMoreClick: () -> Unit = { },
) {
    when(contentState) {
        is StateListWrapper.Loading -> {
            SliderHeaderShimmer(
                modifier = headerModifier,
                shimmerInstance = shimmer,
            )
        }
        is StateListWrapper.Success -> {
            SliderHeader(
                modifier = headerModifier,
                title = headerTitle,
                isMoreVisible = isMoreVisible,
                onMoreClick = onMoreClick,
            )
        }
        is StateListWrapper.Error -> {

        }
    }

    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = contentArrangement,
    ) {
        when(contentState) {
            is StateListWrapper.Loading -> {
                showCardRecipeShimmer(
                    shimmerInstance = shimmer,
                    thumbnailHeight = thumbnailHeight,
                    thumbnailWidth = thumbnailWidth,
                )
            }
            is StateListWrapper.Success -> {
                items(
                    contentState.data,
                    key = { it.id },
                ) { data ->
                    CardRecipe(
                        data = data,
                        thumbnailHeight = thumbnailHeight,
                        thumbnailWidth = thumbnailWidth,
                        textAlign = textAlign,
                        onClick = { onItemClick.invoke(data.id) },
                    )
                }
            }
            is StateListWrapper.Error -> {

            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewScrollableHorizontalContentDefault(
    @PreviewParameter(SliderComponentProvider::class) param: SliderComponentPreviewParam,
) {
    DefaultPreview(true) {
        RecipeSliderComponent(
            modifier = param.modifier,
            headerModifier = param.headerModifier,
            thumbnailHeight = param.thumbnailHeight,
            thumbnailWidth = param.thumbnailWidth,
            headerTitle = param.headerTitle,
            contentState = param.contentState,
            contentPadding = param.contentPadding,
            contentArrangement = param.contentArrangement,
            textAlign = param.textAlign,
            onItemClick = param.onItemClick,
            isMoreVisible = param.isMoreVisible,
        )
    }
}
