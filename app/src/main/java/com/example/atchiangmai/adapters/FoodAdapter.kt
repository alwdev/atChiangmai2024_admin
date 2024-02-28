package com.example.atchiangmai.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.atchiangmai.R
import com.example.atchiangmai.models.FoodData

class FoodAdapter(private val foodList: ArrayList<FoodData>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){


    inner class  FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val logores : ImageView = itemView.findViewById(R.id.logores)
        val titlerestaurant : TextView = itemView.findViewById(R.id.titlerestuarant)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodAdapter = foodList[position]
        holder.logores.setImageResource(foodAdapter.logores)
        holder.titlerestaurant.text = foodAdapter.titlerestaurant
    }
}