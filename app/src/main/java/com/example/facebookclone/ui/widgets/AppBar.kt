package com.example.facebookclone.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebookclone.R
import com.example.facebookclone.ui.theme.iconBackground
import com.example.facebookclone.ui.theme.logoBlue
import com.example.facebookclone.ui.theme.topAppBarBackgroundColor
import com.example.facebookclone.ui.theme.topAppBarContentColor


@Composable
fun AppBar() {
    TopAppBar(
        title = {
        Text(text = "facebook", color = MaterialTheme.colors.logoBlue, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
    },
        actions = {
                  AppBarActions()
        },
    backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,

    )
}

@Composable
fun AppBarActions() {
    SearchAction({})
    Spacer(modifier = Modifier.width(10.dp))
    MessengerAction ({})

}


@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(
        onClick = { onSearchClicked},
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.iconBackground)
            .size(40.dp)) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = MaterialTheme.colors.topAppBarContentColor )
    }
}

@Composable
fun MessengerAction(onMessengerClicked: () -> Unit) {
    IconButton(
        onClick = { onMessengerClicked },
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.iconBackground)
            .size(40.dp)
        ) {
        Icon(painter = painterResource(id = R.drawable.ic_messenger_fill) , contentDescription ="Messenger", tint = MaterialTheme.colors.topAppBarContentColor )
    }
}



@Composable
@Preview
fun AppBarPreview() {
    AppBar()
}