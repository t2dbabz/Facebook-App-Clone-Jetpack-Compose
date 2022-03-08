package com.example.facebookclone.ui.screens.post

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.facebookclone.data.model.Post
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Action

@Composable
fun PostDetailsScreen(
    navigateToHomeScreen: (Action) -> Unit,
    post: Post,
    sharedViewModel: SharedViewModel
) {
    
    Scaffold(
        topBar = { PostDetailsAppBar(navigateToHomeScreen = navigateToHomeScreen) },
        content = { PostDetailsContent(post) }
    )
    
}


@Composable
@Preview
fun PostDetailsScreenPreview() {

}




