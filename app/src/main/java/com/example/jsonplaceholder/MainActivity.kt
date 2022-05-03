package com.example.jsonplaceholder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.ViewModels.UserViewModel
import com.example.jsonplaceholder.data.UserListAdapter
import com.example.jsonplaceholder.listeners.UserClickInterface
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), UserClickInterface {

    private val viewmodel : UserViewModel by viewModels()

    private var adapter : UserListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)


        adapter = UserListAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        viewmodel.livedataModel.observe(this) { users ->
           users.let{ adapter?.submitList(it)}
        };
        viewmodel.getUserFromApi()
    }

    override fun OnUserClicked(position: Int) {
        val intent = Intent(this, PostsActivity::class.java)
        intent.putExtra("userId", adapter?.currentList?.get(position)?.id)
        this.startActivity(intent)
        Toast.makeText(this,"Position is $position",
            Toast.LENGTH_LONG).show()
    }
}