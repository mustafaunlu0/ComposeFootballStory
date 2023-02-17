package com.mustafaunlu.composefootballstory


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Activity(
    val title : String,
    @DrawableRes val icon : Int,
    val lightColor: Color,
    val mediumColor : Color,
    val darkColor : Color
)