package com.example.financesystem.Activities

import android.content.Intent
import android.content.Intent.getIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.financesystem.Abstractions.BankAccount
import com.example.financesystem.BankSystem
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class BankAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bank_account)
        val arguments = getIntent().getExtras()
        val selectedBankAccount: BankAccount =
            arguments?.getSerializable("bankAccount") as BankAccount
        val selectedClient: Client = arguments?.getSerializable("client") as Client
        findViewById<TextView>(R.id.id_of_selected_account_text).text =
            selectedBankAccount.idOfBankAccount
        findViewById<TextView>(R.id.money_of_selected_account).text =
            selectedBankAccount.countOfMoney.toString()
        findViewById<Button>(R.id.delete_account_button).setOnClickListener() {
            BankSystem.deleteBankAccount(selectedClient, selectedBankAccount)
            val newActivityIntent = Intent(this, BankAccountActivity::class.java)
            newActivityIntent.putExtra("client", selectedClient)
            startActivity(newActivityIntent)
        }
    }

}