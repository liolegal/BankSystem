package com.example.financesystem.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.financesystem.R
import com.example.financesystem.Users.Client
import com.example.financesystem.Users.Manager

class ManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager)
        val arguments = getIntent().getExtras()
        val selectedManager: Manager = arguments?.getSerializable("manager") as Manager
        findViewById<Button>(R.id.show_approve_list_button).setOnClickListener() {
            val newIntent = Intent(this, ViewOfApproveActivity::class.java)
            newIntent.putExtra(
                "manager",
                selectedManager
            )
            startActivity(newIntent)
        }

    }

}