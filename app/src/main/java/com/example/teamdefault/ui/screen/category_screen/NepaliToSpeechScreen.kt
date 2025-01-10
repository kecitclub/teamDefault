package com.example.teamdefault.ui.screen.category_screen

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.teamdefault.ui.component.QuestionComponent
import java.util.Locale

@Composable
fun NepaliToSpeechScreen(modifier: Modifier  = Modifier) {
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    val text = "नमस्ते, तपाईंलाई कस्तो छ?" // Predefined Nepali text

    // Initialize TTS engine
    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale("ne")) // Set to Nepali
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    // Handle the case where Nepali is not supported
                    tts?.language = Locale.US // Fallback to US English
                }
            }
        }
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEAF3FF))
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Center
    ) {

        QuestionComponent(
            text = text,
            onClick = { tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null) }
        )
    }
}