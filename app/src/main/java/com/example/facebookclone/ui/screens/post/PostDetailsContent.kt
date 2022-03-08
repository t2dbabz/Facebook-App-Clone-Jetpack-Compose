package com.example.facebookclone.ui.screens.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebookclone.R
import com.example.facebookclone.data.model.Post
import com.example.facebookclone.ui.theme.postItemTextColor

@Composable
fun PostDetailsContent(post: Post?) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = post?.profilePicture!!),
                contentDescription = "Profile Picture",
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
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.postItemTextColor
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text =post.time, fontSize = 10.sp, color = Color.DarkGray)
                    Text(text = '\u00B7'.toString(), fontSize = 24.sp, color = Color.DarkGray, modifier = Modifier.padding(start = 2.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_earth),
                        contentDescription = "Earth",
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(10.dp)
                    )
                }

            }
        }

        Text(text = post?.status!!, modifier = Modifier.padding(10.dp))

        Image(painter = painterResource(id = post.postImage), contentDescription = "Post Image", modifier = Modifier
            .fillMaxWidth()
            .height(350.dp), contentScale = ContentScale.Crop, )

        Row() {
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
                    tint = Color.LightGray
                )
                Text(text = "Like", color = Color.DarkGray)
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
                    tint = Color.LightGray
                )
                Text(text = "Comment", color = Color.DarkGray)
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
                    tint = Color.LightGray
                )
                Text(text = "Share", color = Color.DarkGray)
            }
        }

    }
}


@Composable
@Preview
fun PostDetailsContentPreview() {
   val post = Post(
        id = 0,
        name = "Victor Owoleke",
        profilePicture = R.drawable.profile_image,
        status = "This is a new beginning. Let do this",
        postImage = R.drawable.test_image,
        time = "2h",
        comments = "200 Comments",
        views = "2.5k Views"
    )
    PostDetailsContent(post = post)
}