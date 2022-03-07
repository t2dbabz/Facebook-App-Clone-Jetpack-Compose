package com.example.facebookclone.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Constants

fun NavGraphBuilder.mainScreenComposable(navigateToPostScreen: (Int) -> Unit, sharedViewModel: SharedViewModel) {
    composable(
        route = Constants.MAIN_SCREEN,
    ){

        MainScreen(navigateToPostScreen = navigateToPostScreen, sharedViewModel = sharedViewModel)
    }
}