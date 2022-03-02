package com.example.facebookclone.ui.widgets

import androidx.compose.runtime.Composable
import com.example.facebookclone.R

typealias ComposableFun = @Composable () -> Unit
sealed class TabItem (val icon: Int, val title: String, val screen: ComposableFun) {
    object Home: TabItem(R.drawable.ic_home, "Home", {})
    object Friends: TabItem(R.drawable.ic_friends, "Friends", {})
    object Watch: TabItem(R.drawable.ic_watch, "Watch", {})
    object Profile: TabItem(R.drawable.ic_profile, "Profile", {})
    object Notification: TabItem(R.drawable.ic_notification, "Notifications", {})
    object Menu: TabItem(R.drawable.ic_menu, "Menu", {})
}