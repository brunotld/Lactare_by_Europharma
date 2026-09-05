package com.example.lactare.navigation

sealed class Screen(val route: String) {

    object Splash : Screen("splash")

    object Welcome : Screen("welcome")

    object Register : Screen("register")

    object Quiz : Screen("quiz")

    object QuizResult : Screen("quiz_result")

    object Schedule : Screen("schedule")

    object Confirmation : Screen("confirmation")

    object Home : Screen("home")

    object History : Screen("history")

    object Impact : Screen("impact")
}