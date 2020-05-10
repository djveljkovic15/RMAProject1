package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_liste.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.viewPager.TabPagerAdapter

class ListeFragment : Fragment(R.layout.fragment_liste){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    private fun init() {
        initTabs()
//        val intent = Intent(context, TabsActivity::class.java)
//        startActivity(intent)
//        initFragment()

    }



    private fun initTabs() {
        viewPagerListe.adapter = TabPagerAdapter(childFragmentManager)
        tabFragmentLayout.setupWithViewPager(viewPagerListe)

    }

}
