package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_unos.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel

@RequiresApi(Build.VERSION_CODES.O)
class UnosFragment : Fragment(R.layout.fragment_unos){

    private val pacijentViewModel : PacijentViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        addPacijent()
    }

    private fun addPacijent(){
        fragmentUnosBtn.setOnClickListener{

            val ime = fragmentUnosImeET.text.toString()
            val prezime = fragmentUnosPrezimeET.text.toString()
            val simp = fragmentUnosSimpET.text.toString()

            if(ime!="" && prezime!="" && simp != "") {
                pacijentViewModel.addPacijent(ime,prezime,simp)
                fragmentUnosImeET.text.clear()
                fragmentUnosPrezimeET.text.clear()
                fragmentUnosSimpET.text.clear()
                Toast.makeText(context,"uspesno dodat pacijent", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "greska", Toast.LENGTH_SHORT).show()
            }

        }
    }

}