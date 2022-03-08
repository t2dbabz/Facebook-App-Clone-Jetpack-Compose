package com.example.facebookclone.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebookclone.data.DataSource
import com.example.facebookclone.data.model.Post
import com.example.facebookclone.repository.PostRepository
import com.example.facebookclone.util.Action
import com.example.facebookclone.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor (val repository: PostRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            val posts = DataSource.post()
            for (post in posts) {
                delay(1000)
                repository.addPost(post)
            }
        }

    }
    private val _allPosts =
        MutableStateFlow<RequestState<List<Post>>>(RequestState.Idle)

    val allPosts: StateFlow<RequestState<List<Post>>> = _allPosts

    val id: MutableState<Int> = mutableStateOf(0)
    val status: MutableState<String> = mutableStateOf("")

    private val _selectedPost: MutableStateFlow<Post?> = MutableStateFlow(null)
    val selectedPost: StateFlow<Post?> = _selectedPost

    val action: MutableState<Action> = mutableStateOf(Action.N0_ACTION)


    fun getAllPosts() {
        _allPosts.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllPosts.collect {
                    _allPosts.value = RequestState.Success(it)
                }
            }

        } catch (e : Exception) {
            _allPosts.value= RequestState.Error(e)

        }

    }



    fun getSelectedPost(postId: Int) {
        viewModelScope.launch {
            repository.getSelectedPost(postId).collect {post ->
                _selectedPost.value = post
            }
        }

    }

    private fun addPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val post = Post(
              status = status.value
            )

            repository.addPost(post)
        }
    }

    private fun deletePost() {
        viewModelScope.launch(Dispatchers.IO) {
            val post = Post(
                id = id.value,
                status = status.value
            )

            repository.deletePost(post)
        }
    }

    fun handleDatabaseActions(action: Action) {
        when (action) {
            Action.ADD -> {
                addPost()
            }

            Action.UPDATE -> {

            }

            Action.DELETE -> {
                deletePost()
            }

            Action.DELETE_ALL -> {

            }
            Action.UNDO -> {

            }

            else -> {

            }
        }

        this.action.value = Action.N0_ACTION
    }


    fun updatePostFields(selectedPost: Post?) {
        if (selectedPost != null) {
            id.value = selectedPost.id
            status.value = selectedPost.status
        } else {
            id.value = 0
            status.value = ""
        }

    }



}