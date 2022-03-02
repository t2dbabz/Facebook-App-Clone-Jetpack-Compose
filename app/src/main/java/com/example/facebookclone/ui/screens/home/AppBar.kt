package com.example.facebookclone.ui.screens.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AppBar() {
    TopAppBar(
        title = {
        Text(text = "facebook", color = Color.Blue)
    },
        actions = {

        },
    backgroundColor = Color.White,

    )
}

@Composable
fun AppBarActions() {

}


@Composable
fun SearchAction() {
    IconButton(onClick = { /*TODO*/ }) {


    }
}



@Composable
@Preview
fun AppBarPreview() {
    AppBar()
}