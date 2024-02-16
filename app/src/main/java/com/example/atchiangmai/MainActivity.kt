package com.example.atchiangmai

import com.example.atchiangmai.adapters.ImageAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
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
//            ),
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/270/500/500.jpg?hmac=MK7XNrBrZ73QsthvGaAkiNoTl65ZDlUhEO-6fnd-ZnY"
//            ),
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/320/500/500.jpg?hmac=2iE7TIF9kIqQOHrIUPOJx2wP1CJewQIZBeMLIRrm74s"
//            ),
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/798/500/500.jpg?hmac=Bmzk6g3m8sUiEVHfJWBscr2DUg8Vd2QhN7igHBXLLfo"
//            ),
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/95/500/500.jpg?hmac=0aldBQ7cQN5D_qyamlSP5j51o-Og4gRxSq4AYvnKk2U"
//            ),
//            ImageItem(
//                UUID.randomUUID().toString(),
//                "https://fastly.picsum.photos/id/778/500/500.jpg?hmac=jZLZ6WV_OGRxAIIYPk7vGRabcAGAILzxVxhqSH9uLas"
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
    }

    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
    }
}


