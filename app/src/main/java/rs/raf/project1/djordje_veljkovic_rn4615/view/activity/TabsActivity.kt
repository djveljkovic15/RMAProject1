package rs.raf.project1.djordje_veljkovic_rn4615.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabs.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.viewPager.TabPagerAdapter

class TabsActivity : AppCompatActivity(R.layout.activity_tabs) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init(){
        initTabs()

    }

    private fun initTabs() {
        tabActivityLayout.setupWithViewPager(viewPagerActivityListe)
        viewPagerActivityListe.adapter = TabPagerAdapter(supportFragmentManager)
    }



}
