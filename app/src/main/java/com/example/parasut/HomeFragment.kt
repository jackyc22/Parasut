package com.example.parasut

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.FieldPosition
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(),DataObjectAdapter.onItemClickListnerObject,DataCategoryAdapter.onItemClickCategory,TravelLocationAdapter.onItemClickObjectTop{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewPager2: ViewPager2
    private lateinit var recyclerView: RecyclerView
    private val locationHandler = Handler()
    private lateinit var listView: RecyclerView
    private lateinit var communicator:CommicatorCategory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView= inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        //Top rate
        viewPager2 = rootView.findViewById(R.id.locationsViewPager)
        val travelLocations: MutableList<TravelLocation> =ArrayList()
        travelLocations.add(TravelLocation(getString(R.string.title_danau_toba),getString(R.string.location_danau_toba),R.drawable.lake_toba,getString(R.string.rate_danau_toba).toFloat()))
        travelLocations.add(TravelLocation(getString(R.string.title_sipiso_piso),getString(R.string.location_sipiso_piso),R.drawable.sipiso_piso,getString(R.string.rate_sipiso_piso).toFloat()))
        travelLocations.add(TravelLocation(getString(R.string.title_samosir),getString(R.string.location_samosir),R.drawable.samosir,getString(R.string.rate_samosir).toFloat()))
        viewPager2.adapter = TravelLocationAdapter(travelLocations,viewPager2,this)
        viewPager2.clipToPadding =false
        viewPager2.clipChildren=false
        viewPager2.offscreenPageLimit= 3
        viewPager2.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(25))
        compositePageTransformer.addTransformer {page, position ->
            val r= 1- abs(position)
            page.scaleY = 0.95f + r * 0.06f
        }
        viewPager2.setPageTransformer(compositePageTransformer)

        viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int){
                super.onPageSelected(position)
                locationHandler.removeCallbacks(locationRunnable)
                locationHandler.postDelayed(locationRunnable,8000)
            }
        })
        //Category
        val data: MutableList<DataCategory> =ArrayList()
        data.add(DataCategory("Danau",R.drawable.cat))
        data.add(DataCategory("Pegunungan",R.drawable.cat))
        data.add(DataCategory("Air Terjun",R.drawable.cat))
        data.add(DataCategory("Taman Nasional",R.drawable.cat))
        recyclerView=rootView.findViewById(R.id.rvCategory)
        recyclerView.adapter=DataCategoryAdapter(data,this)
        recyclerView.layoutManager= LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(true)

        //Rekomendasi
        val dataObject: MutableList<DataObject> = ArrayList()
        dataObject.add(DataObject(R.drawable.istana_maimun, getString(R.string.title_istana_maimun), getString(R.string.istana_maimun_description_cover), getString(R.string.location_istana_maimun), getString(R.string.rate_istana_maimun)))
        dataObject.add(DataObject(R.drawable.rahmat_international,  getString(R.string.title_rahmat), getString(R.string.rahmat_description_cover), getString(R.string.location_rahmat), getString(R.string.rate_rahmat)))
        dataObject.add(DataObject(R.drawable.danau_linting,  getString(R.string.title_danau_linting), getString(R.string.danau_linting_description_cover), getString(R.string.location_danau_linting), getString(R.string.rate_danau_linting)))

        listView=rootView.findViewById(R.id.lvObject)
        listView.adapter=DataObjectAdapter(dataObject,this)
        listView.layoutManager= LinearLayoutManager(activity)
        listView.setHasFixedSize(true)

        communicator=activity as CommicatorCategory
        return rootView;
    }
    private  val locationRunnable = Runnable {
        viewPager2.currentItem= viewPager2.currentItem +1
    }
    override fun onPause(){
        super.onPause()
        locationHandler.postDelayed(locationRunnable,8000)
    }

    override fun onResume() {
        super.onResume()
        locationHandler.postDelayed(locationRunnable,8000)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onItemClick(item: DataObject, position: Int) {
        var intent= Intent(activity,Object::class.java)
        intent.putExtra("TITLE",item.title)
        startActivity(intent)
    }

    override fun onItemClick(item: DataCategory, position: Int) {
        communicator.passDataCategory(item.title)
    }

    override fun onItemClick(item: TravelLocation, position: Int) {
        var intent= Intent(activity,Object::class.java)
        intent.putExtra("TITLE",item.title)
        startActivity(intent)
    }


}