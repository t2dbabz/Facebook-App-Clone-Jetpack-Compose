package com.example.facebookclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.facebookclone.navigation.SetupNavigation
import com.example.facebookclone.ui.screens.mainscreen.MainScreen
import com.example.facebookclone.ui.theme.FacebookCloneTheme
import com.example.facebookclone.ui.widgets.TabItem
import com.example.facebookclone.ui.widgets.Tabs
import com.example.facebookclone.ui.widgets.TabsContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FacebookCloneTheme {
                navController = rememberNavController()
                SetupNavigation(navController = navController)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FacebookCloneTheme {
        MainScreen({})
    }
}

