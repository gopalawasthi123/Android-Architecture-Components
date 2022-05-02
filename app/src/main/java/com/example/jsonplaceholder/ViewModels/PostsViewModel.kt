package com.example.jsonplaceholder.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholder.data.PostsItem
import com.example.jsonplaceholder.repo.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: PostsRepository) : ViewModel() {
    private val _livedata = MutableLiveData<List<PostsItem>>()

     val livedataModel : LiveData<List<PostsItem>> = _livedata

    fun getAllPostsForUser( userId : Int){
        viewModelScope.launch {
            repository.GetPostsForUser(userId).let {
                _livedata.postValue(it)
            }
        }
    }

}