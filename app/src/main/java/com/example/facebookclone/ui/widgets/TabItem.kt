package com.example.facebookclone.ui.widgets

import androidx.compose.runtime.Composable
import com.example.facebookclone.R
import com.example.facebookclone.ui.screens.friends.FriendsScreen
import com.example.facebookclone.ui.screens.home.HomeScreen
import com.example.facebookclone.ui.screens.menu.MenuScreen
import com.example.facebookclone.ui.screens.notification.NotificationScreen
import com.example.facebookclone.ui.screens.profile.ProfileScreen
import com.example.facebookclone.ui.screens.watch.WatchScreen


sealed class TabItem (var icon: Int, var title: String) {
    object Home: TabItem(R.drawable.ic_baseline_home, "Home")
    object Friends: TabItem(R.drawable.ic_friends, "Friends" )
    object Watch: TabItem(R.drawable.ic_watch, "Watch" )
    object Profile: TabItem(R.drawable.ic_profile, "Profile")
    object Notification: TabItem(R.drawable.ic_notification, "Notifications")
    object Menu: TabItem(R.drawable.ic_menu, "Menu")
}