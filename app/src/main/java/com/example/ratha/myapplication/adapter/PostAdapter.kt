package com.example.ratha.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ratha.myapplication.R
import com.example.ratha.myapplication.callback.ItemClickCallback
import com.example.ratha.myapplication.entity.Post
import com.example.ratha.myapplication.util.CustomDialogHelper

class PostAdapter(var context: Context,var posts : MutableList<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>(){

    internal lateinit var callback : ItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.post_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =this.posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val post=this.posts[position]
        holder.apply {
            this.profileName.text=post.user.name
            this.postContent.text=post.content
            this.postImage.setImageResource(post.image)
        }

        holder.btnOption.setOnClickListener{callback?.onItemClickObject(post)}

    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var profileName: TextView
        var postImage : ImageView
        var postContent :TextView
        var btnOption: ImageView

        init {
            profileName=itemView.findViewById(R.id.profileName)
            postImage=itemView.findViewById(R.id.image)
            postContent=itemView.findViewById(R.id.postContent)
            btnOption=itemView.findViewById(R.id.btnOption)
        }
    }
}