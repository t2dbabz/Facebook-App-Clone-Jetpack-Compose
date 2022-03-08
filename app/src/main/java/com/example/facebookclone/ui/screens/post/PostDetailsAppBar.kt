package com.example.facebookclone.ui.screens.post

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.facebookclone.ui.theme.postItemTextColor
import com.example.facebookclone.ui.theme.topAppBarBackgroundColor
import com.example.facebookclone.ui.theme.topAppBarContentColor
import com.example.facebookclone.util.Action


@Composable
fun PostDetailsAppBar(navigateToHomeScreen:  (Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackedClicked =  navigateToHomeScreen)
        },
        title = {
            Text(text = "Details", color = MaterialTheme.colors.postItemTextColor)
        },
        actions = {
            DeletePostAction(onDeleteClicked = navigateToHomeScreen)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun DeletePostAction(onDeleteClicked: (Action) -> Unit) {
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            tint = MaterialTheme.colors.topAppBarContentColor
        )

    }
}


@Composable
@Preview
fun PostDetailsAppBarPreview() {
    PostDetailsAppBar(navigateToHomeScreen = {})
}
