package com.example.jsonplaceholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.ViewModels.PostsViewModel
import com.example.jsonplaceholder.data.PostsListAdapter
import com.example.jsonplaceholder.listeners.UserClickInterface
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostsActivity : AppCompatActivity() {
    private var userId : Int = -1
    private val viewmodel : PostsViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private var adapter :PostsListAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts2)
        userId = intent.getIntExtra("userId",-1)

        adapter = PostsListAdapter()
        recyclerView = findViewById(R.id.recyclerPosts)
        var layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        viewmodel.livedataModel.observe(this){
            posts -> posts.let { adapter?.submitList(it) }
        }
        viewmodel.getAllPostsForUser(userId)


    }


}