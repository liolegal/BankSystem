package com.example.financesystem

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.Activities.LoginActivity
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWork()
    }

    fun startWork() {
        val vtb = Bank("VTB")
        val belarusbank = Bank("Belarusbank")
        val belinvest = Bank("Belinvest")
        val kirill = Client("Kirill", "1234", "Kirill", "Tihonovich")
        kirill.approveOfManager=true
        val vlad = Client("Vlad", "1234", "vlad", "belko")
        vlad.approveOfManager=true
        val alexey = Client("Alexey", "hgj", "Alexey", "1234")
        alexey.approveOfManager=true
        val manager = Manager("ivan", "pupkin", "manager", "manager")
        var banks = mapOf(vtb.nameOfBank to vtb,
                belarusbank.nameOfBank to belarusbank,
                belinvest.nameOfBank to belinvest)
        val bankSystem = BankSystem()
        //bankSystem.fill()
        vtb.usersPasswords.putIfAbsent("Kirill", "1234")
        vtb.clientsOfBank.putIfAbsent("Kirill", kirill)
        vtb.usersPasswords.putIfAbsent(manager.login,manager.password)
        vtb.manager=manager
        belarusbank.usersPasswords.putIfAbsent("vlad", "1234")
        belarusbank.clientsOfBank.putIfAbsent("vlad", vlad)
        belinvest.usersPasswords.putIfAbsent("Alexey", "1234")
        belinvest.clientsOfBank.putIfAbsent("Alexey", alexey)

        val banksNames = arrayOf(vtb.nameOfBank, belarusbank.nameOfBank, belinvest.nameOfBank)
        val arrayAdapter: ArrayAdapter<*>
        var mListView = findViewById<ListView>(R.id.bank_list)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, banksNames)
        mListView.adapter = arrayAdapter
        mListView.setOnItemClickListener { _, _, position, _ ->
            val newActivityIntent = Intent(this, LoginActivity::class.java)
            newActivityIntent.putExtra("bank", banks.getValue(banksNames[position]))

            startActivity(newActivityIntent)
        }
    }

}