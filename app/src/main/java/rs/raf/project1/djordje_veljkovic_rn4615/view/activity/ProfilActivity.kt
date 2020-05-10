package rs.raf.project1.djordje_veljkovic_rn4615.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.fragments.ProfilFragment

class ProfilActivity : AppCompatActivity(R.layout.activity_profil) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        saveChanges()
        back()
    }

    private fun back() {

        layoutProfilOdustaniBtn.setOnClickListener {
            val intent = Intent(this, ProfilFragment::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveChanges(){
        layoutProfilIzmeniBtn.setOnClickListener {
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            val editor = sharedPreferences.edit()

            val ime = layoutProfilImeEt.text.toString()
            val prezime = layoutProfilPrezimeEt.text.toString()
            val bolnica = layoutProfilBolnicaEt.text.toString()


            if (ime != "" && prezime != "" && bolnica != "") {
                editor.putString(MainActivity.USERNAME, ime)
                editor.putString(MainActivity.SURNAME, prezime)
                editor.putString(MainActivity.HOSPITAL, bolnica)
                editor.apply()
                finish() //probaj bez
            }

        }
    }
}