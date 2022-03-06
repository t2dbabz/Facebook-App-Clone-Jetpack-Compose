package com.example.facebookclone.repository

import com.example.facebookclone.data.PostDao
import com.example.facebookclone.data.model.Post
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class PostRepository @Inject constructor (private val postDao: PostDao) {
    val getAllPosts: Flow<List<Post>>  = postDao.getAllPosts()

    fun getSelectedPost(postId: Int): Flow<Post> {
        return postDao.getSelectedPost(postId)
    }

    suspend fun addPost(post: Post){
        postDao.addPost(post)
    }

    suspend fun updatePost(post: Post) {
        postDao.updatePost(post)
    }

    suspend fun deletePost(post: Post) {
        postDao.deletePost(post)
    }
}