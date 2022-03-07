package com.example.facebookclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.facebookclone.navigation.destinations.homeComposable
import com.example.facebookclone.navigation.destinations.mainScreenComposable
import com.example.facebookclone.navigation.destinations.postComposable
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Constants.HOME_SCREEN
import com.example.facebookclone.util.Constants.MAIN_SCREEN


@Composable
fun SetupNavigation(navController: NavHostController, sharedViewModel: SharedViewModel) {
    val screen = remember(navController) {
        Screens(navController)
    }


    NavHost(navController = navController, startDestination = MAIN_SCREEN ) {
        mainScreenComposable(navigateToPostScreen = screen.post, sharedViewModel = sharedViewModel)
        homeComposable(navigateToPostScreen = screen.post, sharedViewModel = sharedViewModel)
        postComposable(navigateToHomeScreen = screen.home, sharedViewModel = sharedViewModel)

    }
}