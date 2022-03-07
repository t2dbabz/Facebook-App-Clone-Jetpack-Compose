package com.example.facebookclone.ui.screens.post

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.facebookclone.R
import com.example.facebookclone.ui.theme.postItemTextColor

@Composable
fun CreatePostContent(
    status: String,
    onStatusChanged: (String) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_image),
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
                    text = "Babatunde Owoleke",
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.postItemTextColor
                )

            }
        }
        
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = status,
            onValueChange = {onStatusChanged(it)},
            placeholder = {
                Text(text = "What's on your Mind?", color = MaterialTheme.colors.postItemTextColor)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White)
        )
        Divider(modifier = Modifier.padding(start = 5.dp , end = 5.dp, bottom = 5.dp), thickness = 1.5.dp)
    }
}


@Composable
@Preview
fun CreatePostContentPreview() {
    CreatePostContent("", {})
}