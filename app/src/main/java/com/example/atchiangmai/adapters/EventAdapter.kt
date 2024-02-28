package com.example.atchiangmai.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atchiangmai.R
import com.example.atchiangmai.models.EventData

class EventAdapter(private val eventList: ArrayList<EventData>): RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.eventhor,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val eventAdapter = eventList[position]
        holder.imageView.setImageResource(eventAdapter.eventimage)
        holder.textView.text = eventAdapter.eventtitle
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.eventimage)
        val  textView : TextView = itemView.findViewById(R.id.eventtitle)
    }
}

private fun ImageView.setImageResource(imagetodo: String) {

}