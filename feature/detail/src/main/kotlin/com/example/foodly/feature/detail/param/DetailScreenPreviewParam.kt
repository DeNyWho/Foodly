package com.example.foodly.feature.detail.param

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.foodly.core.uikit.param.GlobalParams
import com.example.foodly.domain.model.common.request.StateWrapper
import com.example.foodly.feature.detail.model.DetailState

internal data class DetailScreenPreviewParam(
    val state: DetailState,
)

internal class DetailScreenProvider: PreviewParameterProvider<DetailScreenPreviewParam> {
    override val values: Sequence<DetailScreenPreviewParam>
        get() = listOf(
            DetailScreenPreviewParam(
                state = DetailState(
                    recipe = StateWrapper.loading(),
                )
            ),
            DetailScreenPreviewParam(
                state = DetailState(
                    recipe = StateWrapper.success(GlobalParams.DataRecipeDetail),
                )
            ),
        ).asSequence()
}