package com.example.travelbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.visitor.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val name = findViewById<EditText>(R.id.name)
        val mobile = findViewById<EditText>(R.id.mobile)
        val email = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)


        registerBtn.setOnClickListener() {
            var name=name.text.toString()
            var mobile=mobile.text.toString()
            var username=email.text.toString()
            var userPassword=password.text.toString()
            var type = "register"

            var registerBackground = registerBackground()
            registerBackground.execute(type,name,username,userPassword,mobile)
            val intent = Intent(applicationContext, VisitorWorkActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Registration successful !!",Toast.LENGTH_SHORT)

        }
    }
}