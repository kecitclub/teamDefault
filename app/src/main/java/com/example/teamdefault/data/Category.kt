package com.example.teamdefault.data

import com.example.teamdefault.R

data class Category(
    val title: String,
    val noOfQuestions: String,
    val painterId: Int
)


val itemCategory = listOf(
    Category(title = "Language", noOfQuestions = "6/130 questions", painterId = R.drawable.boy),
    Category(title = "Culture", noOfQuestions = "5/90 questions", painterId = R.drawable.boy),
    Category(title = "Story", noOfQuestions = "3/80 questions", painterId = R.drawable.boy),
    Category(title = "Festival", noOfQuestions = "2/30 questions", painterId = R.drawable.boy),
    Category(title = "Language", noOfQuestions = "3/60 questions", painterId = R.drawable.boy),
    Category(title = "Culture", noOfQuestions = "6/110 questions", painterId = R.drawable.boy)
)