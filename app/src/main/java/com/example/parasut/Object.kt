package com.example.parasut

import android.graphics.Color
import android.graphics.Outline
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewOutlineProvider
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily

import kotlinx.android.synthetic.main.activity_object.*
import me.relex.circleindicator.CircleIndicator3

class Object : AppCompatActivity() {
    private lateinit var ov:TextView
    private lateinit var rv:TextView
    private lateinit var view_ov:View
    private lateinit var view_rv:View
    private lateinit var viewPager:ViewPager2
    private lateinit var indicator3: CircleIndicator3
    private var value:Int=-1
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)
        viewPager=findViewById(R.id.imageSliderObject)
        val data: MutableList<ImageSlider> =ArrayList()

        var title =intent.getStringExtra("TITLE")
        if(title.equals(getString(R.string.title_danau_toba))){
//            imageObject.setImageResource(R.drawable.lake_toba)
            data.add(ImageSlider(R.drawable.lake_toba))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_danau_toba)
            textLocationObjectF.text=getString(R.string.location_danau_toba)
            textReviewF.text=getString(R.string.rate_review_danau_toba)
        }
        else if(title.equals(getString(R.string.title_sipiso_piso))){
//            imageObject.setImageResource(R.drawable.sipiso_piso)
            data.add(ImageSlider(R.drawable.lake_toba))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_sipiso_piso)
            textLocationObjectF.text=getString(R.string.location_sipiso_piso)
            textReviewF.text=getString(R.string.rate_review_sipiso_piso)
        }
        else if(title.equals(getString(R.string.title_samosir))){
//            imageObject.setImageResource(R.drawable.samosir)
            data.add(ImageSlider(R.drawable.samosir))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_samosir)
            textLocationObjectF.text=getString(R.string.location_samosir)
            textReviewF.text=getString(R.string.rate_review_samosir)
        }
        else if(title.equals(getString(R.string.title_danau_linting))){
            data.add(ImageSlider(R.drawable.danau_linting))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_danau_linting)
            textLocationObjectF.text=getString(R.string.location_danau_linting)
            textReviewF.text=getString(R.string.rate_review_danau_linting)
        }
        else if(title.equals(getString(R.string.title_istana_maimun))){
            data.add(ImageSlider(R.drawable.istana_maimun))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_istana_maimun)
            textLocationObjectF.text=getString(R.string.location_istana_maimun)
            textReviewF.text=getString(R.string.rate_review_istana_maimun)
        }
        else if(title.equals(getString(R.string.title_rahmat))){
            data.add(ImageSlider(R.drawable.rahmat_international))
            data.add(ImageSlider(R.drawable.lake_toba2))
            data.add(ImageSlider(R.drawable.lake_toba3))
            textTitleObjectF.text=title
            textStartRatingObjectF.text=getString(R.string.rate_rahmat)
            textLocationObjectF.text=getString(R.string.location_rahmat)
            textReviewF.text=getString(R.string.rate_review_rahmat)
        }
        viewPager.adapter=ImageSliderAdapter(data)
        viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        indicator3=findViewById(R.id.indicator)
        indicator3.setViewPager(viewPager)

        var overview=OverviewFragment()
        var bundle=Bundle()
        bundle.putString("title",title)
        overview.arguments=bundle
        fabAdd.hide()
        loadFragment(overview)
        ov= findViewById(R.id.textOverview)
        rv=findViewById(R.id.textReview)
        view_ov=findViewById(R.id.viewOverview)
        view_rv=findViewById(R.id.viewReview)
        ov.setTextColor(Color.parseColor("#000000"))
        view_ov.setBackgroundColor(Color.parseColor("#000000"))
        ov.setOnClickListener{
            var overview=OverviewFragment()
            var bundle=Bundle()
            bundle.putString("title",title)
            overview.arguments=bundle
            fabAdd.hide()
            loadFragment(overview)
            ov.setTextColor(Color.parseColor("#000000"))
            view_ov.setBackgroundColor(Color.parseColor("#000000"))
            rv.setTextColor(getColor(R.color.gray_white))
            view_rv.setBackgroundColor(getColor(R.color.gray_white))

        }
        rv.setOnClickListener{
            var review=ReviewFragment()
            loadFragment(review)
            fabAdd.show()
            rv.setTextColor(Color.parseColor("#000000"))
            view_rv.setBackgroundColor(Color.parseColor("#000000"))
            ov.setTextColor(getColor(R.color.gray_white))
            view_ov.setBackgroundColor(getColor(R.color.gray_white))
        }
    }
    fun loadFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameObject, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    fun favorite(view: View) {
        value*=-1
        if(value==1){
            btnFavorite.setImageResource(R.drawable.ic_launcher_favorite_red)
        }
        else{
            btnFavorite.setImageResource(R.drawable.ic_launcher_favorite)
        }
    }
    fun back(view: View) {
        finish()
    }

    fun fabAddReview(view: View) {
        var mylayout=layoutInflater.inflate(R.layout.dialog_review,null)
        val myDialogBuilder=AlertDialog.Builder(this).apply {
            setView(mylayout)
        }
        var myDialog=myDialogBuilder.create()
        var titleR=mylayout.findViewById<TextView>(R.id.textTitleReview)
        var btnCheck=mylayout.findViewById<ImageButton>(R.id.btnCheck)
        var btnClear=mylayout.findViewById<ImageButton>(R.id.btnClear)
        var rateBar=mylayout.findViewById<RatingBar>(R.id.rateBar)
        titleR.text=intent.getStringExtra("TITLE")
        btnClear.setOnClickListener{
            myDialog.cancel()
        }
        btnCheck.setOnClickListener {
            Toast.makeText(this,"Terima Kasih",Toast.LENGTH_SHORT).show()
            myDialog.cancel()
        }
        rateBar.setOnRatingBarChangeListener{ratingBar,rating,fromUser->
            Toast.makeText(this,"Rating: $rating",Toast.LENGTH_SHORT).show()
        }
        myDialog.show()
    }
}