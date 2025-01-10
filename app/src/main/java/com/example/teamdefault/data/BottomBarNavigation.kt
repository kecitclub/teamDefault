package com.example.teamdefault.data

import com.example.teamdefault.R
import com.example.teamdefault.navigation.Screen

data class BottomBarNavigationItem(
    val title: String,
    val icon: Int
)
val itemNavigation = listOf(
    BottomBarNavigationItem(title = Screen.Home.route, icon = R.drawable.home),
    BottomBarNavigationItem(title = Screen.Category.route, icon = R.drawable.categories),
    BottomBarNavigationItem(title = "WhiteSpace", icon = R.drawable.rocket),
    BottomBarNavigationItem(title = Screen.Calender.route, icon = R.drawable.history),
    BottomBarNavigationItem(title = Screen.Profile.route, icon = R.drawable.profile)
)