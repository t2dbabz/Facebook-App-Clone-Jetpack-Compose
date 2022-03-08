package com.example.facebookclone.ui.widgets

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.ui.screens.friends.FriendsScreen
import com.example.facebookclone.ui.screens.home.HomeScreen
import com.example.facebookclone.ui.screens.menu.MenuScreen
import com.example.facebookclone.ui.screens.notification.NotificationScreen
import com.example.facebookclone.ui.screens.profile.ProfileScreen
import com.example.facebookclone.ui.screens.watch.WatchScreen
import com.example.facebookclone.ui.theme.logoBlue
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                color = MaterialTheme.colors.logoBlue
            )},
        divider = {
            TabRowDefaults.Divider(thickness = 0.3.dp, color = Color.DarkGray)
        }
    ) {
        tabs.forEachIndexed {index, tab->
            val selected = pagerState.currentPage == index

            Tab(
                icon = { Icon(
                    painter = painterResource(id = tab.icon),
                    contentDescription = tab.title,
                    tint = if (selected) MaterialTheme.colors.logoBlue else Color.DarkGray
                ) },
                selected = selected,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                enabled = true)
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    tabs: List<TabItem>,
    pagerState: PagerState,
    navigateToPost: (Int) -> Unit,
    navigateToPostDetailScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        when(page) {
                0 -> HomeScreen(
                    navigateToPostScreen = navigateToPost,
                    navigateToPostDetailScreen = navigateToPostDetailScreen,
                    sharedViewModel = sharedViewModel
                )
                1 -> FriendsScreen()
                2 -> WatchScreen()
                3 -> ProfileScreen()
                4 -> NotificationScreen()
                5-> MenuScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.Home,
        TabItem.Friends,
        TabItem.Watch,
        TabItem.Profile,
        TabItem.Notification,
        TabItem.Menu
    )
    val pagerState = rememberPagerState()
    Tabs(tabs = tabs, pagerState = pagerState)
}

//@OptIn(ExperimentalPagerApi::class)
//@Preview(showBackground = true)
//@Composable
//fun TabsContentPreview() {
//    val tabs = listOf(
//        TabItem.Home,
//        TabItem.Friends,
//        TabItem.Watch,
//        TabItem.Profile,
//        TabItem.Notification,
//        TabItem.Menu
//    )
//    val pagerState = rememberPagerState()
//    Tabs(tabs = tabs, pagerState =pagerState )
//    TabsContent(tabs = tabs, pagerState = pagerState,)
//}

