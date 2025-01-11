package com.example.teamdefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.teamdefault.navigation.NavigationScreen


import com.example.teamdefault.ui.theme.TeamDefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        enableEdgeToEdge()
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setContent {
            TeamDefaultTheme {

                NavigationScreen()

            }
        }
    }
}

