package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.LactareLightBlue
import com.example.lactare.ui.theme.components.DropIcon
import com.example.lactare.ui.theme.components.HeartIcon
import com.example.lactare.ui.theme.components.IconBadge
import com.example.lactare.ui.theme.components.LactareButton
import com.example.lactare.ui.theme.components.SectionTitle

@Composable
fun WelcomeScreen(
    onStartRegister: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareLightBlue)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IconBadge(backgroundColor = LactareBlue, diameter = 76.dp) {
            HeartIcon(iconSize = 34.dp)
        }

        SectionTitle(
            text = "Bem-vinda ao Lactare"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Conectamos mães doadoras aos bancos de leite para ajudar bebês que precisam.",
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            DropIcon(iconSize = 18.dp, color = LactareBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Mais de 25 mil litros já doados",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        LactareButton(
            text = "Quero ser uma doadora",
            onClick = onStartRegister
        )
    }
}
