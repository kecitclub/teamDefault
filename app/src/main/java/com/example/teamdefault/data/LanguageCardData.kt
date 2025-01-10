package com.example.teamdefault.data

import com.example.teamdefault.R

data class LanguageCard(
    val englishWord: String,
    val imageResId: Int,
    val nepaliWord: String,
)

val cards = listOf(
    LanguageCard("Cat", R.drawable.cat1, "बिरालो"),
    LanguageCard("Dog", R.drawable.dog2, "कुकुर"),
    LanguageCard("Cow", R.drawable.cow1, "गाई"),
    LanguageCard("Parrot", R.drawable.parrot1, "सुगा"),
    LanguageCard("Pigeon", R.drawable.pigeon1, "परेवा")
)