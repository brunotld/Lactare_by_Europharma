package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.ui.theme.LactareBeige
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.components.CalendarIcon
import com.example.lactare.ui.theme.components.CheckMarkIcon
import com.example.lactare.ui.theme.components.DropIcon
import com.example.lactare.ui.theme.components.HeartIcon
import com.example.lactare.ui.theme.components.IconBadge
import com.example.lactare.ui.theme.components.LactareButton

@Composable
fun QuizResultScreen(
    onScheduleClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareBeige)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Selo de aprovação: círculo em degradê sutil de duas camadas com o check central,
        // no lugar do emoji gigante — visual mais alinhado a um "badge" de app profissional.
        IconBadge(backgroundColor = Color(0xFFDCEEDC), diameter = 108.dp) {
            IconBadge(backgroundColor = Color(0xFF3FA35A), diameter = 80.dp) {
                CheckMarkIcon(iconSize = 36.dp)
            }
        }

        Text(
            text = "Você está apta para continuar!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = LactareBlue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 22.dp)
        )

        Text(
            text = "Com base nas suas respostas, você pode seguir para o agendamento da coleta.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )

        Row(
            modifier = Modifier.padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeartIcon(iconSize = 18.dp, color = LactareBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Perfil: Doadora Lactare", fontSize = 16.sp)
        }

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            DropIcon(iconSize = 18.dp, color = LactareBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Volume estimado: 400 ml", fontSize = 16.sp)
        }

        Row(
            modifier = Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CalendarIcon(iconSize = 18.dp, color = LactareBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Frequência recomendada: semanal", fontSize = 16.sp)
        }

        LactareButton(
            text = "Agendar coleta",
            onClick = onScheduleClick,
            modifier = Modifier.padding(top = 35.dp)
        )
    }
}
