package com.example.teamdefault

import TextToSpeechScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.teamdefault.ui.screen.NepaliCalenderScreen

import com.example.teamdefault.ui.screen.NepaliToSpeechScreen
import com.example.teamdefault.ui.theme.TeamDefaultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamDefaultTheme {

                   // TextToSpeechScreen()
                NepaliCalenderScreen()
                    //NepaliToSpeechScreen()
            }
        }
    }
}

