package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel
import timber.log.Timber

class StanjeFragment : Fragment(R.layout.fragment_stanje){

    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        pacijentiCekaonica()
        pacijentiHospitalizacija()
        pacijentiOtpustanje()

        Timber.e("Cekaonica: " + pacijentViewModel.getPacijentiCekaonica().toString())
        Timber.e("Hospitalizacija: " + pacijentViewModel.getPacijentiHospitalizacija().toString())
        Timber.e("Otpusteni: " + pacijentViewModel.getPacijentiOtpusteni().toString())
    }

    private fun pacijentiCekaonica(){
        fragmentStanjeCekaonicaBrTv.text = pacijentViewModel.getPacijentiCekaonica().toString()
    }
    private fun pacijentiHospitalizacija(){
        fragmentStanjeHospitalBrTv.text = pacijentViewModel.getPacijentiHospitalizacija().toString()
    }
    private fun pacijentiOtpustanje(){
        fragmentStanjeOtpustenihBrTv.text = pacijentViewModel.getPacijentiOtpusteni().toString()
    }
}