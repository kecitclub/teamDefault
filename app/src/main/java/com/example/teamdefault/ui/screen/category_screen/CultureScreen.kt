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
fun CultureScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }
    var isPlaying by remember { mutableStateOf(false) }

    val storyText = "नेवारी संस्कृती नेपालका नेवार समुदायको पहिचान हो, जसले भाषा, कला, रीतिरिवाज र परम्परालाई समेट्छ। नेवारहरूको सांगीतिक परम्परा, जात्राहरू, र चाडपर्वहरू अत्यन्तै रंगीन र भव्य हुन्छन्। इन्द्रजात्रा, मत्स्येन्द्रनाथ जात्रा, र गुंला पर्वजस्ता चाडपर्वहरूमा नेवारहरूको सांस्कृतिक धरोहर झल्किन्छ। परम्परागत खाना, जस्तै योमरी, जुझु धौ (दही), र बाराको स्वाद अनौठो छ। मन्दिरहरूको निर्माण, मूर्तिकला, र पाटन तथा भक्तपुरजस्ता सहरहरूमा प्राचीन वास्तुकलाको प्रभावले नेवारी संस्कृतिलाई विशेष बनाएको छ।"

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
                text = "नेवारी संस्कृती",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.newari_culture),
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