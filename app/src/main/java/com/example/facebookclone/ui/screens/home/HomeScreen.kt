package com.example.facebookclone.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebookclone.R
import com.example.facebookclone.data.DataSource
import com.example.facebookclone.data.model.Post
import com.example.facebookclone.ui.theme.*
import com.example.facebookclone.ui.viewmodel.SharedViewModel
import com.example.facebookclone.util.RequestState

@Composable
fun HomeScreen(
    navigateToPostScreen: (Int) -> Unit,
    navigateToPostDetailScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    LaunchedEffect(key1 = true, block = {

        sharedViewModel.getAllPosts()
    })

    val allTasks by sharedViewModel.allPosts.collectAsState()

    val action by sharedViewModel.action

    sharedViewModel.handleDatabaseActions(action)
    LazyColumn(modifier = Modifier.fillMaxSize(),content ={
        item {
            AddPostContent(navigateToPostScreen = navigateToPostScreen)
            Divider(thickness = 5.dp, color = Color.LightGray)

        }

        if (allTasks is RequestState.Success) {
            items(items = (allTasks as RequestState.Success<List<Post>>).data, itemContent = { post ->
                PostItem(post, navigateToPostDetailScreen)
                Divider(thickness = 5.dp, color = Color.LightGray)
            })
        }


    } )


}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddPostContent(navigateToPostScreen: (Int) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        color = MaterialTheme.colors.topAppBarBackgroundColor,
        shape = RectangleShape,
        onClick = {
            navigateToPostScreen(-1)
        }
    ) {
            Row(modifier = Modifier.padding(5.dp),verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(
                        id = R.drawable.profile_image,
                    ),
                    contentDescription = "profile image",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth(.80f)
                        .height(50.dp)
                        .clickable {
                            navigateToPostScreen(-1)
                        },
                    shape = MaterialTheme.shapes.medium,
                    enabled = false,
                    placeholder = {
                        Text(text ="What's on your mind?" )
                    }
                )

                Icon(
                    modifier = Modifier.padding(start = 16.dp),
                    painter = painterResource(id = R.drawable.ic_media),
                    contentDescription = "Media",
                    tint = MaterialTheme.colors.mediaGreen
                )
            }
        }
}

@Composable
fun PostItem(post: Post, navigateToPostDetailScreen: (Int) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth().clickable {
              navigateToPostDetailScreen(post.id)
        },
        color = MaterialTheme.colors.postItemBackgroundColor,
        shape = RectangleShape
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = post.profilePicture),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier
                    .padding(start = 5.dp)
                    .weight(8f)) {

                   Text(
                       text = post.name,
                       style = MaterialTheme.typography.h6,
                       color = MaterialTheme.colors.postItemTextColor,
                       fontWeight = FontWeight.Bold
                   )
                    Row(
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text =post.time, fontSize = 12.sp, color = Color.DarkGray)
                        Text(text = '\u00B7'.toString(), fontSize = 10.sp, color = Color.DarkGray, modifier = Modifier.padding(start = 2.dp), fontWeight = FontWeight.ExtraBold)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_earth),
                            contentDescription = "Earth",
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(12.dp)
                        )
                    }
                }

                IconButton(onClick = { /*TODO*/ }, modifier =   Modifier.padding(bottom = 10.dp)) {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_more), contentDescription = "More Icon")
                }

//                Box(modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f), contentAlignment = Alignment.TopStart){
//
//                }
            }

            Text(
                text = post.status,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 10.dp ),
                color = MaterialTheme.colors.postItemTextColor
            )


            Image(painter = painterResource(id = post.postImage), contentDescription = "Post Image", modifier = Modifier
                .fillMaxWidth()
                .height(350.dp), contentScale = ContentScale.Crop, )

            Row(modifier = Modifier.padding(10.dp)){
                Text(text = post.comments, modifier = Modifier.weight(1f), color = MaterialTheme.colors.textGrey)
                Text(text = post.views, modifier = Modifier.weight(1f), textAlign = TextAlign.End, color = MaterialTheme.colors.textGrey)

            }

            Divider(modifier = Modifier.padding(start = 5.dp , end = 5.dp, bottom = 2.dp), thickness = 1.5.dp)

            Row {
                TextButton(
                    onClick = {
                        // do something here
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ThumbUp,
                        contentDescription = "Localized description",
                        modifier = Modifier.padding(end = 8.dp),
                        tint = MaterialTheme.colors.iconGrey
                    )
                    Text(text = "Like", color = MaterialTheme.colors.iconGrey)
                }

                TextButton(
                    onClick = {
                        // do something here
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chat_4),
                        contentDescription = "Localized description",
                        modifier = Modifier.padding(end = 8.dp),
                        tint = MaterialTheme.colors.textGrey
                    )
                    Text(text = "Comment", color = MaterialTheme.colors.iconGrey)
                }


                TextButton(
                    onClick = {
                        // do something here
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share_forward_line),
                        contentDescription = "Localized description",
                        modifier = Modifier.padding(end = 8.dp),
                        tint = MaterialTheme.colors.iconGrey
                    )
                    Text(text = "Share", color = MaterialTheme.colors.iconGrey)
                }
            }
        }

    }

}







@Composable
@Preview
fun HomeScreenPreview() {
//   HomeScreen({})
}

//@Composable
//@Preview
//fun AddPostPreview() {
//    AddPostContent  ()
//}