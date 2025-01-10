package com.example.teamdefault.ui.screen.category_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R

@Composable
fun FolkTalesScreen() {

    Surface(
        modifier = Modifier
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

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "A Hunter and the Ghost ",
                color = Color.Black,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.hunter_tale),
                contentDescription = null
            )

            Text(
                text = "Once upon a time, there was a hunter who lived in a village. He was very brave and skilled in hunting. " +
                        "He used to go to the forest every day to hunt animals. One day, while he was hunting, he saw a ghost. " +
                        "The ghost was very scary and had a big mouth. The hunter was very scared and ran away from the ghost. " +
                        "The ghost followed him and said, “I will eat you up!” The hunter was very scared and ran as fast as he could. " +
                        "He ran and ran until he reached a river.",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify,
                lineHeight = 24.sp
            )


        }

    }

}


@Preview
@Composable
private fun StoryScreenPreview() {

    FolkTalesScreen()
}