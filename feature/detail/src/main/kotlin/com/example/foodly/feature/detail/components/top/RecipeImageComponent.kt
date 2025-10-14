package com.example.foodly.feature.detail.components.top

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.core.uikit.theme.FoodlyTheme
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.RecipeDetail

@Composable
internal fun RecipeImageComponent(
    modifier: Modifier = Modifier,
    recipe: RecipeDetail,
) {
    Card(
        modifier = modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp,
        ),
        shape = MaterialTheme.shapes.medium,
    ) {
        AsyncImage(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onSurfaceVariant)
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .build(),
            contentDescription = "Content Thumbnail",
            contentScale = ContentScale.Crop,
            onError = {
                println(it.result.throwable.message)
            }
        )
    }
}

@Preview
@Composable
private fun PreviewRecipeImageComponent() {
    DefaultPreview {
        RecipeImageComponent(
            recipe = GlobalParams.DataRecipeDetail,
        )
    }
}