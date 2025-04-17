package com.example.foodly.domain.model.common.device

enum class ThemeType(
    private val title: String,
) {
    SYSTEM("system"),
    LIGHT("light"),
    DARK("dark");

    override fun toString(): String {
        return title
    }

    companion object {
        fun fromString(value: String): ThemeType? {
            return entries.find { it.toString() == value }
        }
    }
}