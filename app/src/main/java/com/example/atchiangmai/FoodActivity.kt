package com.example.atchiangmai

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atchiangmai.adapters.FoodAdapter
import com.example.atchiangmai.models.FoodData

class FoodActivity : AppCompatActivity() {


    private lateinit var recyclerViewfood: RecyclerView
    private lateinit var foodList: ArrayList<FoodData>
    private lateinit var foodadapter: FoodAdapter

//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val backhome = findViewById<TextView>(R.id.foodbackhome)
        backhome.setOnClickListener { val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        }

        //feed array
        recyclerViewfood = findViewById(R.id.RecyclerViewfood)
        recyclerViewfood.setHasFixedSize(true)


        recyclerViewfood.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val foodList = ArrayList<FoodData>()
        foodList.add(FoodData(R.drawable.intanon, "doi intanon",))
        foodList.add(FoodData(R.drawable.pong_yang, "Pong Yaeng",))
        foodList.add(FoodData(R.drawable.cheangdao, "Chiangdao",))
        foodList.add(FoodData(R.drawable.changmaetang, "Chang Maetang",))
        foodList.add(FoodData(R.drawable.huynamdang, "Huaynamdang",))

        foodadapter = FoodAdapter(foodList)
        recyclerViewfood.adapter = foodadapter


    }
}