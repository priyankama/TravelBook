package com.example.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.registerBtn
import kotlinx.android.synthetic.main.activity_visitor.*
import kotlinx.android.synthetic.main.visitor.*
import kotlinx.android.synthetic.main.visitor.loginBtn

class visitorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visitor)
        val email = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        loginBtn.setOnClickListener() {


            var username=email.text.toString()
            var userPassword=password.text.toString()
            var type = "login"

            var visitorBackground = VisitorBackground()
            visitorBackground.execute(type,username,userPassword)
            val intent = Intent(applicationContext, VisitorWorkActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Login successful !!", Toast.LENGTH_SHORT)


        }
        registerBtn.setOnClickListener() {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)

        }
    }
}