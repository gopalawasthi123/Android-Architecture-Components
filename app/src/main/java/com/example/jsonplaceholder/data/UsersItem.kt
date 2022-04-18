package com.example.jsonplaceholder.data

import androidx.room.*

@Entity(tableName = "user")
data class UsersItem(
    val email: String,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "uname")
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)