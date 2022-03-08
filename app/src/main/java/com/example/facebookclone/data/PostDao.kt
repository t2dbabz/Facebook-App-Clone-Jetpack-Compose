package com.example.facebookclone.data

import androidx.room.*
import com.example.facebookclone.data.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM post_table ORDER BY id DESC")
    fun getAllPosts() : Flow<List<Post>>

    @Query("SELECT * FROM post_table WHERE id = :postId")
    fun getSelectedPost(postId: Int) : Flow<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(vararg post: Post)

    @Update
    suspend fun updatePost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)

}