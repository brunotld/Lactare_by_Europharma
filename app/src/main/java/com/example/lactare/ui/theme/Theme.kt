package com.example.lactare.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.LactareLightBlue
import com.example.lactare.ui.theme.LactarePink
import com.example.lactare.ui.theme.LactareYellow
import com.example.lactare.ui.theme.White

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