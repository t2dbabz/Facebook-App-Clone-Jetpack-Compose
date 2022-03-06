package com.example.facebookclone.data.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.facebookclone.util.Constants.DATABASE_TABLE


@Entity(tableName = DATABASE_TABLE)
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    @DrawableRes
    val profilePicture: Int,

    val status: String,

    @DrawableRes
    val postImage: Int,

    val time: String,

    val comments: String,

    val views: String

)
