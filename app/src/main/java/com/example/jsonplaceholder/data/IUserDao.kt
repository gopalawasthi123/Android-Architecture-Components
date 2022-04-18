package com.example.jsonplaceholder.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserDao {

  @Query("Select * From user")
  suspend fun getListUsers() : List<UsersItem>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertAllUsers(usersItem: List<UsersItem>?)
}