package com.example.jsonplaceholder.modules

import android.content.Context
import androidx.room.Room
import com.example.jsonplaceholder.data.IPostsDao
import com.example.jsonplaceholder.data.IUserDao
import com.example.jsonplaceholder.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun ProvidesAppDatabase(@ApplicationContext context: Context)  =
        Room.databaseBuilder(
            context,
            AppDataBase ::class.java
            ,"users_database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun ProvidesUserDao(appDataBase: AppDataBase)  : IUserDao{
       return appDataBase.UserDao()
    }

    @Provides
    @Singleton
    fun ProvidesPostsDao(appDataBase: AppDataBase) : IPostsDao{
        return  appDataBase.PostsDao()
    }

}

