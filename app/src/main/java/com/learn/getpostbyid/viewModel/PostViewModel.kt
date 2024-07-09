package com.learn.getpostbyid.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.getpostbyid.models.Post
import com.learn.getpostbyid.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private val repository = PostRepository()
    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    fun getPostById(id: String){
        viewModelScope.launch {
            _post.value = repository.getPostById(id)
        }
    }
}