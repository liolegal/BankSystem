package com.example.financesystem.Activities

import BankAccountsAdapter
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.Bank
import com.example.financesystem.BankSystem
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class ClientActivity : AppCompatActivity() {
    val arguments = getIntent().getExtras()
    val selectedClient: Client = arguments?.getSerializable("client") as Client
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        var listView = findViewById<ListView>(R.id.accounts_list)
        val adapter = BankAccountsAdapter(this, selectedClient)
        listView.adapter = adapter
        registerForContextMenu(listView)
        findViewById<TextView>(R.id.name_text).text =
            selectedClient.name + " " + selectedClient.secondName
        findViewById<Button>(R.id.add_account).setOnClickListener() {
            BankSystem.createBankAccount(selectedClient)
            adapter.notifyDataSetChanged()

        }

        listView.setOnItemClickListener { _, view, position: Int, id: Long ->

            val newActivityIntent = Intent(this, BankAccountActivity::class.java)
            newActivityIntent.putExtra("bankAccount", selectedClient.bankAccounts[position])
            newActivityIntent.putExtra("client", selectedClient)
            startActivity(newActivityIntent)
        }


    }
    


}