package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.lactare.ui.theme.components.LactareButton
import com.example.lactare.ui.theme.components.LactareCard
import com.example.lactare.ui.theme.components.SectionTitle

@Composable
fun QuizScreen(
    onQuizComplete: () -> Unit
) {

    var questionIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf<String?>(null) }

    val question = MockData.quizQuestions[questionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F0FA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(text = "Avaliação de Saúde")

        LinearProgressIndicator(
            progress = {
                (questionIndex + 1).toFloat() /
                        MockData.quizQuestions.size
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )

        Text(
            text = "Pergunta ${questionIndex + 1} de ${MockData.quizQuestions.size}",
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = question.question,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 35.dp)
        )

        question.options.forEach { option ->

            LactareCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .clickable {
                        selectedOption = option
                    },
                containerColor =
                    if (selectedOption == option)
                        Color(0xFFBBD7F5)
                    else
                        Color.White
            ) {

                Text(
                    text = option,
                    fontSize = 17.sp
                )
            }
        }

        LactareButton(
            text =
                if (questionIndex ==
                    MockData.quizQuestions.size - 1
                ) {
                    "Finalizar avaliação"
                } else {
                    "Próxima pergunta"
                },
            onClick = {

                if (selectedOption != null) {

                    if (
                        questionIndex <
                        MockData.quizQuestions.size - 1
                    ) {
                        questionIndex++
                        selectedOption = null
                    } else {
                        onQuizComplete()
                    }
                }
            },
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}