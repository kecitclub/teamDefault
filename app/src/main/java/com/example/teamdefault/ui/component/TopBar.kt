package com.example.teamdefault.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.teamdefault.R
import com.example.teamdefault.utils.DateConverter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopProfileBar(title: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier.padding(top = 16.dp),
        title = {
            Column {
                Text(
                    text = DateConverter(System.currentTimeMillis()),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFFFD6DD)
                )
                Text(
                    text = "John Doe",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }
        },
        actions = {
            Surface(
                color = Color(0xFFFFB9A7),
                modifier = Modifier
                    .width(100.dp)
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(20)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.boy),
                    contentDescription = "profile",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(top = 10.dp)
                )
            }
        }
    )
}