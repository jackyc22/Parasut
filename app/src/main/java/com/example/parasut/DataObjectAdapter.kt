package com.example.parasut

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataObjectAdapter internal constructor(var arrayList:MutableList<DataObject>, var clickListner: onItemClickListnerObject): RecyclerView.Adapter<DataObjectAdapter.ViewHolder>(){
    private val dataObject:List<DataObject>
    init {
        this.dataObject= arrayList
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private val imageObject:ImageView=itemView.findViewById(R.id.imageObject)
        private val textTitleObject:TextView=itemView.findViewById(R.id.textTitleObject)
        private val textdescriptionObject:TextView= itemView.findViewById(R.id.textDescriptionObject)
        private val textLocationObject:TextView=itemView.findViewById(R.id.textLocationObject)
        private val textStarRatingObject:TextView=itemView.findViewById(R.id.textStartRatingObject)
        fun setObjectData(data:DataObject,action:onItemClickListnerObject)
        {
            imageObject.setImageResource(data.image!!)
            textTitleObject.text=data.title
            textdescriptionObject.text=data.description
            textLocationObject.text=data.location
            textStarRatingObject.text=data.rating
            itemView.setOnClickListener{
                action.onItemClick(data,adapterPosition)
            }
        }

    }

    override fun getItemCount(): Int {
        return dataObject.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setObjectData(dataObject.get(position),clickListner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return DataObjectAdapter.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.card_view_object,
                        parent,
                        false
                )
        )
    }
    interface onItemClickListnerObject{
        fun onItemClick(item:DataObject,position: Int)
    }

}