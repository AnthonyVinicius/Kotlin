package com.example.fragmentsatv.service

import com.example.fragmentsatv.modal.PostsItem
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun getPosts(): List<PostsItem>

}
