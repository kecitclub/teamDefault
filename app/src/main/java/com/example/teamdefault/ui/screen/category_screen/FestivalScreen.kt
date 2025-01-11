package com.example.teamdefault.ui.screen.category_screen

import SwipeableCards
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamdefault.R

@Composable
fun FestivalScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = colorResource(id = R.color.secondary_blue)
    ) {

        SwipeableCards()


    }

}

@Preview
@Composable
private fun FestivalScreenPreview() {
    FestivalScreen()

}