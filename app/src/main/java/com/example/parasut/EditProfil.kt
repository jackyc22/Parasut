package com.example.parasut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EditProfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
    }

    fun back(view: View) {
        finish()
    }
}