package com.example.facebookclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.facebookclone.navigation.destinations.homeComposable
import com.example.facebookclone.navigation.destinations.postComposable
import com.example.facebookclone.util.Constants.HOME_SCREEN


@Composable
fun SetupNavigation(navController: NavHostController) {
    val screen = remember(navController) {
        Screens(navController)
    }


    NavHost(navController = navController, startDestination = HOME_SCREEN ) {
        homeComposable(navigateToPostScreen = screen.post)
        postComposable(navigateToHomeScreen = screen.mainscreen)

    }
}