package com.example.facebookclone.ui.widgets

import androidx.compose.runtime.Composable
import com.example.facebookclone.R
import com.example.facebookclone.ui.screens.home.HomeScreen

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem (var icon: Int, var title: String, var screen: ComposableFun) {
    object Home: TabItem(R.drawable.ic_baseline_home, "Home", { HomeScreen() })
    object Friends: TabItem(R.drawable.ic_friends, "Friends", { HomeScreen()})
    object Watch: TabItem(R.drawable.ic_watch, "Watch", { HomeScreen()})
    object Profile: TabItem(R.drawable.ic_profile, "Profile", { HomeScreen()})
    object Notification: TabItem(R.drawable.ic_notification, "Notifications", { HomeScreen()})
    object Menu: TabItem(R.drawable.ic_menu, "Menu", { HomeScreen()})
}