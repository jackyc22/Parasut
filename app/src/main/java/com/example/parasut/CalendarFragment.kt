package com.example.parasut

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment(),DataEventAdapter.onItemClickListner {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvJuli:RecyclerView
    private lateinit var rvAgustus:RecyclerView
    private lateinit var rvNovember: RecyclerView

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
        val rootView= inflater.inflate(R.layout.fragment_calendar, container, false)
        //July
        val DataJul: MutableList<DataEvent> = ArrayList()
        DataJul.add(DataEvent(R.drawable.karnaval_danau_toba,getString(R.string.title_event_danautoba),getString(R.string.date_karnaval_danautoba),getString(R.string.dec_karnaval_danautoba)))
        rvJuli=rootView.findViewById(R.id.rvEventJuli)
        rvJuli.adapter=DataEventAdapter(DataJul,this)
        rvJuli.layoutManager= LinearLayoutManager(activity)
        //Agustus
        val DataAgs: MutableList<DataEvent> = ArrayList()
        DataAgs.add(DataEvent(R.drawable.samosir_music_internasional,getString(R.string.title_event_samosir),getString(R.string.date_samosir_music_internasional),getString(R.string.dec_samosir_music_internasional)))
        rvAgustus=rootView.findViewById(R.id.rvEventAgustus)
        rvAgustus.adapter=DataEventAdapter(DataAgs,this)
        rvAgustus.layoutManager= LinearLayoutManager(activity)
        //November
        val DataNov: MutableList<DataEvent> = ArrayList()
        DataNov.add(DataEvent(R.drawable.gemes,getString(R.string.title_event_gemes),getString(R.string.date_gemes),getString(R.string.dec_gemes)))
        DataNov.add(DataEvent(R.drawable.nias_festival,getString(R.string.title_event_nias),getString(R.string.date_festivalnias),getString(R.string.dec_festival_nias)))
        rvNovember=rootView.findViewById(R.id.rvEventNovember)
        rvNovember.adapter=DataEventAdapter(DataNov,this)
        rvNovember.layoutManager= LinearLayoutManager(activity)

        return rootView

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClick(item: DataEvent, position: Int) {
        var intent=Intent(context,Event::class.java)
        intent.putExtra("TITLE",item.title)
        intent.putExtra("DATE",item.date)
        startActivity(intent)
    }
}