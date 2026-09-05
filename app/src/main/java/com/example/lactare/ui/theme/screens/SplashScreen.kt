package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.R
import com.example.lactare.ui.theme.LactareBlue
import androidx.compose.foundation.layout.fillMaxSize
import com.example.lactare.ui.theme.components.LactareButton

@Composable
fun SplashScreen(
    onNavigateToWelcome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareBlue)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_lactare),
            contentDescription = "Logo Lactare",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Lactare",
            color = Color.White,
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "by Eurofarma",
            color = Color(0xFFFFF200),
            fontSize = 20.sp
        )

        Text(
            text = "Cada gota de leite pode transformar uma vida.",
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 24.dp)
        )

        LactareButton(
            text = "Continuar",
            onClick = onNavigateToWelcome,
            modifier = Modifier.padding(top = 40.dp)
        )
    }
}
