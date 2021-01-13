package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Verification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
    }

    fun Verify(view: View) {
        intent= Intent(this, ResetPass::class.java)
        startActivity(intent)

    }
    fun back(view: View) {
        finish()
    }
}