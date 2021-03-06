package com.example.facebookclone.navigation

import androidx.navigation.NavHostController
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.Constants.HOME_SCREEN

class Screens(navController: NavHostController){

    val home: (Action) -> Unit = { action ->
        navController.navigate(route = "home/${action.name}"){
            popUpTo(HOME_SCREEN) {
                inclusive = true
            }

        }

    }

    val post: (Int) -> Unit = { postId ->
        navController.navigate(route = "post/$postId")

    }

    val mainScreen: (Action) -> Unit = { action ->
        navController.navigate(route = "main_screen/${action.name}"){
            popUpTo(HOME_SCREEN) {
                inclusive = true
            }

        }
    }

    val postDetailScreen: (Int) -> Unit = {postId ->
        navController.navigate(route = "post_detail_screen/$postId")
    }



}