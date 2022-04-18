package com.example.jsonplaceholder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jsonplaceholder.data.IUserDao
import com.example.jsonplaceholder.data.UsersItem
import kotlinx.coroutines.CoroutineScope

@Database(entities = [UsersItem :: class],version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun UserDao() : IUserDao

}