package com.example.facebookclone.navigation

import androidx.navigation.NavHostController
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.Constants.HOME_SCREEN

class Screens(navController: NavHostController){

    val mainscreen: (Action) -> Unit = { action ->
        navController.navigate(route = "screen/${action.name}"){
            popUpTo(HOME_SCREEN) {
                inclusive = true
            }

        }

    }

    val post: (Int) -> Unit = { postId ->
        navController.navigate(route = "post/$postId")

    }

}