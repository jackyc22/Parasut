package com.example.parasut

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageSliderAdapter internal constructor(
    var arrayList:MutableList<ImageSlider>
):RecyclerView.Adapter<ImageSliderAdapter.SliderAdapter>(){
    private val imageSlider:List<ImageSlider>
    init {
        this.imageSlider= arrayList
    }
    class SliderAdapter(itemView:View):RecyclerView.ViewHolder(itemView){
        private var image:ImageView=itemView.findViewById(R.id.imageSliderObject)
        fun setImageSlider(data:ImageSlider)
        {
            image.setImageResource(data.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderAdapter {
        return SliderAdapter(LayoutInflater.from(parent.context).inflate(R.layout.image_slider_object,parent,false))
    }

    override fun onBindViewHolder(holder: SliderAdapter, position: Int) {
        holder.setImageSlider(imageSlider.get(position))
    }

    override fun getItemCount(): Int {
        return imageSlider.size
    }

}