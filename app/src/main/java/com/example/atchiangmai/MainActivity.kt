package com.example.atchiangmai

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.atchiangmai.adapters.EventAdapter
import com.example.atchiangmai.adapters.ImageAdapter
import com.example.atchiangmai.adapters.Rcvhor
import com.example.atchiangmai.models.EventData
import com.example.atchiangmai.models.ImageItem
import com.example.atchiangmai.models.RcvhorData
import java.util.UUID


class MainActivity : AppCompatActivity() {



    private lateinit var viewpager2: ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }


    private lateinit var recyclerView: RecyclerView
    private lateinit var rcvhorList: ArrayList<Rcvhor>
    private lateinit var rcvadapter: Rcvhor

    private lateinit var recyclerView2: RecyclerView
    private lateinit var eventList: ArrayList<EventAdapter>
    private lateinit var eventAdapter: EventAdapter
//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ส่วนนี้จะลิ้งไปหน้าฟีด other



        val btnfeed = findViewById<LinearLayout>(R.id.btnfeed)
        btnfeed.setOnClickListener {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
        }

//        val btnotop = findViewById<LinearLayout>(R.id.btnotop)
//        btnotop.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }
//
//        val btnhotel = findViewById<LinearLayout>(R.id.btnhotel)
//        btnhotel.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        val btnfood = findViewById<LinearLayout>(R.id.btn_food)
//        btnfood.setOnClickListener {
//            val intentfood = Intent(this, FoodActivity::class.java)
//            startActivity(intentfood)
//        }
////
//        val btncurr = findViewById<LinearLayout>(R.id.btncurr)
//        btncurr.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }
//
//
//        val btnhosp = findViewById<LinearLayout>(R.id.btnhosp)
//        btnhosp.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }
//
//        val btnpoli = findViewById<LinearLayout>(R.id.btnpoli)
//        btnpoli.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }
//
//        val btnmore = findViewById<LinearLayout>(R.id.btnmore)
//        btnmore.setOnClickListener {
//            val intent = Intent(this, FeedActivity::class.java)
//            startActivity(intent)
//        }

        viewpager2 = findViewById<ViewPager2>(R.id.viewpager2)
        val slideDotll = findViewById<LinearLayout>(R.id.slideDotLL)


        val imageList = arrayListOf(
            ImageItem(

                //ใช้แบบดึงรูปมาจากโฟลเดอร์drawable

                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.cheangdao
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.intanon
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.jdluang
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.kunluang
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.maewang
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + packageName + "/" + R.drawable.mondjam
            )
        )

        //ใช้แบบดึงรูปมาจากเว็บไซต์

//        val imageList = arrayListOf(
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/866/500/500.jpg?hmac=FOptChXpmOmfR5SpiL2pp74Yadf1T_bRhBF1wJZa9hg"
//            )
//        )


        val imageAdapter = ImageAdapter()
        viewpager2.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        val slideDotLL = findViewById<LinearLayout>(R.id.slideDotLL)
        val dotsImage = Array(imageList.size) { ImageView(this) }

        dotsImage.forEach {
            it.setImageResource(
                R.drawable.non_active_dot
            )
            slideDotLL.addView(it, params)
        }

        // default first dot selected
        dotsImage[0].setImageResource(R.drawable.active_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                    if (position == index) {
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                    } else {
                        imageView.setImageResource(R.drawable.non_active_dot)
                    }
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListener)

        //Best thing to do in chiangmai
        recyclerView = findViewById(R.id.Recycleview)
        recyclerView.setHasFixedSize(true)


        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val rcvhorList = ArrayList<RcvhorData>()
        rcvhorList.add(RcvhorData(R.drawable.intanon, "doi intanon"))
        rcvhorList.add(RcvhorData(R.drawable.pong_yang, "Pong Yaeng"))
        rcvhorList.add(RcvhorData(R.drawable.cheangdao, "Chiangdao"))
        rcvhorList.add(RcvhorData(R.drawable.changmaetang, "Chang Maetang"))
        rcvhorList.add(RcvhorData(R.drawable.huynamdang, "Huaynamdang"))

        rcvadapter = Rcvhor(rcvhorList)
        recyclerView.adapter = rcvadapter


//event in chiangmai array
        recyclerView = findViewById(R.id.Recycleview2)
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val eventLis = ArrayList<EventData>()
        eventLis.add(EventData(R.drawable.saun_bor, "suan bor"))
        eventLis.add(EventData(R.drawable.thapae, "ประตูท่าแพ"))
        eventLis.add(EventData(R.drawable.kunluang, "Khunluang"))
        eventLis.add(EventData(R.drawable.maewang, "Maewang"))
        eventLis.add(EventData(R.drawable.grandcan, "Grandcanyon"))

        eventAdapter = EventAdapter(eventLis)
        recyclerView.adapter = eventAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }


}

