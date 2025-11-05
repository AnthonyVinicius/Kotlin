package com.example.fragmentsatv.repository

import com.example.fragmentsatv.modal.PostsItem
import com.example.fragmentsatv.service.RetrofitInstance

class PostRepository {
    private val api = RetrofitInstance.api

    suspend fun fecthPosts(): List<PostsItem> = api.getPosts()
}
