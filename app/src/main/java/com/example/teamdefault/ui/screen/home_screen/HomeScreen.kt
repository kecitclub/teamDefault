package com.example.teamdefault.ui.screen.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R
import com.example.teamdefault.data.Category
import com.example.teamdefault.data.itemCategory
import com.example.teamdefault.ui.component.SampleScreen
import com.example.teamdefault.ui.component.TopProfileBar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.graphicsLayer
import com.example.teamdefault.ui.component.PopularCard
import com.example.teamdefault.ui.screen.category_screen.CategoryScreen

@Composable
fun HomeScreen(innerPadding: PaddingValues = PaddingValues(20.dp)) {
    Column(
        Modifier
            .padding(innerPadding)
    ) {
        Column() {

            PlayBoard()
            Spacer(modifier = Modifier.height(16.dp))
            WordBoard()
            Spacer(modifier = Modifier.height(16.dp))

        }
        PopularList()
    }
}



@Composable
fun PlayBoard(modifier: Modifier = Modifier) {
    Surface(
        color = Color(0x4DF1F4FF),
        shape = RoundedCornerShape(12.dp),
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.primary_purple)),
            contentAlignment = Alignment.TopCenter
            //.size(400.dp)
        )
        {

            TopProfileBar("Home")

            Image(
                painter = painterResource(id = R.drawable.monkey),
                contentDescription = null,
                //modifier = Modifier.height(200.dp)
            )
        }
    }
}

@Composable
fun WordBoard(modifier: Modifier = Modifier) {
    var isFlipped by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        label = "card_flip"
    )

    Surface(
        color = Color(0x4DF1F4FF),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .graphicsLayer {
                rotationX = rotation
                cameraDistance = 12f * density
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .graphicsLayer {
                    rotationX = if (rotation > 90f) 180f else 0f
                }
        ) {
            Text(
                text = if (rotation <= 90f) "Word of the Day: \nCat" else "बिरालो",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { isFlipped = !isFlipped },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = colorResource(id = R.color.text_purple)
                )
            ) {
                Text(
                    text = if (rotation <= 90f) "Show Nepali" else "Show English",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}



@Composable
fun PopularList(modifier: Modifier = Modifier) {
    Surface(
        color =  Color(0xFFEAF3FF)
        ,
        shape = RoundedCornerShape(topStartPercent = 16, topEndPercent = 16),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .padding(20.dp)
                .padding(top = 4.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Popular Here",
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                )
                Text(
                    text = "See All",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.text_purple)
                )
            }
            //Spacer(modifier = Modifier.height(12.dp))

            //SampleScreen()
            //CategoryScreen (navigateToStudy = {})
            PopularCard (navigateToStudy = {})
        }
    }
}






@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}