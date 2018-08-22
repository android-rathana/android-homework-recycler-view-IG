package com.example.ratha.myapplication.entity

import java.util.*

data class User (var id : Int,
                 var name : String,
                 var email: String,
                 var password :String,
                 var facebookId : String,
                 var gender :String ,
                 var registeredDate: Date,
                 var dob : Date)