package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        textForgotPassword.setOnClickListener{
            intent= Intent(this,ForgotPass::class.java)
            startActivity(intent)
        }
    }

    fun login(view: View) {
        if (idUser.text.toString().equals("admin",true) and pass.text.toString().equals("admin",true)) {
            Toast.makeText(this, "Login sucessful", Toast.LENGTH_SHORT).show()
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Username or Password is failed", Toast.LENGTH_SHORT).show()
        }
    }

    fun linkSingup(view: View) {
        var intent= Intent(this,Signup::class.java)
        startActivity(intent)
    }
}