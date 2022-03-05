package com.example.facebookclone.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.facebookclone.ui.screens.home.HomeScreen
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.util.Constants
import com.example.facebookclone.util.Constants.POST_ARGUMENT_KEY



fun NavGraphBuilder.homeComposable(navigateToPostScreen: (postId: Int) -> Unit) {
    composable(
        route = Constants.HOME_SCREEN,
        arguments = listOf(navArgument(POST_ARGUMENT_KEY){
            type = NavType.StringType
        })

    ){

        MainScreen(navigateToPostScreen = navigateToPostScreen)
    }
}