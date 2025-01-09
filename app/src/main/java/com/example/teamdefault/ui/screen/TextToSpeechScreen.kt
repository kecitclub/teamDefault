import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun TextToSpeechScreen() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    var isSpeaking by remember { mutableStateOf(false) }

    // Initialize TTS engine
    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale.US
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
            .padding(top = 40.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text to speak") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 5
        )

            Button(
                onClick = {
                    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
                    isSpeaking = true
                },
                enabled = text.isNotEmpty() && !isSpeaking,
            ) {
                Text("Speak")
            }
    }
}


@Preview(showBackground = true)
@Composable
private fun TextToSpeechPreview () {

    TextToSpeechScreen()

}