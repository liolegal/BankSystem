package com.example.financesystem.Users

import com.example.financesystem.User

open class Operator(
        override val name:String,
        override val secondName:String,
        override val login:String,
        override val password:String): User(){


    //Some Methods
}