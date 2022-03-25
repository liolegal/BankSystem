package com.example.financesystem.Abstractions

import java.util.*

class Transfer(_sender: BankAccount, _receiver: BankAccount) {
    val sender = _sender
    val receiver = _receiver

    fun transfer(_countOfMoney: Float) {
        sender.transfersOfBankAccount.add(this)
        sender.getMoney(_countOfMoney)
        receiver.putMoney(_countOfMoney)
    }

}