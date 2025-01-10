package com.example.teamdefault

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.teamdefault.navigation.NavigationScreen
import com.example.teamdefault.ui.screen.calender_screen.NepaliCalenderScreen

import com.example.teamdefault.ui.theme.TeamDefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamDefaultTheme {

                   // TextToSpeechScreen()
                   // NepaliCalenderScreen()
                    //NepaliToSpeechScreen()
                NavigationScreen()
            }
        }
    }
}

