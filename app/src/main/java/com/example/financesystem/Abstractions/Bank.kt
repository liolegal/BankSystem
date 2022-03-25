package com.example.financesystem

import com.example.financesystem.Abstractions.Transfer
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager
import java.io.Serializable

class Bank(_nameOfBank: String) : Serializable {
    var usersPasswords = mutableMapOf<String, String>()
    var clientsOfBank = mutableMapOf<String, Client>()
    var managersOfBank = mutableMapOf<String, Manager>()
    val nameOfBank: String = _nameOfBank

    fun getClientByLogin(_login: String): Client {
        return clientsOfBank.getValue(_login)
    }
    fun createClient(_login:String,_password:String,_name:String,_secondName:String):Client{
        val newClient=Client(_login,_password,_name,_secondName)
        usersPasswords.putIfAbsent(_login,_password)
        clientsOfBank.putIfAbsent(_login,newClient)
        return newClient
    }
    fun callApprove(){

    }

}