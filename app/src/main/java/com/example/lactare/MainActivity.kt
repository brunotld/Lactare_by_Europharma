package com.example.lactare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lactare.navigation.AppNavigation
import com.example.lactare.ui.theme.LactareTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LactareTheme {
                AppNavigation()
            }
        }
    }
}