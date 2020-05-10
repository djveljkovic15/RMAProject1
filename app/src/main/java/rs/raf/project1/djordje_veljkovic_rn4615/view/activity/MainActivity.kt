package rs.raf.project1.djordje_veljkovic_rn4615.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.viewPager.BottomPagerAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object { // Da li stvarno hocu da drzim ovde?
        const val USERNAME = "username"
        const val SURNAME = "surname"
        const val HOSPITAL = "hospital"
        const val PIN = "pin"
        const val MESSAGE_KEY = "1"
        const val MESSAGE_REQUEST_CODE = 2

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }

    private fun init(){
        initViewPager()
        initNavigation()
       //        initTabs()

    }

//    private fun initTabs() {
//        viewPagerListe.adapter = TabPagerAdapter(supportFragmentManager)
//        tabLayout.setupWithViewPager(viewPagerListe)
//    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_1 -> {
                    viewPager.setCurrentItem(BottomPagerAdapter.FRAGMENT_STANJE, false)
                }

                R.id.navigation_2 -> {
                    viewPager.setCurrentItem(BottomPagerAdapter.FRAGMENT_UNOS, false)
                }

                R.id.navigation_3 -> {
                    viewPager.setCurrentItem(BottomPagerAdapter.FRAGMENT_LISTE, false)
                }

                R.id.navigation_4 -> {
                    viewPager.setCurrentItem(BottomPagerAdapter.FRAGMENT_PROFIL, false)
                }

            }
            true
        }


    }

    private fun initViewPager() {
      viewPager.adapter = BottomPagerAdapter(supportFragmentManager)
    }


}
