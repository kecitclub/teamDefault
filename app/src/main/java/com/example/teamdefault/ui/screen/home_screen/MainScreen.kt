package com.example.teamdefault.ui.screen.home_screen

import ProfileScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.teamdefault.MainViewModel
import com.example.teamdefault.R
import com.example.teamdefault.data.itemCategory
import com.example.teamdefault.navigation.Screen
import com.example.teamdefault.ui.component.BottomBar
import com.example.teamdefault.ui.component.FloatingButton
import com.example.teamdefault.ui.component.TopBar
import com.example.teamdefault.ui.screen.LLMScreen
import com.example.teamdefault.ui.screen.calender_screen.NepaliCalenderScreen
import com.example.teamdefault.ui.screen.category_screen.CategoryScreen
import com.example.teamdefault.ui.screen.category_screen.CultureScreen
import com.example.teamdefault.ui.screen.category_screen.FestivalScreen
import com.example.teamdefault.ui.screen.category_screen.FolkTalesScreen
import com.example.teamdefault.ui.screen.category_screen.LanguageScreen
import com.example.teamdefault.ui.screen.category_screen.NepaliToSpeechScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            TopBar(
                navBackStackEntry = navBackStackEntry,
                navigateBack = { navController.popBackStack() })
        },
        floatingActionButton = {
            if (navBackStackEntry?.destination?.route?.let { route ->
                    route.startsWith("Language") ||
                            route.startsWith("Culture") ||
                            route.startsWith("Folk") ||
                            route.startsWith("Festival")
                } == false) {
                FloatingButton(navController= navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            if (navBackStackEntry?.destination?.route?.let { route ->
                    route.startsWith("Language") ||
                            route.startsWith("Culture") ||
                            route.startsWith("Folk") ||
                            route.startsWith("Festival")
                } == false) {
                BottomBar(
                    navController = navController,
                    navBackStackEntry = navBackStackEntry
                )
            }
        },
        containerColor = colorResource(id = R.color.primary_purple)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {

            composable(route = Screen.Home.route) {
                HomeScreen(
                    navController = navController,
                    innerPadding = innerPadding
                )
            }

            composable(route = Screen.Category.route) {
                CategoryScreen(
                    navController = navController,
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

            composable(route = Screen.Language.route) {
                LanguageScreen(
                    modifier = Modifier.padding(innerPadding),
                    onFinish = { navController.navigate(Screen.Home.route) })
            }

            composable(route = Screen.Culture.route) {
                CultureScreen(modifier = Modifier.padding(innerPadding))
            }

            composable(route = Screen.FolkTales.route) {
                FolkTalesScreen(modifier = Modifier.padding(innerPadding))
            }

            composable(route = Screen.Festival.route) {
                FestivalScreen(modifier = Modifier.padding(innerPadding))
            }
            composable(route = Screen.LLMScreen.route) {
                val viewModel: MainViewModel = viewModel()

                LLMScreen(viewModel = viewModel, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}