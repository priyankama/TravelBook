package com.example.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.visitor.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        visitorBtn.setOnClickListener() {

            val intent = Intent(applicationContext, visitorActivity::class.java)
            startActivity(intent)

        }

        adminBtn.setOnClickListener() {

            val intent = Intent(applicationContext, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}