package com.example.lactare.ui.theme.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.lactare.ui.theme.LactareBlue

@Composable
fun IconBadge(
    modifier: Modifier = Modifier,
    diameter: Dp = 88.dp,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.size(diameter),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(diameter)) {
            drawCircle(color = backgroundColor)
        }
        content()
    }
}

@Composable
fun CheckMarkIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 40.dp,
    color: Color = Color.White
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val path = Path().apply {
            moveTo(w * 0.20f, h * 0.55f)
            lineTo(w * 0.42f, h * 0.75f)
            lineTo(w * 0.80f, h * 0.28f)
        }
        drawPath(
            path = path,
            color = color,
            style = Stroke(width = w * 0.11f, cap = StrokeCap.Round, join = StrokeJoin.Round)
        )
    }
}

@Composable
fun DropIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 40.dp,
    color: Color = Color.White
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.05f)
            cubicTo(w * 0.85f, h * 0.45f, w * 0.82f, h * 0.62f, w * 0.5f, h * 0.95f)
            cubicTo(w * 0.18f, h * 0.62f, w * 0.15f, h * 0.45f, w * 0.5f, h * 0.05f)
            close()
        }
        drawPath(path = path, color = color)
    }
}

@Composable
fun HeartIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 32.dp,
    color: Color = Color.White
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.88f)
            cubicTo(w * 0.05f, h * 0.55f, w * 0.05f, h * 0.15f, w * 0.30f, h * 0.08f)
            cubicTo(w * 0.42f, h * 0.04f, w * 0.5f, h * 0.18f, w * 0.5f, h * 0.18f)
            cubicTo(w * 0.5f, h * 0.18f, w * 0.58f, h * 0.04f, w * 0.70f, h * 0.08f)
            cubicTo(w * 0.95f, h * 0.15f, w * 0.95f, h * 0.55f, w * 0.5f, h * 0.88f)
            close()
        }
        drawPath(path = path, color = color)
    }
}

@Composable
fun CalendarIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.08f, h * 0.18f),
            size = Size(w * 0.84f, h * 0.72f),
            cornerRadius = CornerRadius(w * 0.10f),
            style = Stroke(width = w * 0.08f)
        )
        drawLine(
            color = color,
            start = Offset(w * 0.08f, h * 0.40f),
            end = Offset(w * 0.92f, h * 0.40f),
            strokeWidth = w * 0.07f
        )
        drawLine(
            color = color,
            start = Offset(w * 0.30f, h * 0.06f),
            end = Offset(w * 0.30f, h * 0.28f),
            strokeWidth = w * 0.08f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(w * 0.70f, h * 0.06f),
            end = Offset(w * 0.70f, h * 0.28f),
            strokeWidth = w * 0.08f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun ClockIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val center = Offset(w / 2f, h / 2f)
        drawCircle(
            color = color,
            radius = w * 0.42f,
            center = center,
            style = Stroke(width = w * 0.08f)
        )
        drawLine(color = color, start = center, end = Offset(w / 2f, h * 0.28f), strokeWidth = w * 0.08f, cap = StrokeCap.Round)
        drawLine(color = color, start = center, end = Offset(w * 0.66f, h * 0.58f), strokeWidth = w * 0.08f, cap = StrokeCap.Round)
    }
}

@Composable
fun PinIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val path = Path().apply {
            moveTo(w * 0.5f, h * 0.95f)
            cubicTo(w * 0.15f, h * 0.55f, w * 0.15f, h * 0.30f, w * 0.5f, h * 0.05f)
            cubicTo(w * 0.85f, h * 0.30f, w * 0.85f, h * 0.55f, w * 0.5f, h * 0.95f)
            close()
        }
        drawPath(path = path, color = color)
        drawCircle(color = Color.White, radius = w * 0.14f, center = Offset(w * 0.5f, h * 0.36f))
    }
}

@Composable
fun PersonIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        drawCircle(color = color, radius = w * 0.18f, center = Offset(w / 2f, h * 0.28f))
        val path = Path().apply {
            moveTo(w * 0.20f, h * 0.92f)
            cubicTo(w * 0.20f, h * 0.58f, w * 0.80f, h * 0.58f, w * 0.80f, h * 0.92f)
            close()
        }
        drawPath(path = path, color = color)
    }
}

@Composable
fun ListIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        val rows = listOf(0.22f, 0.5f, 0.78f)
        rows.forEach { y ->
            drawCircle(color = color, radius = w * 0.05f, center = Offset(w * 0.12f, h * y))
            drawLine(
                color = color,
                start = Offset(w * 0.26f, h * y),
                end = Offset(w * 0.90f, h * y),
                strokeWidth = w * 0.08f,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun TruckIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.05f, h * 0.30f),
            size = Size(w * 0.55f, h * 0.38f),
            cornerRadius = CornerRadius(w * 0.05f)
        )
        val cabin = Path().apply {
            moveTo(w * 0.60f, h * 0.40f)
            lineTo(w * 0.85f, h * 0.40f)
            lineTo(w * 0.95f, h * 0.55f)
            lineTo(w * 0.95f, h * 0.68f)
            lineTo(w * 0.60f, h * 0.68f)
            close()
        }
        drawPath(path = cabin, color = color)
        drawCircle(color = color, radius = w * 0.08f, center = Offset(w * 0.24f, h * 0.76f))
        drawCircle(color = color, radius = w * 0.08f, center = Offset(w * 0.78f, h * 0.76f))
    }
}

@Composable
fun TrophyIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = LactareBlue
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        drawArc(
            color = color,
            startAngle = 90f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(w * 0.04f, h * 0.14f),
            size = Size(w * 0.30f, h * 0.28f),
            style = Stroke(width = w * 0.06f)
        )
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(w * 0.66f, h * 0.14f),
            size = Size(w * 0.30f, h * 0.28f),
            style = Stroke(width = w * 0.06f)
        )
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.28f, h * 0.12f),
            size = Size(w * 0.44f, h * 0.42f),
            cornerRadius = CornerRadius(w * 0.08f)
        )
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.42f, h * 0.54f),
            size = Size(w * 0.16f, h * 0.20f)
        )
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.26f, h * 0.76f),
            size = Size(w * 0.48f, h * 0.10f),
            cornerRadius = CornerRadius(w * 0.03f)
        )
    }
}

@Composable
fun LockIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 22.dp,
    color: Color = Color(0xFF9AA3AD)
) {
    Canvas(modifier = modifier.size(iconSize)) {
        val w = this.size.width
        val h = this.size.height
        drawArc(
            color = color,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(w * 0.28f, h * 0.08f),
            size = Size(w * 0.44f, h * 0.40f),
            style = Stroke(width = w * 0.09f)
        )
        drawRoundRect(
            color = color,
            topLeft = Offset(w * 0.20f, h * 0.42f),
            size = Size(w * 0.60f, h * 0.46f),
            cornerRadius = CornerRadius(w * 0.08f)
        )
    }
}

