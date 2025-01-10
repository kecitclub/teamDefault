package com.example.teamdefault.ui.screen.category_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.draw.clip
import androidx.compose.animation.*
import androidx.compose.ui.platform.LocalContext
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.ui.res.colorResource
import java.util.*

data class Card(
    val englishWord: String,
    val imageResId: Int,
    val nepaliWord: String,
    )

@Composable
fun LanguageScreen(
    modifier: Modifier = Modifier,
    onFinish: () -> Unit // Callback when Finish is pressed
) {
    val cards = listOf(
        Card("Cat", R.drawable.cat1, "बिरालो"),
        Card("Dog", R.drawable.dog2, "कुकुर"),
        Card("Cow", R.drawable.cow1, "गाई"),
        Card("Parrot", R.drawable.parrot1, "सुगा"),
        Card("Pigeon", R.drawable.pigeon1, "परेवा")
    )

    var currentIndex by remember { mutableStateOf(0) }
    var isCardExpanded by remember { mutableStateOf(false) } // Track expansion state globally


    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 40.dp),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = Color(0xFFEAF3FF)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(Modifier.height(24.dp))

            // Show current card
            ExpandableLanguageCard(
                modifier = Modifier.padding(16.dp),
                englishWord = cards[currentIndex].englishWord,
                imageResId = cards[currentIndex].imageResId,
                nepaliWord = cards[currentIndex].nepaliWord,
                isExpanded = isCardExpanded,
                onExpansionChange = { isExpanded ->
                    isCardExpanded = isExpanded
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Next or Finish button
            if (currentIndex < cards.size - 1) {
                NextButtonComponent(
                    modifier = Modifier.padding(horizontal = 28.dp),
                    text = "Next",
                    onClick = {
                        currentIndex++
                        isCardExpanded = false

                    }
                )
            } else {
                NextButtonComponent(
                    modifier = Modifier.padding(horizontal = 28.dp),
                    text = "Finish",
                    onClick = onFinish
                )
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableLanguageCard(
    modifier: Modifier = Modifier,
    englishWord: String,
    imageResId: Int,
    nepaliWord: String,
    isExpanded: Boolean,
    onExpansionChange: (Boolean) -> Unit // Callback to track expansion state
) {
    //var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var tts: TextToSpeech? by remember { mutableStateOf(null) }

    // Initialize TTS
    DisposableEffect(Unit) {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.language = Locale("ne") // Set Nepali language
            }
        }
        onDispose {
            tts?.shutdown()
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image Section
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(16.dp))

            // English Word
            Text(
                text = englishWord,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Reveal Button
            ElevatedButton(
                onClick = {
                    val newState = !isExpanded
                    onExpansionChange(newState)
                    if (newState) {
                        // Speak Nepali word when showing translation
                        tts?.speak(nepaliWord, TextToSpeech.QUEUE_FLUSH, null, null)
                    }
                },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = colorResource(id = R.color.primary_purple)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = if (isExpanded) "Hide Nepali" else "Show Nepali",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }

            // Animated Nepali Translation
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedButton(
                        onClick = {
                            tts?.speak(nepaliWord, TextToSpeech.QUEUE_FLUSH, null, null)
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(64.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_purple)),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(width = 1.dp, color = Color(0xFF83BCFF))
                    ) {
                        Text(
                            text = nepaliWord,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NextButtonComponent(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.primary_purple)),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xFF83BCFF))
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageScreenPreview() {
    LanguageScreen(onFinish = {})
}

