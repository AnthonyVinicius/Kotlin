package com.example.fragmentsatv.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragmentsatv.modal.PostsItem
import com.example.fragmentsatv.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<PostsItem>>()
    val posts: LiveData<List<PostsItem>> get() = _posts

    fun loadPosts() {
        viewModelScope.launch {
            try {
                _posts.value = repository.fecthPosts()
            } catch (e: Exception) {
                // Handle error
            }
        }

    }
}