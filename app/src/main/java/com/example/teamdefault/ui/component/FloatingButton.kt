package com.example.teamdefault.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.teamdefault.R
import com.example.teamdefault.navigation.Screen

@Composable
fun FloatingButton(navController: NavController,modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = { navController.navigate(Screen.LLMScreen.route) },
        shape = CircleShape,
        containerColor = colorResource(id = R.color.primary_purple),
        contentColor = colorResource(id = R.color.white),
        modifier = Modifier
            .offset(y = 60.dp)
            .size(80.dp)
            .border(
                width = 4.dp,
                color = colorResource(id = R.color.secondary_blue),
                shape = CircleShape
            ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )
    }
}
@Preview
@Composable
private fun FloatingButtonPreview() {
    //FloatingButton()
}