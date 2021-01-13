package com.example.parasut

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataCategoryAdapter internal constructor(
    Data:MutableList<DataCategory>,
  var  clickListener:onItemClickCategory
): RecyclerView.Adapter<DataCategoryAdapter.ViewHolder>(){

    private val Data:List<DataCategory>
    init{
        this.Data = Data
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val imageCategory:ImageView= itemView.findViewById(R.id.imageCategory)
        private val title:TextView= itemView.findViewById(R.id.textTitleCategory)
        fun setLocationData(data:DataCategory,action:onItemClickCategory){
            imageCategory.setImageResource(data.image)
            title.setText(data.title)
            itemView.setOnClickListener{
                action.onItemClick(data,adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return Data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_category,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setLocationData(Data.get(position),clickListener)
    }
    interface onItemClickCategory{
        fun onItemClick(item: DataCategory, position: Int)
    }
}