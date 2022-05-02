package com.example.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jsonplaceholder.ViewModels.PostsViewModel

class PostsActivity : AppCompatActivity() {
    private var userId : Int = -1
    private lateinit var viewmodel : PostsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts2)
        userId = intent.getIntExtra("userId",-1)

        viewmodel.livedataModel.observe(this){
            posts -> posts.let { Log.d("posts",it.toString()) }
        }

    }
}