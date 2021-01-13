package com.example.parasut

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.flaviofaria.kenburnsview.KenBurnsView
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_container_top.view.*

class TravelLocationAdapter internal constructor(
    travelLocations: MutableList<TravelLocation>,
    viewPager2: ViewPager2,
var clickListener:onItemClickObjectTop
) :RecyclerView.Adapter<TravelLocationAdapter.TravelViewHolder>() {

    private val travelLocations:List<TravelLocation>
    private val viewPager2:ViewPager2
    init{
        this.travelLocations=travelLocations
        this.viewPager2=viewPager2
    }
    class TravelViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private val kbvLocation: KenBurnsView = itemView.findViewById(R.id.kbvLocation)
        private val textTitle:TextView = itemView.findViewById(R.id.textTitle)
        private val textLocation:TextView = itemView.findViewById(R.id.textLocation)
        private val textStarRating:TextView=itemView.findViewById(R.id.textStartRating)

        fun setLocationData(travelLocation:TravelLocation,action:onItemClickObjectTop){
            Picasso.get().load(travelLocation.imageUrl).into(kbvLocation)
            textTitle.setText(travelLocation.title)
            textLocation.setText(travelLocation.location)
            textStarRating.setText((travelLocation.starRating).toString())
            itemView.setOnClickListener{
                action.onItemClick(travelLocation,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        return TravelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_container_top,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        holder.setLocationData(travelLocations.get(position),clickListener)
        if(position == travelLocations.size - 2){
            viewPager2.post(runnable)
        }
    }
    override fun getItemCount(): Int {
        return travelLocations.size
    }
    private val runnable = Runnable {
        travelLocations.addAll(travelLocations)
        notifyDataSetChanged()
    }
    interface onItemClickObjectTop{
        fun onItemClick(item:TravelLocation, position: Int)
    }

}
