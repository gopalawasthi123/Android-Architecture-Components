package com.example.jsonplaceholder.repo

import com.example.jsonplaceholder.data.IPostsDao
import com.example.jsonplaceholder.data.IUserService
import com.example.jsonplaceholder.data.PostsItem
import javax.inject.Inject

class PostsRepository @Inject constructor(private val postsservice : IUserService,private val postsdao : IPostsDao) {

    suspend fun GetPostsForUser(userId :Int) : List<PostsItem>{
       var posts = postsdao.GetPostsForUser(userId.toString())
        if(posts.isEmpty()){
            if(postsservice.getPostsOfUser(userId).isSuccessful){
                postsdao.InserAllPostsForUser(postsservice.getPostsOfUser(userId).body())
            }
        }
        return  postsdao.GetPostsForUser(userId.toString())
    }
}