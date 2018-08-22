package com.example.ratha.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ratha.myapplication.adapter.PostAdapter
import com.example.ratha.myapplication.callback.ItemClickCallback
import com.example.ratha.myapplication.entity.Post
import com.example.ratha.myapplication.entity.User
import com.example.ratha.myapplication.util.CustomDialogHelper
import java.sql.Date

class MainActivity : AppCompatActivity() ,ItemClickCallback{
    lateinit var rvPost : RecyclerView
    val posts= mutableListOf<Post>()
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPost=findViewById(R.id.rvPost)
        postAdapter= PostAdapter(this,posts)
        postAdapter.callback=this
        rvPost.layoutManager=LinearLayoutManager(this)
        rvPost.adapter=postAdapter

        getPosts()

    }

    fun getPosts(){
        for(i in 0 .. 50 ){
            var user =User(
                    id=1,name="The Rock",
                    email = "therock@gmail.com",
                    password = "123",
                    facebookId = "234567",
                    gender = "male",
                    registeredDate = Date.valueOf("2018-12-05"),
                    dob = Date.valueOf("1993-12-05"))

            this.posts.add(Post(i,
                    "តោះ! មកស្គាល់មនុស្ស៥នាក់ ដែលមហាសេដ្ឋី Bill Gates ចាត់ទុកជាបុគ្គលអស្ចារ្យបំផុត",
                    false,
                    false,
                    R.drawable.galaxy_note_9,
                    user))
        }

        postAdapter.posts.addAll(posts)
        postAdapter.notifyDataSetChanged()
    }

    override fun onItemClickObject(obj: Any) {
        CustomDialogHelper().show(fragmentManager,"dialog")
    }
}
