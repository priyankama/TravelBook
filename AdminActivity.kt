package com.example.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        modifyBtn.setOnClickListener(){
            val intent = Intent(applicationContext, AdminWorkActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Details Modified !!",Toast.LENGTH_SHORT)
        }
        viewBtn.setOnClickListener(){
            val intent = Intent(applicationContext, ViewActivity::class.java)
            startActivity(intent)
        }
    }
}