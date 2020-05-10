package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_otpusteni.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter.OtpusteniPacijentAdapter
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel

@RequiresApi(Build.VERSION_CODES.O)
class OtpusteniFragment : Fragment(R.layout.fragment_otpusteni){

    lateinit var otpusteniPacijentAdapter: OtpusteniPacijentAdapter
    val pacijentViewModel : PacijentViewModel by activityViewModels()           //deljen izmedju vise
    // by viewmodels  samo za jednog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init(){
        initRecycleView()
        initObservers()
    }


    private fun initObservers() {               // viewLifecycleOwner ,
        pacijentViewModel.getOtpusteni().observe(viewLifecycleOwner, Observer {
            otpusteniPacijentAdapter.submitList(it)
        })
    }

    private fun initRecycleView() {
        fragmentOtpusteniRW.layoutManager = GridLayoutManager(activity, 2)
        otpusteniPacijentAdapter = OtpusteniPacijentAdapter(PacijentDiffItemCallback())

        fragmentOtpusteniRW.adapter = otpusteniPacijentAdapter
    }


}