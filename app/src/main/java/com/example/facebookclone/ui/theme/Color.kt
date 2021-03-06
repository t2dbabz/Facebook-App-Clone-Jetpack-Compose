package com.example.facebookclone.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val DarkBlue = Color(0xFF0E74EE)
val RichBlack = Color(0xFF151515)
val Grey = Color(0xFF909090)
val LightGrey = Color(0xFFF2F1F7)
val MediaGreen = Color(0xFF3EC260)
val TextGrey = Color(0xFF818181)
val IconGrey = Color(0xFF565656)



val Colors.postItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray


val Colors.postItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.Black else Color.LightGray

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else Color.Black

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700

val Colors.mediaGreen: Color
    @Composable
    get() = MediaGreen

val Colors.iconBackground: Color
    @Composable
    get() = LightGrey

val Colors.logoBlue: Color
    @Composable
    get() = DarkBlue

val Colors.textGrey: Color
    @Composable
    get() = if (isLight) TextGrey else LightGray


val Colors.iconGrey: Color
    @Composable
    get() = if (isLight) IconGrey else LightGray



