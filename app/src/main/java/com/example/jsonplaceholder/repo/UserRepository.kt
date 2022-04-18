package com.example.jsonplaceholder.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.jsonplaceholder.data.IUserDao
import com.example.jsonplaceholder.data.IUserService
import com.example.jsonplaceholder.data.Users
import com.example.jsonplaceholder.data.UsersItem
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService : IUserService, private val userdao : IUserDao) {

    suspend fun getUsers() : List<UsersItem> {
        val userList =   userdao.getListUsers()
        if(userList.toList().isEmpty()){
            if(userService.getUsers().isSuccessful){
                userdao.insertAllUsers(userService.getUsers().body())
            }
        }
        return userdao.getListUsers()
    }

}
