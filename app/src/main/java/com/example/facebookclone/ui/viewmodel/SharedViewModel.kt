package com.example.facebookclone.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebookclone.data.model.Post
import com.example.facebookclone.repository.PostRepository
import com.example.facebookclone.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor (val repository: PostRepository) : ViewModel() {


    private val _allPosts =
        MutableStateFlow<RequestState<List<Post>>>(RequestState.Idle)

    val allPosts: StateFlow<RequestState<List<Post>>> = _allPosts


    fun getAllTasks() {
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



}