package com.example.teamdefault.ui.screen.category_screen

import android.speech.tts.TextToSpeech
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R
import com.example.teamdefault.ui.component.AppIconButton
import java.util.Locale

@Composable
fun FolkTalesScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    var isPlaying by remember { mutableStateOf(false) }

    val storyText = "एक समयको कुरा हो, एक सानो गाउँमा एउटा हात्ती बस्थ्यो। " +
            "यस हात्तीको नाम थियो मुसा। मुसाले सधैँ गाउँका मानिसहरूलाई मद्दत गर्ने गर्छ।" +
            " एक दिन गाउँमा ठूलो आगो लाग्यो र सबै डरले भाग्न थाले। मुसा, जो चुपचाप रहन्थ्यो, " +
            "आफ्नो विशाल आकारको उपयोग गर्दै सबैलाई अगाडि पठाउने र आगो निभाउन प्रयास गर्दै अघि बढ्यो। अन्ततः, " +
            "मुसाले एक नदीको किनारमा पुगेर पानी ल्याएर आगो निभायो। गाउँवासीहरूले उसको साहस र " +
            "दयालुता देखेर मुसालाई 'दयालु हात्ती' भनेर सम्झना गर्न थाले। आज पनि गाउँमा दयालुता र साहसको प्रतिमूर्ति मानिन्छ मुसा।"

    // Initialize TTS engine
    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = tts?.setLanguage(Locale("ne")) // Set to Nepali
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts?.language = Locale.US // Fallback to US English
                }
            }
        }
        onDispose {
            tts?.stop()
            tts?.shutdown()
        }
    }

    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = Color(0xFFEAF3FF)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
           //Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "मुसा",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.elephant),
                contentDescription = null
            )

            Text(
                text = storyText,
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            TimerFooter(
                isPlaying = isPlaying,
                onPlayClick = {
                    isPlaying = true
                    tts?.speak(storyText, TextToSpeech.QUEUE_FLUSH, null, null)
                },
                onStopClick = {
                    isPlaying = false
                    tts?.stop()
                }
            )
        }
    }
}

@Composable
private fun TimerFooter(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    onPlayClick: () -> Unit,
    onStopClick: () -> Unit
) {
    Row(modifier = modifier.padding(bottom = 80.dp)) {
        ActionsIcons(
            icon = R.drawable.play,
            title = "",
            onClick = onPlayClick,
            enabled = !isPlaying
        )
        Spacer(Modifier.width(100.dp))
        ActionsIcons(
            icon = R.drawable.stop,
            title = "",
            onClick = onStopClick,
            enabled = isPlaying
        )
    }
}

@Composable
private fun ActionsIcons(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    title: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AppIconButton(
            icon = icon,
            modifier = Modifier
                .drawBehind {
                    drawCircle(
                        color = if (enabled) Color(0xFF6A5AE0) else Color(0xFF6A5AE0).copy(alpha = 0.5f),
                    )
                }
                .padding(8.dp),
            onClick = onClick
        )

        Spacer(Modifier.height(40.dp))

        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp
            )
        )
    }
}