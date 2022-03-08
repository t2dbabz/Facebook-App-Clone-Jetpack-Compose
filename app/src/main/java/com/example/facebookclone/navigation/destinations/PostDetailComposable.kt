package com.example.facebookclone.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.facebookclone.ui.screens.post.PostDetailsScreen
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.Constants

fun NavGraphBuilder.postDetailScreen(navigateToHomeScreen: (Action) -> Unit, sharedViewModel: SharedViewModel) {
    composable(
        route = Constants.POST_DETAIL_SCREEN,
        arguments = listOf(navArgument(Constants.POST_ARGUMENT_KEY){
            type = NavType.IntType
        })

    ) {navBackStackEntry ->

        val postId = navBackStackEntry.arguments!!.getInt(Constants.POST_ARGUMENT_KEY)
        sharedViewModel.getSelectedPost(postId)
        val selectedPost by sharedViewModel.selectedPost.collectAsState()
        LaunchedEffect(key1 = selectedPost, block = {
            sharedViewModel.updatePostFields(selectedPost)
        })


        selectedPost?.let { PostDetailsScreen(navigateToHomeScreen = navigateToHomeScreen , post = it, sharedViewModel = sharedViewModel) }
    }

}