package com.example.jsonplaceholder.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IUserService {

    @GET("/users")
    suspend fun getUsers() : Response<List<UsersItem>>

}