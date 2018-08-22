package com.example.ratha.myapplication.entity

import android.support.annotation.DrawableRes

data class Post(var id: Int,
                var content: String,
                var isLiked : Boolean,
                var isBookmark: Boolean,
                @DrawableRes var image: Int,
                var user : User)