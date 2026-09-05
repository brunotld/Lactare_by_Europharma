package com.example.lactare.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LactareColorScheme = lightColorScheme(
    primary = LactareBlue,
    secondary = LactareYellow,
    background = LactareLightBlue,
    surface = White,
    tertiary = LactarePink
)

@Composable
fun LactareTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LactareColorScheme,
        typography = Typography,
        content = content
    )
}