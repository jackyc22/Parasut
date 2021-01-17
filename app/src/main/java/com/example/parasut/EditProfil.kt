package com.example.parasut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class EditProfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
    }

    fun back(view: View) {
        finish()

    }
    override fun onBackPressed() {
        var dialogBuilder= AlertDialog.Builder(this).setMessage("Apakah anda yakin ingin keluar?").setPositiveButton("Ya")
        {DialogInterface,id -> super.onBackPressed()}
                .setNegativeButton("Tidak"){DialogInterface,id-> }
        dialogBuilder.show()
    }

    fun save(view: View) {
        Toast.makeText(this,"Data tersimpan",Toast.LENGTH_SHORT).show()
    }
}