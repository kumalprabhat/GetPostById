package com.learn.getpostbyid.repository

import com.learn.getpostbyid.api.RetrofitObject
import com.learn.getpostbyid.models.Post

class PostRepository {
    private val apiService = RetrofitObject.apiService

    suspend fun getPostById(id: String): Post {
        return apiService.getPostById(id)
    }
}