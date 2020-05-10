package rs.raf.project1.djordje_veljkovic_rn4615.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_karton.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel
import timber.log.Timber

@RequiresApi(Build.VERSION_CODES.O)
class KartonActivity() : AppCompatActivity(R.layout.activity_karton){


    val pacijentViewModel: PacijentViewModel  by viewModels()
        //PacijentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        init()
    }
    private fun init() {
//        val pacijent : Pacijent= intent.getSerializableExtra("pacijent") as Pacijent
        val pacijent: Pacijent?
        intent?.let {
            pacijent  = it.getParcelableExtra(MainActivity.MESSAGE_KEY)

            Timber.e(pacijent.ime)
            saveChanges(pacijent)
            popuni(pacijent)
        }
        back()
    }

    private fun popuni(pacijent: Pacijent) {
        activityKartonImeEt.setText(pacijent.ime)
        activityKartonPrezimeEt.setText(pacijent.prezime)
        activityKartonSppEt.setText(pacijent.simp)
        //activityKartonTsEt
        activityKartonDatumTv.text = pacijent.vreme.toString()

    }

    private fun back() {

        activityKartonOdustaniBtn.setOnClickListener {//Da li mogu da bacim samo finish() ?
            finish()
        }
    }

    private fun saveChanges(pacijent: Pacijent){
        activityKartonIzmeniBtn.setOnClickListener {
//            val pacijent : Pacijent= intent.getSerializableExtra("pacijent") as Pacijent

            val ime = activityKartonImeEt.text.toString()
            val prezime = activityKartonPrezimeEt.text.toString()
            val stanjePriPrijemu = activityKartonSppEt.text.toString()
            val trenutnoStanje = activityKartonTsEt.text.toString()

            if (ime != "" && prezime != "" && stanjePriPrijemu != "" && trenutnoStanje!="") {
                pacijent.ime=ime
                pacijent.prezime=prezime
                pacijent.simp= trenutnoStanje   //"$stanjePriPrijemu - $trenutnoStanje"
               // pacijentViewModel.editPacijentHospitalizovani(pacijent)
                Timber.e(pacijent.toString())
                //finish() //probaj bez
                val returnIntent = Intent()
                returnIntent.putExtra(MainActivity.MESSAGE_KEY, pacijent)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()

            }

        }
    }
}