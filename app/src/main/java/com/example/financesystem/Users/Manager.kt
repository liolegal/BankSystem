package com.example.financesystem.Users

import com.example.financesystem.User

class Manager(
    override val name: String,
    override val secondName: String,
    override val login: String,
    override val password: String
) : Operator(name, secondName, login, password) {
    var listOfApprove = ArrayList<Client>()
    fun approve(_client: Client) {
        _client.approveOfManager = true
        listOfApprove.remove(_client)
    }


}