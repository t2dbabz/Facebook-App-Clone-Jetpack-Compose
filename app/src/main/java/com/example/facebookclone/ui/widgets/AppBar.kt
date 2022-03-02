package com.example.facebookclone.ui.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.facebookclone.R


@Composable
fun AppBar() {
    TopAppBar(
        title = {
        Text(text = "facebook", color = Color.Blue)
    },
        actions = {
                  AppBarActions()
        },
    backgroundColor = Color.White,

    )
}

@Composable
fun AppBarActions() {
    SearchAction({})
    MessengerAction ({})

}


@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = { onSearchClicked}) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon" )
    }
}

@Composable
fun MessengerAction(onMessengerClicked: () -> Unit) {
    IconButton(onClick = { onMessengerClicked }) {
        Icon(painter = painterResource(id = R.drawable.ic_messenger_fill) , contentDescription ="Messenger" )

    }
}



@Composable
@Preview
fun AppBarPreview() {
    AppBar()
}