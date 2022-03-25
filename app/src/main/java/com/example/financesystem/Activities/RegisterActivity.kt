package com.example.financesystem.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.financesystem.Bank
import com.example.financesystem.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val arguments = getIntent().getExtras()
        val selectedBank: Bank = arguments?.getSerializable("bankToRegistrate") as Bank

        findViewById<Button>(R.id.registrate_button).setOnClickListener(){
             val newClient=selectedBank.createClient(
                findViewById<EditText>(R.id.login_registration_edit).text.toString(),
                findViewById<EditText>(R.id.password_registration_edit).text.toString(),
                findViewById<EditText>(R.id.name_registration_edit).text.toString(),
                findViewById<EditText>(R.id.second_name_registration_edit).text.toString()
            )
            val newActivityIntent = Intent(this, LoginActivity::class.java)
            newActivityIntent.putExtra(
                "bank", selectedBank
            )
            startActivity((newActivityIntent))
        }
    }
}