package com.example.teamdefault.data

import com.example.teamdefault.R

data class Category(
    val title: String,
    val noOfQuestions: String,
    val painterId: Int
)


val itemCategory = listOf(
    Category(title = "Language", noOfQuestions = "", painterId = R.drawable.lang),
    Category(title = "Culture", noOfQuestions = "", painterId = R.drawable.culture),
    Category(title = "Folk Tales", noOfQuestions = "", painterId = R.drawable.folk_tales),
    Category(title = "Festival", noOfQuestions = "", painterId = R.drawable.festive),
)