package com.example.jsonplaceholder.modules

import com.example.jsonplaceholder.data.IPostService
import com.example.jsonplaceholder.data.IUserService
import com.example.jsonplaceholder.util.Constants.BASEURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance() : Retrofit{

        val logger = HttpLoggingInterceptor().apply {level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder().addInterceptor(logger).build()

        return Retrofit
            .Builder()
            .baseUrl(BASEURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun ProvidesUserService(retrofit: Retrofit) : IUserService{
        return retrofit.create(IUserService::class.java)
    }

    @Provides
    @Singleton
    fun ProvidesPostService(retrofit: Retrofit): IPostService{
        return retrofit.create(IPostService :: class.java)
    }

}