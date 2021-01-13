package com.example.parasut

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [categoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class categoryFragment : Fragment(),DataObjectAdapter.onItemClickListnerObject {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var title:String?=null
    lateinit var recylerview:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView=inflater.inflate(R.layout.fragment_category, container, false)
        title=arguments?.getString("title")
        rootView.textTitleCategoryF.text=title
        if(title?.toLowerCase().equals("danau")){
            val dataObject: MutableList<DataObject> = ArrayList()
            dataObject.add(DataObject(R.drawable.lake_toba,  getString(R.string.title_danau_toba), getString(R.string.danau_toba_description_cover), getString(R.string.location_danau_toba), getString(R.string.rate_danau_toba)))
            dataObject.add(DataObject(R.drawable.danau_linting,  getString(R.string.title_danau_linting), getString(R.string.danau_linting_description_cover), getString(R.string.location_danau_linting), getString(R.string.rate_danau_linting)))
            recylerview=rootView.findViewById(R.id.rvObject)
            recylerview.adapter=DataObjectAdapter(dataObject,this)
            recylerview.layoutManager= LinearLayoutManager(activity)
            recylerview.setHasFixedSize(true)

        }

//        textTitleCategoryF.text=title
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment categoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                categoryFragment().apply {
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
}