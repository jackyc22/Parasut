package com.example.parasut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CommunicatorObject,CommicatorCategory{
    lateinit var homeFragment: HomeFragment
    lateinit var favoriteFragment: FavoriteFragment
    lateinit var calendarFragment: CalendarFragment
    lateinit var profilFragment: ProfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        var bNav=findViewById<BottomNavigationView>(R.id.bottomNav)
        var frame= findViewById<FrameLayout>(R.id.frame)
        homeFragment= HomeFragment()
        loadFragment(homeFragment)
        bNav.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.home ->{
                    homeFragment= HomeFragment()
                    loadFragment(homeFragment)
                }
                R.id.calendar ->{
                    calendarFragment= CalendarFragment()
                    loadFragment(calendarFragment)

                }
                R.id.favorite ->{
                    favoriteFragment= FavoriteFragment()
                    loadFragment(favoriteFragment)

                }
                R.id.profil-> {
                    profilFragment = ProfilFragment()
                    loadFragment(profilFragment)

                }
            }
            true
        }
    }
    fun loadFragment(fragment:Fragment){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit()
    }

    override fun passData() {
        val transaction= this.supportFragmentManager.beginTransaction()
        val fragmentHome = HomeFragment()
        transaction.replace(R.id.frame, fragmentHome)
        bottomNav.getMenu().findItem(R.id.home).setChecked(true);
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun passDataCategory(Title: String) {
        val bundle=Bundle()
        bundle.putString("title",Title)
        val transaction= this.supportFragmentManager.beginTransaction()
        val fragmentCategory = categoryFragment()
        fragmentCategory.arguments=bundle
        transaction.replace(R.id.frame, fragmentCategory)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
