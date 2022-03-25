package com.example.financesystem

import com.example.financesystem.Interfaces.ILogin
import java.io.Serializable

abstract class User :Serializable{

    abstract val name:String
    abstract val secondName:String
    abstract val login:String
    abstract val password:String
}


