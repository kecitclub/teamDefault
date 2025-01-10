package com.example.teamdefault.navigation

sealed class Screen(val route: String) {
    // root screen
    data object Main : Screen("Main")
    data object OnBoarding : Screen("OnBoarding")
    data object Welcome : Screen("Welcome")
    data object Login : Screen("Login")
    data object Register : Screen("Register")

    // main screen
    data object Home : Screen("Home")
    data object Category : Screen("Category")
    data object Calender : Screen("Calender")
    data object Profile : Screen("Profile")
    data object History : Screen("History")
    data object List : Screen("List")

    //category screens
    data object Culture : Screen("Culture")
    data object Festival : Screen("Festival")
    data object Language : Screen("Language")
    data object FolkTales: Screen("FolkTales")
}