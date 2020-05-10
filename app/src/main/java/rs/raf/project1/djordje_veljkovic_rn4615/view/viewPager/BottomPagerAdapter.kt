package rs.raf.project1.djordje_veljkovic_rn4615.view.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.project1.djordje_veljkovic_rn4615.view.fragments.ListeFragment
import rs.raf.project1.djordje_veljkovic_rn4615.view.fragments.ProfilFragment
import rs.raf.project1.djordje_veljkovic_rn4615.view.fragments.StanjeFragment
import rs.raf.project1.djordje_veljkovic_rn4615.view.fragments.UnosFragment

class BottomPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object{
        private const val ITEM_COUNT = 4
        const val FRAGMENT_STANJE = 0
        const val FRAGMENT_UNOS = 1
        const val FRAGMENT_LISTE = 2
        const val FRAGMENT_PROFIL = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_STANJE -> StanjeFragment()
            FRAGMENT_UNOS -> UnosFragment()
            FRAGMENT_LISTE -> ListeFragment()
            else -> ProfilFragment()
        }

    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }




}