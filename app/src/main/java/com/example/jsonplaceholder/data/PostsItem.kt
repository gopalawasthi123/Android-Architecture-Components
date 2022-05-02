package com.example.jsonplaceholder.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostItem")
data class PostsItem(
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)