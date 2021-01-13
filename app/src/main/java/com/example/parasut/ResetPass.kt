package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ResetPass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pass)
    }

    fun back(view: View) {
        finish()
    }
    fun Submit(view: View) {
        var intent= Intent(this,Login::class.java)
        startActivity(intent)
    }
}