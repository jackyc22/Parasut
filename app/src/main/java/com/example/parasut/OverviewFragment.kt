package com.example.parasut

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_object.*
import kotlinx.android.synthetic.main.activity_object.view.*
import kotlinx.android.synthetic.main.fragment_overview.*
import kotlinx.android.synthetic.main.fragment_overview.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverviewFragment : Fragment(),OnMapReadyCallback,View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var title:String?=null
    private lateinit var mapFragment:SupportMapFragment
    private lateinit var map:GoogleMap
    private var gmmIntentUri:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView=inflater.inflate(R.layout.fragment_overview, container, false)
        mapFragment= childFragmentManager.findFragmentById(R.id.fragmentMaps) as SupportMapFragment
        mapFragment.getMapAsync(this)

        title=arguments?.getString("title")
        if(title.equals(getString(R.string.title_danau_toba))){
           rootView.textDescription.text=getString(R.string.danau_toba_description)
            rootView.textAdatIstiadat.text=getString(R.string.danau_toba_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.danau_toba_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.danau_toba_cagar_budaya)
            rootView.textSeni.text=getString(R.string.danau_toba_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.danau_toba_flora_fauna)
        }
        else if(title.equals(getString(R.string.title_sipiso_piso))){
            rootView.textDescription.text=getString(R.string.sipiso_piso_description)
            rootView.textAdatIstiadat.text=getString(R.string.sipiso_piso_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.sipiso_piso_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.sipiso_piso_cagar_budaya)
            rootView.textSeni.text=getString(R.string.sipiso_piso_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.sipiso_piso_flora_fauna)
        }
        else if(title.equals(getString(R.string.title_samosir))){
            rootView.textDescription.text=getString(R.string.samosir_description)
            rootView.textAdatIstiadat.text=getString(R.string.samosir_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.samosir_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.samosir_cagar_budaya)
            rootView.textSeni.text=getString(R.string.samosir_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.samosir_flora_fauna)
        }
        else if(title.equals(getString(R.string.title_danau_linting))){
            rootView.textDescription.text=getString(R.string.danau_linting_description)
            rootView.textAdatIstiadat.text=getString(R.string.danau_linting_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.danau_linting_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.danau_linting_cagar_budaya)
            rootView.textSeni.text=getString(R.string.danau_linting_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.danau_linting_flora_fauna)
        }
        else if(title.equals(getString(R.string.title_istana_maimun))){
            rootView.textDescription.text=getString(R.string.istana_maimun_description)
            rootView.textAdatIstiadat.text=getString(R.string.istana_maimun_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.istana_maimun_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.istana_maimun_cagar_budaya)
            rootView.textSeni.text=getString(R.string.istana_maimun_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.istana_maimun_flora_fauna)
        }
        else if(title.equals(getString(R.string.title_rahmat))){
            rootView.textDescription.text=getString(R.string.rahmat_description)
            rootView.textAdatIstiadat.text=getString(R.string.rahmat_adat_istiadat)
            rootView.textBahasa.text=getString(R.string.rahmat_bahasa)
            rootView.textCagarBudaya.text=getString(R.string.danau_linting_cagar_budaya)
            rootView.textSeni.text=getString(R.string.danau_linting_seni)
            rootView.textPotensiFloraFauna.text=getString(R.string.danau_linting_flora_fauna)
        }

        rootView.findViewById<TextView>(R.id.btnView).setOnClickListener{
            val gmmIntentUri = Uri.parse("https://www.google.co.in/maps/search/"+ title)
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(mapIntent)
        }
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OverviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OverviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onMapReady(p0: GoogleMap?) {
        title=arguments?.getString("title")
        map=p0!!
        var danau_toba:LatLng
        var samosir:LatLng
        var sipiso_piso:LatLng
        var istana_maimun:LatLng
        var danau_linting:LatLng
        var rahmat:LatLng
        danau_toba= LatLng(2.7988759762705047, 98.61464955565482)
        samosir= LatLng(2.651500221878067, 98.79826196056985)
        sipiso_piso= LatLng(2.916733741444678, 98.51950379662551)
        istana_maimun= LatLng(3.5754859723639894, 98.6838249389547)
        danau_linting= LatLng(3.2298340189236083, 98.72573288895349)
        rahmat= LatLng(3.5793902239038093, 98.66751205430083)
        if(title.equals(getString(R.string.title_danau_toba))){
            map.addMarker(MarkerOptions().position(danau_toba).title(getString(R.string.title_danau_toba)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(danau_toba,10F))
        }
        else if (title.equals(getString(R.string.title_sipiso_piso))){
            map.addMarker(MarkerOptions().position(sipiso_piso).title(getString(R.string.title_sipiso_piso)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(sipiso_piso,10F))
        }
        else if(title.equals(getString(R.string.title_samosir))){
            map.addMarker(MarkerOptions().position(samosir).title(getString(R.string.title_samosir)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(samosir,10F))
        }
        else if(title.equals(getString(R.string.title_danau_linting))){
            map.addMarker(MarkerOptions().position(danau_linting).title(getString(R.string.title_danau_linting)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(danau_linting,10F))
        }
        else if(title.equals(getString(R.string.title_istana_maimun))){
            map.addMarker(MarkerOptions().position(istana_maimun).title(getString(R.string.title_istana_maimun)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(istana_maimun,10F))
        }
        else if(title.equals(getString(R.string.title_rahmat))){
            map.addMarker(MarkerOptions().position(rahmat).title(getString(R.string.title_rahmat)))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(rahmat,10F))
        }


    }

    override fun onClick(v: View?) {
        map.mapType=GoogleMap.MAP_TYPE_TERRAIN
    }
}