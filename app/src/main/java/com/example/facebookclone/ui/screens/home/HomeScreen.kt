package com.example.facebookclone.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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

@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize(),content ={
        item {
            AddPostContent()

        }

        item {
            PostItem()
        }
    } )


}



@Composable
fun AddPostContent() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        color = Color.White,
        shape = RectangleShape
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
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium,
                placeholder = {
                    Text(text ="What's on your mind?" )
                }
            )

            Icon(
                modifier = Modifier.padding(start = 16.dp),
                painter = painterResource(id = R.drawable.ic_media),
                contentDescription = "Media",
                tint = Color.Green
            )
        }
    }
}

@Composable
fun PostItem() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RectangleShape
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
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

                   Text(text = "Babatunde Owoleke Babatunde owoleke", style = MaterialTheme.typography.subtitle2)

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = "1h", fontSize = 10.sp)
                        Text(text = ".",  )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_earth),
                            contentDescription = "Earth",
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .size(10.dp)
                        )
                    }
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f), contentAlignment = Alignment.TopEnd){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_more), contentDescription = "More Icon")
                    }
                }
            }

            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tincidunt semper odio, eget suscipit purus vulputate id. Vestibulum in risus efficitur, cursus lacus in, auctor massa.",
                modifier = Modifier.padding(10.dp)
            )


            Image(painter = painterResource(id = R.drawable.test_image), contentDescription = "Post Image", modifier = Modifier
                .fillMaxWidth()
                .height(350.dp), contentScale = ContentScale.Crop, )



        }




    }

}







@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}

//@Composable
//@Preview
//fun AddPostPreview() {
//    AddPostContent  ()
//}