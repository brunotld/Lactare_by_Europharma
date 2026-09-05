package com.example.lactare.data

import com.example.lactare.model.Appointment
import com.example.lactare.model.Badge
import com.example.lactare.model.Donation
import com.example.lactare.model.QuizQuestion
import com.example.lactare.model.User

object MockData {

    // Usuários mockados
    val users = listOf(

        User(
            id = 1,
            name = "Ana Souza",
            email = "ana.souza@email.com",
            phone = "(11) 99999-9999",
            address = "Rua das Flores, 123 - São Paulo, SP",
            totalDonatedMl = 450,
            babiesHelped = 2
        ),

        User(
            id = 2,
            name = "Maria Silva",
            email = "maria@email.com",
            phone = "(11) 98888-8888",
            address = "São Paulo, SP",
            totalDonatedMl = 380,
            babiesHelped = 1
        ),

        User(
            id = 3,
            name = "Juliana Costa",
            email = "juliana@email.com",
            phone = "(11) 97777-7777",
            address = "São Paulo, SP",
            totalDonatedMl = 350,
            babiesHelped = 2
        )
    )

    // Usuária padrão do aplicativo
    val user = users.first()


    // Todas as doações do sistema
    val donations = listOf(

        // Ana - ID 1
        Donation(
            id = 1,
            userId = 1,
            date = "15/08/2026",
            time = "10:30",
            volumeMl = 450,
            status = "Concluída"
        ),

        // Maria - ID 2
        Donation(
            id = 2,
            userId = 2,
            date = "02/08/2026",
            time = "09:00",
            volumeMl = 380,
            status = "Concluída"
        ),

        // Outro usuário
        Donation(
            id = 3,
            userId = 3,
            date = "20/06/2026",
            time = "15:30",
            volumeMl = 350,
            status = "Concluída"
        )
    )


    // Próximo agendamento
    val appointment = Appointment(
        id = 1,
        date = "10/09/2026",
        time = "10:30",
        address = "Rua das Flores, 123 - São Paulo, SP",
        collectorName = "Maria Oliveira",
        status = "Agendada"
    )


    // Perguntas do Quiz de Saúde
    val quizQuestions = listOf(

        QuizQuestion(
            id = 1,
            question = "Você está amamentando atualmente?",
            options = listOf("Sim", "Não")
        ),

        QuizQuestion(
            id = 2,
            question = "Você possui disponibilidade para realizar doações regularmente?",
            options = listOf("Sim", "Não")
        ),

        QuizQuestion(
            id = 3,
            question = "Você está utilizando algum medicamento atualmente?",
            options = listOf("Não", "Sim")
        ),

        QuizQuestion(
            id = 4,
            question = "Você passou por alguma avaliação médica recentemente?",
            options = listOf("Sim", "Não")
        ),

        QuizQuestion(
            id = 5,
            question = "Você possui alguma condição de saúde que possa impedir a doação?",
            options = listOf(
                "Não",
                "Sim",
                "Não tenho certeza"
            )
        ),

        QuizQuestion(
            id = 6,
            question = "Você consome bebidas alcoólicas com frequência?",
            options = listOf(
                "Não",
                "Ocasionalmente",
                "Sim"
            )
        ),

        QuizQuestion(
            id = 7,
            question = "Você recebeu orientação sobre a coleta e armazenamento do leite?",
            options = listOf(
                "Sim",
                "Ainda não"
            )
        ),

        QuizQuestion(
            id = 8,
            question = "Você deseja continuar o processo de doação pelo Lactare?",
            options = listOf(
                "Sim, desejo continuar",
                "Quero saber mais"
            )
        )
    )


    // Medalhas
    val badges = listOf(

        Badge(
            id = 1,
            name = "Primeira Doação",
            description = "Você realizou sua primeira doação de leite.",
            icon = "milk",
            unlocked = true
        ),

        Badge(
            id = 2,
            name = "Coração Lactare",
            description = "Você ajudou 5 bebês através das suas doações.",
            icon = "heart",
            unlocked = true
        ),

        Badge(
            id = 3,
            name = "Mãe Inspiradora",
            description = "Você realizou 5 doações.",
            icon = "star",
            unlocked = true
        ),

        Badge(
            id = 4,
            name = "Heroína Lactare",
            description = "Ajude 20 bebês para conquistar esta medalha.",
            icon = "trophy",
            unlocked = false
        )
    )


    // Horários disponíveis
    val availableTimes = listOf(
        "08:00",
        "09:30",
        "10:30",
        "14:00",
        "15:30",
        "17:00"
    )


}