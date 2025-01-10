package com.example.teamdefault.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teamdefault.ui.screen.category_screen.CategoryScreen
import com.example.teamdefault.ui.screen.home_screen.MainScreen

@Composable
fun NavigationScreen() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route){

        composable(Screen.Main.route){
            MainScreen()
        }
    }

}

