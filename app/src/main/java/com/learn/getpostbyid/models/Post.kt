package com.learn.getpostbyid.models

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)