package com.example.jsonplaceholder.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IPostService {

    @GET("/posts")
    suspend fun getPostsOfUser(@Query("userId") userId :Int) : Response<List<PostsItem>>

}