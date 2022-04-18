package com.example.jsonplaceholder.ViewModels

import androidx.lifecycle.*
import com.example.jsonplaceholder.data.UsersItem
import com.example.jsonplaceholder.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val  userRepository: UserRepository) : ViewModel(){

   private val _livedataModel = MutableLiveData<List<UsersItem>>()

     val livedataModel : LiveData<List<UsersItem>> = _livedataModel

     fun getUserFromApi(){
         viewModelScope.launch {
             val resp =  userRepository.getUsers().let {
                 _livedataModel.postValue(it)
             }

         }
    }

}