package com.example.financesystem.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.Bank
import com.example.financesystem.R
import com.example.financesystem.User
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val inputLogin = findViewById<EditText>(R.id.login_edit)
        val inputPassword = findViewById<EditText>(R.id.password_edit)
        val arguments = getIntent().getExtras()
        val selectedBank: Bank = arguments?.getSerializable("bank") as Bank
        findViewById<TextView>(R.id.registrate_text).setOnClickListener() {
            val newActivityIntent = Intent(this, RegisterActivity::class.java)
            newActivityIntent.putExtra("bankToRegistrate", selectedBank)
            startActivity(newActivityIntent)
        }
        findViewById<TextView>(R.id.bank_title).text = selectedBank.nameOfBank


        findViewById<Button>(R.id.login_button).setOnClickListener() {

            if (selectedBank.usersPasswords.containsKey(inputLogin.text.toString())) {

                if (selectedBank.usersPasswords.getValue(inputLogin.text.toString()) == inputPassword.text.toString()) {
                    Toast.makeText(
                        this,
                        "Welcome" + " " + selectedBank.clientsOfBank.getValue(inputLogin.text.toString()).login,
                        Toast.LENGTH_SHORT
                    ).show()
                    if (selectedBank.clientsOfBank.getValue(inputLogin.text.toString()) is Client) {
                        val newActivityIntent = Intent(this, ClientActivity::class.java)
                        newActivityIntent.putExtra(
                            "client",
                            selectedBank.clientsOfBank.getValue(inputLogin.text.toString())
                        )
                        startActivity((newActivityIntent))
                    }
                    else if(selectedBank.managersOfBank.getValue(inputLogin.text.toString()) is Manager){
                       val newActivityIntent=Intent(this, ManagerActivity::class.java)
                        newActivityIntent.putExtra("manager",selectedBank.managersOfBank.getValue(inputLogin.text.toString()))
                        startActivity((newActivityIntent))
                    }


                }
            }
            Toast.makeText(this, "Wrong login or password", Toast.LENGTH_SHORT).show()
        }
    }
}