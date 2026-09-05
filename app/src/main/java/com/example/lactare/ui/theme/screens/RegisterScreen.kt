package com.example.lactare.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
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
import com.example.lactare.model.User
import com.example.lactare.ui.theme.components.LactareButton
import com.example.lactare.ui.theme.components.SectionTitle

@Composable
fun RegisterScreen(
    onRegisterComplete: (User) -> Unit
) {

    var step by remember {
        mutableIntStateOf(1)
    }

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var address by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F2))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(text = "Cadastro")

        Text(
            text = "Etapa $step de 3",
            modifier = Modifier.padding(top = 8.dp)
        )

        when (step) {

            1 -> {

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = {
                        Text("Nome completo")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text("E-mail")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )
            }

            2 -> {

                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
                    },
                    label = {
                        Text("Telefone")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                )

                OutlinedTextField(
                    value = address,
                    onValueChange = {
                        address = it
                    },
                    label = {
                        Text("Endereço")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                )
            }

            3 -> {

                Text(
                    text = "Quase pronto!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 30.dp)
                )

                Text(
                    text = "Agora você realizará uma rápida avaliação de saúde para continuar o processo de doação.",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }

        LactareButton(
            text = if (step < 3) {
                "Continuar"
            } else {
                "Iniciar avaliação"
            },

            enabled = when (step) {
                1 -> name.isNotBlank() && email.isNotBlank()
                2 -> phone.isNotBlank() && address.isNotBlank()
                else -> true
            },

            onClick = {

                if (step < 3) {

                    step++

                } else {

                    // Cria o usuário que acabou de se cadastrar, com id único
                    // (evita colidir com os ids mockados em MockData.users)
                    val newUser = User(
                        id = MockData.users.maxOf { it.id } + 1,
                        name = name,
                        email = email,
                        phone = phone,
                        address = address,
                        totalDonatedMl = 0,
                        babiesHelped = 0
                    )

                    onRegisterComplete(newUser)
                }
            },

            modifier = Modifier.padding(top = 30.dp)
        )
    }
}