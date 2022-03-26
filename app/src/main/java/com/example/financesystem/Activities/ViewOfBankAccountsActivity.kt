package com.example.financesystem.Activities

import BankAccountsAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.financesystem.Abstractions.BankAccount
import com.example.financesystem.R
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager

class ViewOfBankAccountsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_of_bank_accounts)
        val arguments = getIntent().getExtras()
        val selectedClient: Client = arguments?.getSerializable("953") as Client
        var listView = findViewById<ListView>(R.id.accounts_list)
        val bankAccounts = selectedClient.bankAccounts
       val adapter = BankAccountsAdapter(this,bankAccounts)
       listView.adapter = adapter
    }
}