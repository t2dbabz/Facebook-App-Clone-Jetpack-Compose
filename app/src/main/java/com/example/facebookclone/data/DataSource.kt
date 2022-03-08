package com.example.facebookclone.data

import com.example.facebookclone.R
import com.example.facebookclone.data.model.Post

object DataSource {

    fun post() : List<Post> {
        return listOf(
            Post(
                name = "Kathrin Romany Beckinsale",
                profilePicture = R.drawable.profile_pic_1,
                status = "This is a new beginning. Live Life and Excel",
                postImage = R.drawable.profile_pic_1,
                time = "5h",
                comments = "200 Comments",
                views = "2.5k Views"
            ),
            Post(
                name = "Scarlett Johansson",
                profilePicture = R.drawable.profile_pic_2,
                status = "New Year, New Me, New Goals, Let's Go",
                postImage = R.drawable.profile_pic_2,
                time = "2h",
                comments = "1000 Comments",
                views = "4.5k Views"
            ),

        )
    }
}