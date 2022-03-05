package com.example.facebookclone.ui.screens.home

import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.util.Action


@Composable
fun CreatePostAppBar() {
    TopAppBar(
        navigationIcon = {
             BackAction(onBackedClicked = {})
        },
        title = {
        Text(text = "Create a post")
        },
    actions = {
        AddPostAction(onBackedClicked = {})
    },
        backgroundColor = Color.White
    )
}



@Composable
fun BackAction(onBackedClicked: (Action) -> Unit) {
    IconButton(modifier = Modifier.width(35.dp), onClick = { onBackedClicked(Action.N0_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back Icon",
            tint = Color.Black
        )

    }
}

@Composable
fun AddPostAction(onBackedClicked: (Action) -> Unit) {
  Button(onClick = { onBackedClicked(Action.ADD) }, colors = ButtonDefaults.buttonColors(
      backgroundColor = Color.Blue,
      contentColor = Color.White)) {
      Text(text = "Post")
  }
}


@Composable
@Preview
fun CreatePostAppBarPreview() {
    CreatePostAppBar()
}