package com.example.financesystem

import com.example.financesystem.Abstractions.BankAccount
import com.example.financesystem.Abstractions.Company
import com.example.financesystem.Abstractions.Transfer
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager


class BankSystem {
    val vtb = Bank("VTB")
    val belarusbank = Bank("Belarusbank")
    val belinvest = Bank("Belinvest")
    val kirill = Client("kirill", "Tihon", "Kirill", "1234")
    val oleg = Client("oleg", "kriv", "Oleg", "4567")
    val maks = Client("maks", "krup", "Maks", "9876")
    val manager = Manager("ivan", "pupkin", "manager", "manager")
    val vlad = Client("Vlad", "belko", "vlad", "1234")
    val alexey = Client("Alexey", "hgj", "Alexey", "1234")
    var banks = mapOf(vtb.nameOfBank to vtb,
            belarusbank.nameOfBank to belarusbank,
            belinvest.nameOfBank to belinvest)

    //________________________________________________________________________//
    var globalMapOfAccounts = mutableMapOf<String, BankAccount>()
    var transfers = mutableListOf<Transfer>()

    //______________________________________________________________________________________
    fun addTransfer(_sender: BankAccount, _idOfReceiver: String, _countOfMoney: Float) {
        val receiver: BankAccount = globalMapOfAccounts.getValue(_idOfReceiver)
        val newTransfer: Transfer = Transfer(_sender, receiver)
        newTransfer.transfer(_countOfMoney)
        transfers.add(newTransfer)
    }

    fun createBankAccount(_client: Client) {
        val newBankAccount = _client.createBankAccount()
        globalMapOfAccounts.putIfAbsent(newBankAccount.idOfBankAccount, newBankAccount)


    }


    fun createBankAccount(_company: Company) {
        TODO()
    }


//    fun fill() {
//    vtb.usersPasswords.putIfAbsent("kirill", "1234")
//    vtb.clientsOfBank.putIfAbsent("kirill", kirill)
//    belarusbank.usersPasswords.putIfAbsent("vlad", "1234")
//    belarusbank.clientsOfBank.putIfAbsent("vlad", vlad)
//    belinvest.usersPasswords.putIfAbsent("Alexey", "1234")
//    belinvest.clientsOfBank.putIfAbsent("Alexey", alexey)
//    }


//    fun fillMaps(bank: Bank){
//        var i=0
//        while(i<100){
//            val password=i.toString()
//                //(0..100).random().toString()
//            val login=i.toString()
//            bank.usersPasswords.putIfAbsent(login, password)
//            bank.usersMap.putIfAbsent(login, Client(login, password))
//            i++
//
//        }
//    }
//
//    fun save(bank: Bank){
//        var builder = GsonBuilder()
//        var gson = builder.create()
//        val str:String = gson.toJson(bank)
//        try{
//            val fileWriter = FileWriter("test.txt", true)
//            fileWriter.write(str)
//            fileWriter.close()
//        } catch (exception: Exception){
//            println(exception.message)
//        }

//    }

}