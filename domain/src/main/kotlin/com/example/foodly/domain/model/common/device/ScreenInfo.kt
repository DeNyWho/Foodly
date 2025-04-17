package com.example.foodly.domain.model.common.device

data class ScreenInfo(
    val screenType: ScreenType = ScreenType.MEDIUM,
    val fontSizePrefs: FontSizePrefs = FontSizePrefs.MEDIUM,
    val portraitWidthDp: Int = 400,
    val portraitHeightDp: Int = 800,
    val landscapeWidthDp: Int = 800,
    val landscapeHeightDp: Int = 400,
)