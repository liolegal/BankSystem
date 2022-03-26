package com.example.financesystem.Activities

import ApproveAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.financesystem.R
import com.example.financesystem.Users.Manager

class ViewOfApproveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_of_approve)
        val arguments = getIntent().getExtras()
        val selectedManager: Manager = arguments?.getSerializable("manager") as Manager
        var listView = findViewById<ListView>(R.id.approves_list)
        val adapter = ApproveAdapter(this, selectedManager.listOfApprove)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            selectedManager.approve(selectedManager.listOfApprove[position])
            adapter.notifyDataSetChanged();
        }














//        val namesOfApprove = mutableListOf<String>()
//        for ((key, value) in selectedManager.mapOfApprove) {
//            namesOfApprove.add(value.name + "\n" + value.secondName + "\n" + value.login)
//        }
//        val arrayAdapter: ArrayAdapter<*>
//        var mListView = findViewById<ListView>(R.id.approves_list)
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namesOfApprove)
//        mListView.adapter = arrayAdapter
//        mListView.setOnItemClickListener { _, _, position, _ ->
//            selectedManager.approve(selectedManager.mapOfApprove.getValue(namesOfApprove[position]))
//            arrayAdapter.notifyDataSetChanged();
//            Toast.makeText(
//                this,
//                selectedManager.mapOfApprove.getValue(namesOfApprove[position]).approveOfManager.toString(),
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}