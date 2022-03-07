package com.example.facebookclone.data.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.facebookclone.R
import com.example.facebookclone.util.Constants.DATABASE_TABLE


@Entity(tableName = DATABASE_TABLE)
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String = "Babatunde Owoleke",
    @DrawableRes
    val profilePicture: Int = R.drawable.profile_image,

    val status: String,

    @DrawableRes
    val postImage: Int = R.drawable.test_image,

    val time: String = "1h",

    val comments: String = "10 Comments",

    val views: String = "500 Views"

)
