package com.example.facebookclone.ui.screens.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.facebookclone.ui.widgets.AppBar
import com.example.facebookclone.ui.widgets.TabItem
import com.example.facebookclone.ui.widgets.Tabs
import com.example.facebookclone.ui.widgets.TabsContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val tabs = listOf(TabItem.Home, TabItem.Friends, TabItem.Watch, TabItem.Profile, TabItem.Notification, TabItem.Menu)
    val pagerState = rememberPagerState()
    Scaffold(
        topBar = { AppBar() },
    ) {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}


@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}