package com.example.foodly.core.uikit.component.card.cuisine

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.foodly.core.uikit.R
import com.example.foodly.core.uikit.component.card.cuisine.param.CardCuisinePreviewParam
import com.example.foodly.core.uikit.component.card.cuisine.param.CardCuisineProvider
import com.example.foodly.core.uikit.component.card.recipe.CardRecipe
import com.example.foodly.core.uikit.component.card.recipe.CardRecipeDefaults
import com.example.foodly.core.uikit.component.card.recipe.param.CardRecipePreviewParam
import com.example.foodly.core.uikit.component.card.recipe.param.CardRecipeProvider
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.domain.model.food.recipe.RecipeLight
import com.example.foodly.domain.model.food.recipe.type.RecipeCuisinesType

@Composable
fun CardCuisine(
    modifier: Modifier = Modifier,
    data: RecipeCuisinesType,
    thumbnailWidth: Dp = CardCuisineDefaults.Width.Default,
    thumbnailHeight: Dp = CardCuisineDefaults.Height.Default,
    onClick: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .width(thumbnailWidth)
            .height(thumbnailHeight)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick.invoke(data.value)
            }
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
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
                    .data(data.imageUrl)
                    .build(),
                contentDescription = "Content Thumbnail",
                contentScale = ContentScale.Crop,
                onError = {
                    println(it.result.throwable.message)
                }
            )
        }

        Box(
            modifier
                .background(Color.Black.copy(0.5f))
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                text = data.value,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCardCuisine(
    @PreviewParameter(CardCuisineProvider::class) param: CardCuisinePreviewParam,
) {
    DefaultPreview {
        CardCuisine(
            modifier = param.modifier,
            data = param.data,
            thumbnailHeight = param.thumbnailHeight,
            onClick = param.onClick,
        )
    }
}
