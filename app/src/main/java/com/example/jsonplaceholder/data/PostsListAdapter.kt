package com.example.jsonplaceholder.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonplaceholder.R

 class PostsListAdapter : ListAdapter<PostsItem,PostsListAdapter.PostsViewHolder>(
    POST_COMPARATOR)  {

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView : TextView = itemView.findViewById(R.id.userItemName)

        fun binds(item :PostsItem){
            textView.text = item.title
        }
        companion object{
            fun create(parent: ViewGroup) : PostsViewHolder{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
                return PostsViewHolder(view)
            }
        }
    }

    companion object{
        val POST_COMPARATOR = object  : DiffUtil.ItemCallback<PostsItem>(){
            override fun areItemsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
                return  oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val postItem =  getItem(position)
        holder.binds(postItem)
    }


}