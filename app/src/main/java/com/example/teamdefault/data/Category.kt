package com.example.teamdefault.data

import com.example.teamdefault.R

data class Category(
    val title: String,
    val noOfQuestions: String,
    val painterId: Int
)


val itemCategory = listOf(
    Category(title = "सवारी सञ्चालन", noOfQuestions = "6/130 questions", painterId = R.drawable.language),
    Category(title = "सवारी कानुन", noOfQuestions = "5/90 questions", painterId = R.drawable.story),
)