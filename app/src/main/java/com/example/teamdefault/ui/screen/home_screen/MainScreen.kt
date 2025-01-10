package com.example.teamdefault.ui.screen.home_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.teamdefault.R
import com.example.teamdefault.navigation.Screen
import com.example.teamdefault.ui.component.BottomBar
import com.example.teamdefault.ui.component.FloatingButton
import com.example.teamdefault.ui.component.TopBar
import com.example.teamdefault.ui.screen.calender_screen.NepaliCalenderScreen
import com.example.teamdefault.ui.screen.category_screen.CategoryScreen
import com.example.teamdefault.ui.screen.profile_screen.ProfileScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = { TopBar(
            navBackStackEntry = navBackStackEntry,
            navigateBack = { navController.popBackStack() }) },
        floatingActionButton = { FloatingButton() },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomBar(
                navController = navController,
                navBackStackEntry = navBackStackEntry
            )
        },
        containerColor = colorResource(id = R.color.primary_purple)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {

            composable(route = Screen.Home.route) {
                HomeScreen(innerPadding = innerPadding)
            }

            composable(route = Screen.Category.route) {
                CategoryScreen(
                    navigateToStudy = {},
                    modifier = Modifier.padding(innerPadding),
                )
            }

            composable(route = Screen.Calender.route) {
                NepaliCalenderScreen(modifier = Modifier.padding(innerPadding))
            }

            composable(route = Screen.Profile.route) {
                ProfileScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}