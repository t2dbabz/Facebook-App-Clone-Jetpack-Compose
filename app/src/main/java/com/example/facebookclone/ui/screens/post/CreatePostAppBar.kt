package com.example.facebookclone.ui.screens.post

import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.ui.theme.postItemTextColor
import com.example.facebookclone.ui.theme.topAppBarBackgroundColor
import com.example.facebookclone.ui.theme.topAppBarContentColor
import com.example.facebookclone.util.Action


@Composable
fun CreatePostAppBar(navigateToHomeScreen:  (Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
             BackAction(onBackedClicked =  navigateToHomeScreen)
        },
        title = {
        Text(text = "Create a post", color = MaterialTheme.colors.postItemTextColor)
        },
    actions = {
        AddPostAction(onAddPostClicked = navigateToHomeScreen)
    },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}



@Composable
fun BackAction(onBackedClicked: (Action) -> Unit) {
    IconButton(modifier = Modifier.width(35.dp), onClick = { onBackedClicked(Action.N0_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}

@Composable
fun AddPostAction(onAddPostClicked: (Action) -> Unit) {
  Button(onClick = { onAddPostClicked(Action.ADD) }, colors = ButtonDefaults.buttonColors(
      backgroundColor = Color.Blue,
      contentColor = Color.White)) {
      Text(text = "Post")
  }
}


@Composable
@Preview
fun CreatePostAppBarPreview() {
    CreatePostAppBar({})
}