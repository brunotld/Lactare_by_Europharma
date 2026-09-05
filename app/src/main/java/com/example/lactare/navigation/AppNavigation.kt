package com.example.lactare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.lactare.data.MockData
import com.example.lactare.model.Appointment
import com.example.lactare.model.User

import com.example.lactare.ui.theme.screens.ConfirmationScreen
import com.example.lactare.ui.theme.screens.HistoryScreen
import com.example.lactare.ui.theme.screens.HomeScreen
import com.example.lactare.ui.theme.screens.ImpactScreen
import com.example.lactare.ui.theme.screens.QuizResultScreen
import com.example.lactare.ui.theme.screens.QuizScreen
import com.example.lactare.ui.theme.screens.RegisterScreen
import com.example.lactare.ui.theme.screens.ScheduleScreen
import com.example.lactare.ui.theme.screens.SplashScreen
import com.example.lactare.ui.theme.screens.WelcomeScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    var currentUser by remember {
        mutableStateOf<User?>(null)
    }

    var currentAppointment by remember {
        mutableStateOf<Appointment?>(null)
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {

            SplashScreen(
                onNavigateToWelcome = {

                    navController.navigate(
                        Screen.Welcome.route
                    )
                }
            )
        }


        composable(Screen.Welcome.route) {

            WelcomeScreen(
                onStartRegister = {

                    navController.navigate(
                        Screen.Register.route
                    )
                }
            )
        }


        composable(Screen.Register.route) {

            RegisterScreen(
                onRegisterComplete = { user ->

                    currentUser = user

                    navController.navigate(
                        Screen.Quiz.route
                    )
                }
            )
        }


        composable(Screen.Quiz.route) {

            QuizScreen(
                onQuizComplete = {

                    navController.navigate(
                        Screen.QuizResult.route
                    )
                }
            )
        }


        composable(Screen.QuizResult.route) {

            QuizResultScreen(
                onScheduleClick = {

                    navController.navigate(
                        Screen.Schedule.route
                    )
                }
            )
        }


        composable(Screen.Schedule.route) {

            ScheduleScreen(
                onScheduleComplete = { date, time ->

                    val userAddress = currentUser?.address?.takeIf { it.isNotBlank() }

                    currentAppointment = Appointment(
                        id = MockData.appointment.id,
                        date = date,
                        time = time,
                        address = userAddress ?: MockData.appointment.address,
                        collectorName = MockData.appointment.collectorName,
                        status = "Agendada"
                    )

                    navController.navigate(
                        Screen.Confirmation.route
                    )
                }
            )
        }


        composable(Screen.Confirmation.route) {

            ConfirmationScreen(
                appointment = currentAppointment ?: MockData.appointment,
                onGoHome = {

                    navController.navigate(
                        Screen.Home.route
                    )
                }
            )
        }


        composable(Screen.Home.route) {

            HomeScreen(
                user = currentUser ?: MockData.user,
                appointment = currentAppointment ?: MockData.appointment,

                onHistoryClick = {

                    navController.navigate(
                        Screen.History.route
                    )
                },

                onImpactClick = {

                    navController.navigate(
                        Screen.Impact.route
                    )
                }
            )
        }


        composable(Screen.History.route) {

            currentUser?.let { user ->

                HistoryScreen(
                    currentUser = user
                )
            }
        }


        composable(Screen.Impact.route) {

            ImpactScreen(
                user = currentUser ?: MockData.user
            )
        }
    }
}
