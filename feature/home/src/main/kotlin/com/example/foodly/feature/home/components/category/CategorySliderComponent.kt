package com.example.foodly.feature.home.components.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.component.card.recipe.CardRecipe
import com.example.foodly.core.uikit.component.card.recipe.showCardRecipeShimmer
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.component.slider.header.SliderHeader
import com.example.foodly.core.uikit.component.slider.header.SliderHeaderShimmer
import com.example.foodly.domain.model.common.request.StateListWrapper
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType
import com.example.foodly.feature.home.R
import com.example.foodly.feature.home.components.category.item.CategorySliderItemComponent
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer

@Composable
fun CategorySliderComponent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    onCategoryClick: (String) -> Unit,
) {
    SliderHeader(
        modifier = SliderComponentDefaults.Default,
        title = stringResource(R.string.feature_home_section_header_title_categories),
        isMoreVisible = false,
    )

    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            RecipeMealType.allValues(),
            key = { it.value }
        ) { category ->
            CategorySliderItemComponent(
                category = category,
                onClick = onCategoryClick,
            )

        }
    }
}