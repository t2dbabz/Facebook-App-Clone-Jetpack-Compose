package com.example.facebookclone.ui.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CreatePostScreen() {
    Scaffold(
        topBar = {
        CreatePostAppBar()
        },
        content = {
            CreatePostContent()
        }
    )
}


@Composable
@Preview
fun CreatePostScreenPreview() {
    CreatePostScreen()
}