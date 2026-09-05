package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.model.Appointment
import com.example.lactare.ui.theme.LactareBeige
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.components.CalendarIcon
import com.example.lactare.ui.theme.components.CheckMarkIcon
import com.example.lactare.ui.theme.components.ClockIcon
import com.example.lactare.ui.theme.components.IconBadge
import com.example.lactare.ui.theme.components.LactareButton
import com.example.lactare.ui.theme.components.PersonIcon
import com.example.lactare.ui.theme.components.PinIcon

@Composable
fun ConfirmationScreen(
    appointment: Appointment,
    onGoHome: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareBeige)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IconBadge(backgroundColor = LactareBlue, diameter = 88.dp) {
            CheckMarkIcon(iconSize = 40.dp)
        }

        Text(
            text = "Coleta agendada!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = LactareBlue,
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "Sua coleta foi confirmada com sucesso.",
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.padding(top = 12.dp))

        InfoRow(icon = { CalendarIcon() }, text = appointment.date)
        InfoRow(icon = { ClockIcon() }, text = appointment.time)
        InfoRow(icon = { PinIcon() }, text = appointment.address)
        InfoRow(icon = { PersonIcon() }, text = "Coletora: ${appointment.collectorName}")

        LactareButton(
            text = "Ir para início",
            onClick = onGoHome,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

@Composable
private fun InfoRow(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = text, fontSize = 16.sp)
    }
}
