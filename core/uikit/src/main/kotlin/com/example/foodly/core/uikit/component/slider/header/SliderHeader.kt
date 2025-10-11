package com.example.foodly.core.uikit.component.slider.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons.AutoMirrored
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.R
import com.example.foodly.core.uikit.icon.FoodlyIconPrimary
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.core.uikit.util.clickableWithoutRipple

@Composable
fun SliderHeader(
    modifier: Modifier = Modifier,
    title: String = "Title",
    isMoreVisible: Boolean = false,
    onMoreClick: () -> Unit = { },
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
        )

        if (isMoreVisible) {
            Row(
                modifier = Modifier.clickableWithoutRipple {
                    onMoreClick.invoke()
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = stringResource(R.string.core_uikit_card_more),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall,
                )

                FoodlyIconPrimary(
                    modifier = Modifier.size(16.dp),
                    AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = "content description",
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewSliderHeader() {
    DefaultPreview {
        SliderHeader()
    }
}