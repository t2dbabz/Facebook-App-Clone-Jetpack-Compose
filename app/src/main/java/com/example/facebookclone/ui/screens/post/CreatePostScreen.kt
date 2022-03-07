package com.example.facebookclone.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.facebookclone.ui.screens.post.CreatePostAppBar
import com.example.facebookclone.ui.screens.post.CreatePostContent
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Action


@Composable
fun CreatePostScreen(
    navigateToHomeScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel,
) {
    val status: String by sharedViewModel.status

    Scaffold(
        topBar = {
        CreatePostAppBar(navigateToHomeScreen = navigateToHomeScreen)
        },
        content = {
            CreatePostContent(status = status, onStatusChanged = { sharedViewModel.status.value = it})
        }
    )
}


@Composable
@Preview
fun CreatePostScreenPreview() {
   // CreatePostScreen({})
}