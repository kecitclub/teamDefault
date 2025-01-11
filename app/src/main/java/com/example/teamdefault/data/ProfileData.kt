package com.example.teamdefault.data

import com.example.teamdefault.R

data class Profile(
    val name: String = "Guest",
    val avatar: Int = 0,
    val background: Int = 0
)
val avatarProfile = mapOf(
    0 to R.drawable.boy_1,

)
val backgroundProfile = mapOf(
    0 to R.color.skin_background,

)