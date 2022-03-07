package com.example.facebookclone.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.facebookclone.ui.screens.home.CreatePostScreen
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.Constants
import com.example.facebookclone.util.Constants.HOME_SCREEN
import com.example.facebookclone.util.Constants.POST_ARGUMENT_KEY


fun NavGraphBuilder.postComposable(navigateToHomeScreen: (Action) -> Unit, sharedViewModel: SharedViewModel) {
    composable(
        route = Constants.POST_SCREEN,
        arguments = listOf(navArgument(Constants.POST_ARGUMENT_KEY){
            type = NavType.IntType
        })

    ){navBackStackEntry ->

        val postId = navBackStackEntry.arguments!!.getInt(POST_ARGUMENT_KEY)
        sharedViewModel.getSelectedPost(postId)
        val selectedPost by sharedViewModel.selectedPost.collectAsState()
        LaunchedEffect(key1 = selectedPost, block = {
            sharedViewModel.updatePostFields(selectedPost)
        })
        CreatePostScreen(navigateToHomeScreen = navigateToHomeScreen, sharedViewModel = sharedViewModel)
    }
}