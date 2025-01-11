import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.teamdefault.R


@Composable
fun SwipeCard(
    onSwipeLeft: () -> Unit = {},
    onSwipeRight: () -> Unit = {},
    swipeThreshold: Float = 400f,
    sensitivityFactor: Float = 3f,
    content: @Composable () -> Unit
) {
    // Implementation goes here
    var offset by remember { mutableStateOf(0f) }
    var dismissRight by remember { mutableStateOf(false) }
    var dismissLeft by remember { mutableStateOf(false) }
    val density = LocalDensity.current.density

    LaunchedEffect(dismissRight) {
        if (dismissRight) {
            delay(300)
            onSwipeRight.invoke()
            dismissRight = false
        }
    }

    LaunchedEffect(dismissLeft) {
        if (dismissLeft) {
            delay(300)
            onSwipeLeft.invoke()
            dismissLeft = false
        }
    }

    Box(modifier = Modifier
        .offset { IntOffset(offset.roundToInt(), 0) }
        .pointerInput(Unit) {
            detectHorizontalDragGestures(onDragEnd = {
                offset = 0f
            }) { change, dragAmount ->

                offset += (dragAmount / density) * sensitivityFactor
                when {
                    offset > swipeThreshold -> {
                        dismissRight = true
                    }

                    offset < -swipeThreshold -> {
                        dismissLeft = true
                    }
                }
                if (change.positionChange() != Offset.Zero) change.consume()
            }
        }
        .graphicsLayer(
            alpha = 10f - animateFloatAsState(if (dismissRight) 1f else 0f).value,
            rotationZ = animateFloatAsState(offset / 50).value
        )) {
        content()
    }
}

data class CardItem(
    val id: Int,
    val imageRes: Int,
    val title: String
)

@Composable
fun SwipeableCards() {
    // Sample card data - replace R.drawable.xxx with your actual image resources
    val cards = remember {
        listOf(
            CardItem(1, R.drawable.dashain, "दशैं हिन्दूहरूको सबैभन्दा ठूलो चाड हो, जहाँ दुर्गा माताको पूजा र टिका लगाउने प्रथा गरिन्छ। यसले परिवारमा एकता र शुभकामना सन्देश दिन्छ।\n" +
                    "\n"),
            CardItem(2, R.drawable.tihar,  "तिहार दियो बाल्ने र देउसीभैलो खेल्ने पर्व हो, जहाँ काग, कुकुर, गाई, गोरु र दाजुभाइको पूजा गरिन्छ। यसले प्रकृति, जनावर र मानवीय सम्बन्धको सम्मान प्रकट गर्छ।"),
            CardItem(3, R.drawable.holi, "होली रंगहरूको पर्व हो, जसमा मानिसहरू एकअर्कामाथि रंग लगाएर हर्षोल्लासका साथ मनाउँछन्। यसले आपसी प्रेम र मित्रताको प्रतीक मानिन्छ।\n" +
                    "\n"),
            CardItem(4, R.drawable.gaijatra, "गाईजात्रा मृत आत्माको सम्झनामा मनाइने पर्व हो, जसमा गाईको प्रतीक प्रदर्शन गरिन्छ। यसले शोकलाई हाँसो र व्यंग्यमा बदल्ने परम्परालाई जोड दिन्छ।\n"),

            CardItem(5, R.drawable.gaura, "गौरा पर्व विशेषतः सुदूरपश्चिम नेपालमा मनाइन्छ, जहाँ महिलाहरू शिव–पार्वतीको पूजा गर्छन्। यस चाडले वैवाहिक सुख र समृद्धिको कामना गरिन्छ।\n" +
                    "\n")
        )
    }

    var currentIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        if (currentIndex >= cards.size) {
            Card(
                modifier = Modifier
                    .size(width = 300.dp, height = 400.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No more cards!")
                }
            }
        } else {
            // Show current and next card (if available)
            cards.asReversed().forEachIndexed { index, card ->
                val reverseIndex = cards.size - 1 - index
                if (reverseIndex >= currentIndex && reverseIndex <= currentIndex + 1) {
                    val isCurrentCard = reverseIndex == currentIndex

                    SwipeCard(
                        onSwipeLeft = {
                            if (isCurrentCard) currentIndex++
                        },
                        onSwipeRight = {
                            if (isCurrentCard) currentIndex++
                        },
                        swipeThreshold = 400f,
                        sensitivityFactor = 3f
                    ) {
                        Card(
                            modifier = Modifier
                                .size(width = 300.dp, height = 400.dp)
                                .zIndex(if (isCurrentCard) 1f else 0f),
                            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = card.imageRes),
                                    contentDescription = card.title,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                // Optional: Add a title or description
                                Text(
                                    text = card.title,
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .padding(16.dp),
                                    color = colorResource(id = R.color.white),
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun SwipeCardsPreview() {
    SwipeableCards()
    
}