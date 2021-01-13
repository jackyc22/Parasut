package com.example.parasut

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataEventAdapter internal constructor(var arrayList:MutableList<DataEvent>,var clickListner: onItemClickListner):RecyclerView.Adapter<DataEventAdapter.ViewHolder>(){
    private val Data:List<DataEvent>
    init {
        this.Data=arrayList
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val imageEvent:ImageView =  itemView.findViewById(R.id.imageEvent)
        private val title:TextView = itemView.findViewById(R.id.textTitleEvent)
        private val date:TextView=itemView.findViewById(R.id.textDateEvent)
        private val description:TextView=itemView.findViewById(R.id.textDescriptionEvent)
        fun setDataEvent(data:DataEvent,action:onItemClickListner){
            imageEvent.setImageResource(data.image!!)
            title.text=data.title
            date.text=data.date
            description.text=data.description
            itemView.setOnClickListener{
                action.onItemClick(data,adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return DataEventAdapter.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.card_view_event,
                        parent,
                        false
                )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDataEvent(Data.get(position),clickListner)

    }

    override fun getItemCount(): Int {
        return Data.size
    }
    interface onItemClickListner{
        fun onItemClick(item:DataEvent,position: Int)
    }
}