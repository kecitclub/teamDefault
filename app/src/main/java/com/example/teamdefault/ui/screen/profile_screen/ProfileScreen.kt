package com.example.teamdefault.ui.screen.profile_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8),
        color = Color(0xFFEAF3FF)
    ) {


    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview () {
    ProfileScreen()

}