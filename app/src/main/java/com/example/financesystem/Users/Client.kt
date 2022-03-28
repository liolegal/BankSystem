package com.example.financesystem.Users


import com.example.financesystem.Abstractions.BankAccount
import com.example.financesystem.BankSystem
import com.example.financesystem.User
import java.io.Serializable

class Client(
        override val login: String,
        override val password: String,
        override val name: String = "undef",
        override val secondName: String = "undef",
) : User(), Serializable {
    var passportSeries: String = "Undefined"
    var idClient: String = "Undefined"
    var phoneNumber: String = "Undefined"
    var email: String = "Undefined"
    var approveOfManager=false
    var bankAccounts = ArrayList<BankAccount>()


    fun createBankAccount(): BankAccount {
        val newBankAccount = BankAccount()
        newBankAccount.idOfBankAccount = (1..100).random().toString() + "acc"
        bankAccounts.add(newBankAccount)
        return newBankAccount
    }
    fun deleteBankAccount(toDelete:BankAccount){
        bankAccounts.remove(toDelete)
    }


    fun getBankAccount(_id: String): BankAccount {
        lateinit var  accToReturn:BankAccount
        for (acc in bankAccounts){
            if(acc.idOfBankAccount==_id){
                accToReturn=acc
            }
        }
        return accToReturn
    }

}