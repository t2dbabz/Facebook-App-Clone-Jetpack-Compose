package com.example.facebookclone.ui.widgets

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                color = Color.Blue
            )},
        divider = {
            TabRowDefaults.Divider(thickness = 0.3.dp, color = Color.DarkGray)
        }
    ) {
        tabs.forEachIndexed {index, tab->
            val selected = pagerState.currentPage == index

            Tab(
                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = tab.title, tint = if (selected) Color.Blue else Color.DarkGray) },
                selected = selected,
                onClick = {
                    tab
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
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen()
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

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        TabItem.Home,
        TabItem.Friends,
        TabItem.Watch,
        TabItem.Profile,
        TabItem.Notification,
        TabItem.Menu
    )
    val pagerState = rememberPagerState()
    Tabs(tabs = tabs, pagerState =pagerState )
    TabsContent(tabs = tabs, pagerState = pagerState)
}

