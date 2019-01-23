package program.sample.praveen.view_pager_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerTabStrip
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.TextView
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer

/**
 * Created by Praveen John on 23,January,2019
 */

class MainActivity : AppCompatActivity() {
    internal var adapterViewPager: FragmentPagerAdapter? = null
    var pagerstrip: PagerTabStrip? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instance = this
        val mViewPager = findViewById(R.id.view_Pager) as ViewPager
        pagerstrip = findViewById(R.id.pager_header) as PagerTabStrip
        adapterViewPager = MyPagerAdapter(supportFragmentManager)
        mViewPager.adapter = adapterViewPager
        mViewPager.setPageTransformer(true, CubeOutTransformer())
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {


            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        MainActivity.instance?.titlechange("Contacts")
                    }

                    1 -> {
                        MainActivity.instance?.titlechange("Inbox")
                    }
                    2 -> {
                        MainActivity.instance?.titlechange("Compose")
                    }

                    else -> Log.d("test", "onPageSelected: $position")
                }

            }


        })
    }

    class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {


        override fun getCount(): Int {
            return NUM_ITEMS
        }


        override fun getItem(position: Int): Fragment {
            when (position) {
                0 ->

                    return FirstFragment.newInstance(0, "Contacts")

                1 ->

                    return SecondFragment.newInstance(1, "Inbox")
                2 ->

                    return ThirdFragment.newInstance(2, "Compose")
                else -> {
                    MainActivity.instance?.titlechange("My Application")
                    return FirstFragment.newInstance(0, "Contacts")
                }
            }
        }


        override fun getPageTitle(position: Int): CharSequence? {

            when (position) {
                0 ->

                    return "Contacts"

                1 ->

                    return "Inbox"

                2 ->

                    return "Compose"
            }

            return "Contacts"
        }

        companion object {
            private val NUM_ITEMS = 3//Specify the number of pages
        }


    }

    //Pass your title in this method to Change the title
    fun titlechange(text: String) {
        var tv = findViewById(R.id.top_title) as TextView
        tv.setText("")
        tv.setText(text)
    }

    companion object {
        var instance: MainActivity? = null
    }

}
