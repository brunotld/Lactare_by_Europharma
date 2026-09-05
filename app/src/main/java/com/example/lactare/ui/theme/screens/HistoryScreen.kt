package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.lactare.data.MockData
import com.example.lactare.model.User
import com.example.lactare.ui.theme.LactareBeige
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.components.CalendarIcon
import com.example.lactare.ui.theme.components.DropIcon
import com.example.lactare.ui.theme.components.IconBadge
import com.example.lactare.ui.theme.components.LactareCard
import com.example.lactare.ui.theme.components.SectionTitle

@Composable
fun HistoryScreen(
    currentUser: User
) {

    val userDonations = MockData.donations.filter { donation ->
        donation.userId == currentUser.id
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactareBeige)
            .padding(20.dp)
    ) {

        SectionTitle(text = "Minhas Doações")

        Text(
            text = "Histórico das suas doações",
            modifier = Modifier.padding(top = 8.dp)
        )

        if (userDonations.isEmpty()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                contentAlignment = Alignment.Center
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    IconBadge(backgroundColor = Color.White, diameter = 72.dp) {
                        DropIcon(iconSize = 32.dp, color = LactareBlue)
                    }

                    Text(
                        text = "Você ainda não tem doações concluídas.",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 16.dp)
                    )

                    Text(
                        text = "Assim que sua primeira coleta for concluída, ela aparece aqui.",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 6.dp)
                    )
                }
            }
        } else {

            LazyColumn(
                modifier = Modifier.padding(top = 20.dp)
            ) {

                items(userDonations) { donation ->

                    LactareCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            DropIcon(iconSize = 20.dp, color = LactareBlue)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "${donation.volumeMl} ml",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CalendarIcon(iconSize = 18.dp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "${donation.date} às ${donation.time}")
                        }

                        Text(
                            text = "Status: ${donation.status}",
                            modifier = Modifier.padding(top = 6.dp)
                        )
                    }
                }
            }
        }
    }
}
