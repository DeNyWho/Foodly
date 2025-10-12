package com.example.foodly.feature.home.components.category.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.type.RecipeMealType

@Composable
internal fun CategorySliderItemComponent(
    modifier: Modifier = Modifier,
    category: RecipeMealType,
    onClick: (String) -> Unit,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp,
        ),
    ) {
        Column(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                    onClick.invoke(category.value)
                },
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                text = category.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewMealTypeComponent() {
    DefaultPreview {
        CategorySliderItemComponent(
            category = RecipeMealType.MainCourse,
            onClick = { },
        )
    }
}