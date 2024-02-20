package com.example.atchiangmai

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.atchiangmai.adapters.ImageAdapter
import com.example.atchiangmai.adapters.Rcvhor
import com.example.atchiangmai.models.ImageItem
import java.util.UUID


class MainActivity : AppCompatActivity() {

    private lateinit var viewpager2 : ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8,0,8,0)
    }


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:Rcvhor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





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
            slideDotLL.addView(it,params)
        }

        // default first dot selected
        dotsImage[0].setImageResource(R.drawable.active_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                    if (position == index){
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                    }else{
                        imageView.setImageResource(R.drawable.non_active_dot)
                    }
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListener)

        recyclerView = findViewById(R.id.Recycleview)
        adapter = Rcvhor()

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

//        todoList = ArrayList()

        recyclerView.adapter = adapter
    }


    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }


}