package com.example.financesystem.Users

import com.example.financesystem.User

class Administrator (
        override val name:String,
        override val secondName:String,
        override val login:String,
        override val password:String): User(){

}