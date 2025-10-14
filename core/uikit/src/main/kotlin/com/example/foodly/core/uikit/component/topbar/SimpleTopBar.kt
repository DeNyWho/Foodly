package com.example.foodly.core.uikit.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons.AutoMirrored
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodly.core.uikit.icon.FoodlyIconPrimary
import com.example.foodly.core.uikit.util.DefaultPreview
import com.example.foodly.core.uikit.util.clickableWithoutRipple

@Composable
fun SimpleTopBar(
    modifier: Modifier = Modifier,
    title: String = "Title",
    onBackClick: () -> Unit = { },
) {
    Surface(
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.background,
    ) {
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            FoodlyIconPrimary(
                modifier = Modifier
                    .clickableWithoutRipple(
                        onClick = onBackClick,
                    )
                    .size(24.dp),
                AutoMirrored.Filled.ArrowBackIos,
                contentDescription = "content description",
            )

            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewSimpleTopBar() {
    DefaultPreview {
        SimpleTopBar()
    }
}