package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Splash_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__page)
    }
    fun signUp(view: View) {
        var intent= Intent(this,Signup::class.java)
        startActivity(intent)
    }
    fun login(view: View) {
        var intent= Intent(this,Login::class.java)
        startActivity(intent)
    }
}