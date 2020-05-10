package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter.CekaonicaPacijentAdapter
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel

@RequiresApi(Build.VERSION_CODES.O)
class CekaonicaFragment : Fragment(R.layout.fragment_cekaonica){

    lateinit var cekaonicaPacijentAdapter: CekaonicaPacijentAdapter
    val pacijentViewModel : PacijentViewModel by activityViewModels()           //deljen izmedju vise
                                                                                // by viewmodels  samo za jednog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init(){
        initRecycleView()
        initFilter()
        initObservers()
    }

    private fun initFilter() {
        fragmentCekaonicaFilterEt.doAfterTextChanged {
            pacijentViewModel.filterCekaonicaPacijent(it.toString())
        }

    }

    private fun initObservers() {               // viewLifecycleOwner ,
       pacijentViewModel.getCekaonica().observe(viewLifecycleOwner, Observer {
           cekaonicaPacijentAdapter.submitList(it)
       })
    }

    private fun initRecycleView() {
        fragmentCekaonicaRW.layoutManager = LinearLayoutManager(activity)
        cekaonicaPacijentAdapter = CekaonicaPacijentAdapter(PacijentDiffItemCallback(), {
            pacijentViewModel.removePacijentCekaonica(it)
           // val intent = Intent(context, KartonActivity::class.java)
        },{
            pacijentViewModel.movePacijentToHospitalizovani(it)
        })
        fragmentCekaonicaRW.adapter = cekaonicaPacijentAdapter
    }



}