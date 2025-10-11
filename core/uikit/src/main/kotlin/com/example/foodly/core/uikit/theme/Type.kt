package com.example.foodly.core.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.LineHeightStyle.Alignment
import androidx.compose.ui.text.style.LineHeightStyle.Trim
import androidx.compose.ui.unit.sp
import com.example.foodly.core.uikit.R
import com.example.foodly.domain.model.common.device.FontSizePrefs

private val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.nunito_bold, FontWeight.Bold, FontStyle.Normal),
)

private val InterFontFamily = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.inter_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.inter_bold, FontWeight.Bold, FontStyle.Normal),
)

private const val lineHeightMultiplier = 1.15

/**
 * Foodly typography
 */
internal fun foodlyTypography(fontSizePrefs: FontSizePrefs): Typography {
    return Typography(
        titleLarge = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = (20 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((20 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.sp,
            lineHeightStyle = LineHeightStyle(
                alignment = Alignment.Bottom,
                trim = Trim.LastLineBottom,
            ),
            fontFamily = InterFontFamily,
        ),
        titleMedium = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = (16 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((16 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.1.sp,
            fontFamily = InterFontFamily,
        ),
        titleSmall = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = (14 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((14 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.1.sp,
            fontFamily = InterFontFamily,
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = (16 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((16 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.25.sp,
            fontFamily = InterFontFamily,
        ),
        bodyMedium = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = (14 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((14 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.25.sp,
            fontFamily = InterFontFamily,
        ),
        bodySmall = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = (12 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((12 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.4.sp,
            fontFamily = InterFontFamily,
        ),
        // Used for Button
        labelLarge = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = (16 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((16 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.1.sp,
            lineHeightStyle = LineHeightStyle(
                alignment = Alignment.Center,
                trim = Trim.LastLineBottom,
            ),
            fontFamily = InterFontFamily,
        ),
        labelSmall = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = (11 + fontSizePrefs.fontSizeExtra).sp,
            lineHeight = ((11 + fontSizePrefs.fontSizeExtra) * lineHeightMultiplier).sp,
            letterSpacing = 0.1.sp,
            lineHeightStyle = LineHeightStyle(
                alignment = Alignment.Center,
                trim = Trim.LastLineBottom,
            ),
            fontFamily = InterFontFamily,
        )
    )
}