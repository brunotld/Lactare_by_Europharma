package com.example.lactare.ui.theme.screens

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.lactare.ui.theme.LactareBlue
import com.example.lactare.ui.theme.LactarePink
import com.example.lactare.ui.theme.components.CheckMarkIcon
import com.example.lactare.ui.theme.components.HeartIcon
import com.example.lactare.ui.theme.components.IconBadge
import com.example.lactare.ui.theme.components.LockIcon
import com.example.lactare.ui.theme.components.TrophyIcon

@Composable
fun ImpactScreen(
    user: User
) {

    val completedDonationsCount = MockData.donations.count { it.userId == user.id }

    val badgeUnlocked: (Int) -> Boolean = { badgeId ->
        when (badgeId) {
            1 -> user.totalDonatedMl > 0
            2 -> user.babiesHelped >= 5
            3 -> completedDonationsCount >= 5
            4 -> user.babiesHelped >= 20
            else -> false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LactarePink)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Seu Impacto",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = LactareBlue
            )
            Spacer(modifier = Modifier.width(10.dp))
            HeartIcon(iconSize = 26.dp, color = LactareBlue)
        }

        Text(
            text = "${user.babiesHelped} bebês ajudados",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "${user.totalDonatedMl / 1000.0} litros doados até agora",
            modifier = Modifier.padding(top = 6.dp)
        )

        Text(
            text = "Cada coração representa uma vida impactada pelas suas doações.",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp)
        )

        if (user.babiesHelped > 0) {

            Row(modifier = Modifier.padding(top = 20.dp)) {
                repeat(user.babiesHelped.coerceAtMost(12)) {
                    HeartIcon(iconSize = 26.dp, color = LactareBlue)
                    Spacer(modifier = Modifier.width(6.dp))
                }
            }
        } else {

            Text(
                text = "Assim que suas doações forem concluídas, os corações aparecem aqui.",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TrophyIcon(iconSize = 24.dp, color = LactareBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Suas medalhas",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier.padding(top = 15.dp)
        ) {

            items(MockData.badges) { badge ->

                val unlocked = badgeUnlocked(badge.id)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =
                            if (unlocked)
                                Color.White
                            else
                                Color.LightGray
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconBadge(
                                backgroundColor = if (unlocked) LactareBlue else Color.Gray,
                                diameter = 32.dp
                            ) {
                                TrophyIcon(iconSize = 16.dp, color = Color.White)
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = badge.name,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = badge.description,
                            modifier = Modifier.padding(top = 5.dp)
                        )

                        Row(
                            modifier = Modifier.padding(top = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (unlocked) {
                                CheckMarkIcon(iconSize = 16.dp, color = Color(0xFF3FA35A))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(text = "Conquistada")
                            } else {
                                LockIcon(iconSize = 16.dp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(text = "Bloqueada")
                            }
                        }
                    }
                }
            }
        }
    }
}
