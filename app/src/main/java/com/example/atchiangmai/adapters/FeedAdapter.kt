package com.example.atchiangmai.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atchiangmai.R
import com.example.atchiangmai.models.Feed

class FeedAdapter(private val feedList: ArrayList<Feed>): RecyclerView.Adapter<FeedAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.feed,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return feedList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val feedAdapter = feedList[position]
        holder.imageView.setImageResource(feedAdapter.feedimage)
        holder.textView.text = feedAdapter.feedtitle
        holder.textView.text = feedAdapter.feeddes
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.feedimage)
        val  textView : TextView = itemView.findViewById(R.id.feedtitle)
        val  desView : TextView = itemView.findViewById(R.id.feeddes)
    }
}

private fun ImageView.setImageResource(image: String) {

}