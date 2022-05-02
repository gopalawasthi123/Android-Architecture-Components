package com.example.jsonplaceholder.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IPostsDao {

    @Query("Select * From PostItem Where userId = :userId")
    suspend fun GetPostsForUser(userId: String) : List<PostsItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InserAllPostsForUser(postsItem: List<PostsItem>?)
}