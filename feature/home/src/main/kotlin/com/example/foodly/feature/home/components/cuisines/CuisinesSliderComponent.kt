package com.example.foodly.feature.home.components.cuisines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.component.card.cuisine.CardCuisine
import com.example.foodly.core.uikit.component.slider.SliderComponentDefaults
import com.example.foodly.core.uikit.component.slider.header.SliderHeader
import com.example.foodly.domain.model.food.recipe.type.RecipeCuisinesType
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType
import com.example.foodly.feature.home.R
import com.example.foodly.feature.home.components.category.item.CategorySliderItemComponent

@Composable
internal fun CuisinesSliderComponent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    onCuisineClick: (String) -> Unit,
) {
    SliderHeader(
        modifier = SliderComponentDefaults.Default,
        title = stringResource(R.string.feature_home_section_header_title_cuisines),
        isMoreVisible = false,
    )

    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(
            RecipeCuisinesType::class.sealedSubclasses.mapNotNull { it.objectInstance },
            key = { it.value }
        ) { cuisine ->
            CardCuisine(
                data = cuisine,
                onClick = onCuisineClick,
            )

        }
    }
}