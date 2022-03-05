package com.example.facebookclone.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.facebookclone.ui.screens.home.CreatePostScreen
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.Constants
import com.example.facebookclone.util.Constants.HOME_SCREEN


fun NavGraphBuilder.postComposable(navigateToHomeScreen: (Action) -> Unit) {
    composable(
        route = Constants.POST_SCREEN,
        arguments = listOf(navArgument(Constants.POST_ARGUMENT_KEY){
            type = NavType.IntType
        })

    ){

        CreatePostScreen(navigateToHomeScreen = navigateToHomeScreen)
    }
}