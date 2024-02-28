package com.example.atchiangmai

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atchiangmai.adapters.FeedAdapter
import com.example.atchiangmai.models.Feed


class FeedActivity : AppCompatActivity() {

    var onItemClick :((Feed) -> Unit)? = null
    private lateinit var recyclerViewfee : RecyclerView
    private lateinit var feedList: ArrayList<Feed>
    private lateinit var feedadapter: FeedAdapter

    private lateinit var recyclerViewact: RecyclerView
    private lateinit var feedactList: ArrayList<FeedAdapter>
    private lateinit var feedactAdapter: FeedAdapter

    private lateinit var recyclerViewrec: RecyclerView
    private lateinit var feedrecList: ArrayList<FeedAdapter>
    private lateinit var feedrecAdapter: FeedAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val backhome = findViewById<TextView>(R.id.backhome)
        backhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //feed array
         recyclerViewfee = findViewById(R.id.RecyclerViewfee)
        recyclerViewfee.setHasFixedSize(true)


        recyclerViewfee.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val feedList = ArrayList<Feed>()
        feedList.add(Feed(R.drawable.intanon, "doi intanon", "This is a beautiful park in Bangkok."))
        feedList.add(Feed(R.drawable.pong_yang, "Pong Yaeng", "This is a beautiful park in Bangkok."))
        feedList.add(Feed(R.drawable.cheangdao, "Chiangdao", "This is a beautiful park in Bangkok."))
        feedList.add(Feed(R.drawable.changmaetang, "Chang Maetang", "This is a beautiful park in Bangkok."))
        feedList.add(Feed(R.drawable.huynamdang, "Huaynamdang", "This is a beautiful park in Bangkok."))

        feedadapter = FeedAdapter(feedList)
        recyclerViewfee.adapter = feedadapter


//activity array
        recyclerViewact = findViewById(R.id.RecyclerViewact)
        recyclerViewact.setHasFixedSize(true)

        recyclerViewact.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val feedactList = ArrayList<Feed>()
        feedactList.add(Feed(R.drawable.saun_bor, "suan bor", "This is a beautiful park in Bangkok."))
        feedactList.add(Feed(R.drawable.thapae, "ประตูท่าแพ", "This is a beautiful park in Bangkok."))
        feedactList.add(Feed(R.drawable.kunluang, "Khunluang", "This is a beautiful park in Bangkok."))
        feedactList.add(Feed(R.drawable.maewang, "Maewang", "This is a beautiful park in Bangkok."))
        feedactList.add(Feed(R.drawable.grandcan, "Grandcanyon", "This is a beautiful park in Bangkok."))

        feedactAdapter = FeedAdapter(feedactList)
        recyclerViewact.adapter = feedactAdapter


    //recoment array
    recyclerViewrec = findViewById(R.id.RecycleViewrec)
    recyclerViewrec.setHasFixedSize(true)

    recyclerViewrec.layoutManager =
    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    val feedrecList = ArrayList<Feed>()
    feedrecList.add(Feed(R.drawable.saun_bor, "suan bor", "This is a beautiful park in Bangkok."))
    feedrecList.add(Feed(R.drawable.thapae, "ประตูท่าแพ", "This is a beautiful park in Bangkok."))
    feedrecList.add(Feed(R.drawable.kunluang, "Khunluang", "This is a beautiful park in Bangkok."))
    feedrecList.add(Feed(R.drawable.maewang, "Maewang", "This is a beautiful park in Bangkok."))
    feedrecList.add(Feed(R.drawable.grandcan, "Grandcanyon", "This is a beautiful park in Bangkok."))

    feedrecAdapter = FeedAdapter(feedrecList)
    recyclerViewrec.adapter = feedrecAdapter

}

}
