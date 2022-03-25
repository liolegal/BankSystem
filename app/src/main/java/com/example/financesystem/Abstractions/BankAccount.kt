package com.example.financesystem.Abstractions

import java.io.Serializable

class BankAccount : Serializable {
    var transfersOfBankAccount = mutableListOf<Transfer>()
    var idOfBankAccount: String = "undef"
    var countOfMoney: Float = 0F
    fun putMoney(_countOfMoney: Float) {
        TODO()
        //Пополнить
    }

    fun getMoney(_countOfMoney: Float) {
        TODO()
    }


}
