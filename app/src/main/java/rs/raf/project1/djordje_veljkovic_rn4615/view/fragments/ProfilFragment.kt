package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profil.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.LoginActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.MainActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.ProfilActivity

class ProfilFragment : Fragment(R.layout.fragment_profil){

    lateinit var sharedPreferences : SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    override fun onResume() {
        super.onResume()
        initSharedPref()
    }

    private fun init() {
        initSharedPref()
        initIzmeni()
        initOdjava()
    }

    private fun initSharedPref() {
        sharedPreferences = requireContext().getSharedPreferences(requireContext().packageName, Context.MODE_PRIVATE )

        //R.string.fragmentProfilImeText
        fragmentProfilImeTv.text = sharedPreferences.getString(MainActivity.USERNAME, "")
        fragmentProfilPrezimeTv.text = sharedPreferences.getString(MainActivity.SURNAME, "")
        fragmentProfilBolnicaTv.text = sharedPreferences.getString(MainActivity.HOSPITAL, "")

    }

    private fun initOdjava() {

        fragmentProfilOdjavaBtn.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initIzmeni(){

        fragmentProfilIzmeniBtn.setOnClickListener{
            val intent = Intent(activity, ProfilActivity::class.java)
            startActivity(intent)

        }
    }

}