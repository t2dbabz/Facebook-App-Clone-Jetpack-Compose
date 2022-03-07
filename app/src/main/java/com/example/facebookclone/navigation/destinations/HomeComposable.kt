package com.example.facebookclone.navigation.destinations

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.facebookclone.ui.screens.home.HomeScreen
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.Constants
import com.example.facebookclone.util.Constants.HOME_ARGUMENT_KEY
import com.example.facebookclone.util.Constants.POST_ARGUMENT_KEY
import com.example.facebookclone.util.toAction


fun NavGraphBuilder.homeComposable(navigateToPostScreen: (postId: Int) -> Unit, sharedViewModel: SharedViewModel) {
    composable(
        route = Constants.HOME_SCREEN,
        arguments = listOf(navArgument(HOME_ARGUMENT_KEY){
            type = NavType.StringType
        })

    ){ navBackStackEntry ->

        val action = navBackStackEntry.arguments?.getString(HOME_ARGUMENT_KEY).toAction()

        Log.d("Home composable", action.toString())

        LaunchedEffect(key1 = action    , block ={
            sharedViewModel.action.value = action
        } )

        MainScreen(navigateToPostScreen = navigateToPostScreen, sharedViewModel = sharedViewModel )
    }
}