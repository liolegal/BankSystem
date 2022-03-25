package com.example.financesystem.Abstractions

import com.example.financesystem.User

abstract class UserCreator{
    abstract fun createUser(): User
}

