package com.example.parasut

import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_event.*

class Event : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        var title=intent.getStringExtra("TITLE")
        var date=intent.getStringExtra("DATE")
        if(title.toString().equals(getString(R.string.title_event_danautoba))){
            textTitleEvent.text=title.toString()
            textDateEvent.text=date.toString()
            var dec=getString(R.string.dec_event_danautoba)
            var dec_html=Html.fromHtml(dec)
            imageEventF.setImageResource(R.drawable.karnaval_danau_toba)
             textDescriptionEventF.text=dec_html
        }
        else if(title.toString().equals(getString(R.string.title_event_samosir))){
            textTitleEvent.text=title.toString()
            textDateEvent.text=date.toString()
            var dec=getString(R.string.dec_event_samosir)
            var dec_html=Html.fromHtml(dec)
            imageEventF.setImageResource(R.drawable.samosir_music_internasional)
            textDescriptionEventF.text=dec_html
        }
        else if(title.toString().equals(getString(R.string.title_event_gemes))){
            textTitleEvent.text=title.toString()
            textDateEvent.text=date.toString()
            var dec=getString(R.string.dec_event_gemes)
            var dec_html=Html.fromHtml(dec)
            imageEventF.setImageResource(R.drawable.gemes)
            textDescriptionEventF.text=dec_html
        }
        else if(title.toString().equals(getString(R.string.title_event_nias))){
            textTitleEvent.text=title.toString()
            textDateEvent.text=date.toString()
            var dec=getString(R.string.dec_event_nias)
            var dec_html=Html.fromHtml(dec)
            imageEventF.setImageResource(R.drawable.nias_festival)
            textDescriptionEventF.text=dec_html
        }
    }

    fun back(view: View) {
        finish()
    }
}