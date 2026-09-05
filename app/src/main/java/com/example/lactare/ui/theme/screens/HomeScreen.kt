package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.model.Appointment
import com.example.lactare.model.User
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.LactareLightBlue
import com.example.lactare.ui.theme.LactarePink
import com.example.lactare.ui.theme.components.DropIcon
import com.example.lactare.ui.theme.components.HeartIcon
import com.example.lactare.ui.theme.components.LactareCard
import com.example.lactare.ui.theme.components.ListIcon
import com.example.lactare.ui.theme.components.TruckIcon

@Composable
fun HomeScreen(
    user: User,
    appointment: Appointment,
    onHistoryClick: () -> Unit,
    onImpactClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareLightBlue)
            .padding(20.dp)
    ) {

        Text(
            text = "Olá, ${user.name.split(" ")[0]}!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = LactareBlue
        )

        Text(
            text = "Seu impacto continua transformando vidas.",
            modifier = Modifier.padding(top = 5.dp)
        )

        LactareCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            containerColor = LactareBlue
        ) {

            Text(
                text = "Seu impacto",
                color = Color.White,
                fontSize = 20.sp
            )

            IconTextRow(
                icon = { DropIcon(iconSize = 20.dp) },
                text = "${user.totalDonatedMl / 1000.0} litros doados",
                textColor = Color.White,
                topPadding = 12.dp
            )

            IconTextRow(
                icon = { HeartIcon(iconSize = 20.dp) },
                text = "${user.babiesHelped} bebês ajudados",
                textColor = Color.White,
                topPadding = 8.dp
            )
        }

        LactareCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
        ) {

            IconTextRow(
                icon = { TruckIcon() },
                text = "Próxima coleta",
                textColor = Color.Black,
                bold = true
            )

            Text(
                text = "${appointment.date} às ${appointment.time}",
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = appointment.status,
                color = LactareBlue,
                fontWeight = FontWeight.Bold
            )
        }

        LactareCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .clickable { onHistoryClick() }
        ) {

            IconTextRow(
                icon = { ListIcon() },
                text = "Ver histórico de doações",
                textColor = Color.Black
            )
        }

        LactareCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
                .clickable { onImpactClick() },
            containerColor = LactarePink
        ) {

            IconTextRow(
                icon = { HeartIcon(iconSize = 20.dp, color = LactareBlue) },
                text = "Ver meu impacto e medalhas",
                textColor = Color.Black
            )
        }
    }
}

@Composable
private fun IconTextRow(
    icon: @Composable () -> Unit,
    text: String,
    textColor: Color,
    bold: Boolean = false,
    topPadding: Dp = 0.dp
) {
    Row(
        modifier = Modifier.padding(top = topPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            color = textColor,
            fontSize = 18.sp,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}
