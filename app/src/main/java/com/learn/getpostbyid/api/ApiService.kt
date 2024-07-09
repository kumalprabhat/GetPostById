package com.learn.getpostbyid.api

import com.learn.getpostbyid.models.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts/{id}")
    suspend fun getPostById(@Path("id")id: String): Post
}