package com.example.teamdefault.ui.screen.home_screen

import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamdefault.R
import com.example.teamdefault.ui.component.BottomBar
import com.example.teamdefault.ui.component.FloatingButton

@Composable
fun MainScreen() {
    Scaffold(
        floatingActionButton = { FloatingButton()},
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = { BottomBar()},
        containerColor = colorResource(id = R.color.primary_purple)
    ) {
        it
    }
}
@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}