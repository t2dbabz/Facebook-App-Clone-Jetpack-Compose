package com.example.facebookclone.data

import com.example.facebookclone.R
import com.example.facebookclone.data.model.Post

object DataSource {

    fun post() : List<Post> {
        return listOf(
            Post(
                id = 0,
                name = "Victor Owoleke",
                profilePicture = R.drawable.profile_image,
                status = "This is a new beginning. Let do this",
                postImage = R.drawable.test_image,
                time = "2h",
                comments = "200 Comments",
                views = "2.5k Views"
            ),
            Post(
                id = 4,
                name = "Ben Owoleke",
                profilePicture = R.drawable.profile_image,
                status = "This is a new Oyaoo. Let do this",
                postImage = R.drawable.test_image,
                time = "2h",
                comments = "200 Comments",
                views = "2.5k Views"
            ),

        )
    }
}