package com.example.financesystem.Creators

import com.example.financesystem.Abstractions.UserCreator
import com.example.financesystem.User

class ClientCreator: UserCreator() {
override fun createUser(): User {
    TODO()
    //добавление в Map
    //  fun main(){
    // val user:User=ClientCreator().createUser()
    //     user.toLogin()
    //}

}
}