package com.example.jsonplaceholder.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.PostsActivity
import com.example.jsonplaceholder.R
import com.example.jsonplaceholder.listeners.UserClickInterface

class UserListAdapter(var userClickInterface: UserClickInterface)  : ListAdapter<UsersItem,UserListAdapter.UserViewHolder>(USERS_COMPARATOR){

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        private val userNameView : TextView = itemView.findViewById(R.id.userItemName)


        fun binds(userItem : UsersItem){
            userNameView.text = userItem.name
        }
        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return UserViewHolder(view)
            }
        }

            fun setClicksForViews(viewHolder: UserViewHolder,userClickInterface: UserClickInterface){
                viewHolder.userNameView.setOnClickListener(View.OnClickListener {
                    userClickInterface.OnUserClicked(adapterPosition)
                })
            }


    }

    companion object{
        val USERS_COMPARATOR = object : DiffUtil.ItemCallback<UsersItem>(){
            override fun areItemsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val viewHolder = UserViewHolder.create(parent)
        viewHolder.setClicksForViews(viewHolder,userClickInterface)
        return  viewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.binds(item)
    }

}