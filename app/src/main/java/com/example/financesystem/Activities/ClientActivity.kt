package com.example.financesystem.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.Bank
import com.example.financesystem.BankSystem
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class ClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        val arguments = getIntent().getExtras()
        val selectedClient: Client = arguments?.getSerializable("client") as Client
        val bankSystem: BankSystem = arguments?.getSerializable("bankSystem") as BankSystem

        findViewById<TextView>(R.id.name_text).text = selectedClient.name + " " + selectedClient.secondName
        findViewById<Button>(R.id.show_bank_accounts).setOnClickListener(){
            val newActivityIntent = Intent(this, ViewOfApproveActivity::class.java)
            newActivityIntent.putExtra(
                "953",
                selectedClient
            )
            startActivity((newActivityIntent))
        }
        findViewById<Button>(R.id.add_account).setOnClickListener() {
        bankSystem.createBankAccount(selectedClient)

        }
            //findViewById<TextView>(R.id.money_text).text=selectedUser.bankAccount.countOfMoney.toString()+"$"
    }
}