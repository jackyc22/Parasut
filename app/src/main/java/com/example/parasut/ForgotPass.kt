package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ForgotPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
    }

    fun back(view: View) {
        finish()
    }

    fun Send(view: View) {
        var intent= Intent(this,Verification::class.java)
        startActivity(intent)
    }
}