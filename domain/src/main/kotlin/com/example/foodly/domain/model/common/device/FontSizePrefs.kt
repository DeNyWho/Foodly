package com.example.foodly.domain.model.common.device

import kotlinx.serialization.Serializable

@Serializable
enum class FontSizePrefs(
    val key: String,
    val fontSizeExtra: Int,
) {
    SMALL("S", -2),
    MEDIUM("M", 0),
    LARGE("L", 2),
    EXTRA_LARGE("XL", 4);
}