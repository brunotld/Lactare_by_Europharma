package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lactare.data.MockData
import com.example.lactare.ui.theme.LactareLightBlue
import com.example.lactare.ui.theme.components.LactareButton

@Composable
fun ScheduleScreen(
    onScheduleComplete: (String, String) -> Unit
) {

    var selectedDate by remember { mutableStateOf("10/09/2026") }
    var selectedTime by remember { mutableStateOf<String?>(null) }

    val dates = listOf(
        "10/09/2026",
        "11/09/2026",
        "12/09/2026"
    )

    val selectedColor = Color(0xFFBBD7F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareLightBlue)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Agendar coleta",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00358E)
        )

        Text(
            text = "Escolha uma data",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 25.dp)
        )

        dates.forEach { date ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .clickable {
                        selectedDate = date
                    },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        if (selectedDate == date)
                            selectedColor
                        else
                            Color.White
                )
            ) {

                Text(
                    text = date,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        Text(
            text = "Escolha um horário",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 25.dp)
        )

        MockData.availableTimes.forEach { time ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable {
                        selectedTime = time
                    },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                        if (selectedTime == time)
                            selectedColor
                        else
                            Color.White
                )
            ) {

                Text(
                    text = time,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }

        LactareButton(
            text = "Confirmar agendamento",
            onClick = {
                val time = selectedTime
                if (time != null) {
                    onScheduleComplete(selectedDate, time)
                }
            },
            modifier = Modifier.padding(top = 25.dp)
        )
    }
}
