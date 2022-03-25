package com.example.financesystem.Activities

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.Bank
import com.example.financesystem.R
import com.example.financesystem.Users.Client

class ClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        val arguments = getIntent().getExtras()
        val selectedUser: Client = arguments?.getSerializable("client") as Client
        findViewById<TextView>(R.id.name_text).text = selectedUser.name + selectedUser.secondName
        //findViewById<TextView>(R.id.money_text).text=selectedUser.bankAccount.countOfMoney.toString()+"$"
    }
}