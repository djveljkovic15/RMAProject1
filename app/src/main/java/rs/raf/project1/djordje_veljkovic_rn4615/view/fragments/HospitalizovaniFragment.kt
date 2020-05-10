package rs.raf.project1.djordje_veljkovic_rn4615.view.fragments

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.KartonActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.MainActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter.HospitalizacijaPacijentAdapter
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.viewmodel.PacijentViewModel
import timber.log.Timber

@RequiresApi(Build.VERSION_CODES.O)
class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani){


    lateinit var hospitalizacijaPacijentAdapter: HospitalizacijaPacijentAdapter
    val pacijentViewModel : PacijentViewModel by activityViewModels()           //deljen izmedju vise
    // by viewmodels  samo za jednog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MainActivity.MESSAGE_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                data?.let {
                    val pacijent : Pacijent = it.getParcelableExtra<Pacijent>(MainActivity.MESSAGE_KEY) ?:
                    Pacijent(666,"Neuspeli","Pokusaj","he he he",null,null)
                    Timber.e("We got our pacient zero: ${pacijent.ime}")
                    pacijentViewModel.editPacijentHospitalizovani(pacijent)
                }
            }
        }

    }


    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init(){
        initRecycleView()
        initFilter()
        initObservers()
    }

    private fun initFilter() {
        fragmentHospitalizovaniFilterEt.doAfterTextChanged {
            pacijentViewModel.filterHospitalizovaniPacijent(it.toString())
        }

    }

    private fun initObservers() {               // viewLifecycleOwner ,
        pacijentViewModel.getHospitalizovani().observe(viewLifecycleOwner, Observer {
            hospitalizacijaPacijentAdapter.submitList(it)
        })
    }

    private fun initRecycleView() {
        fragmentHospitalizovaniRW.layoutManager = LinearLayoutManager(activity)
        hospitalizacijaPacijentAdapter = HospitalizacijaPacijentAdapter(PacijentDiffItemCallback(),{
            // Mogu i ovde da napravim intent sa context? :thinking:

            //pacijentViewModel.openKarton(pacijent,intent)
            /*val intent = Intent(context, KartonActivity::class.java)
            intent.putExtra("pacijent", it)
            startActivity(intent)
            Timber.e(it.toString())
            */

            val intent = Intent(context, KartonActivity::class.java)
            //intent.putExtra(MESSAGE_KEY, "message")
            intent.putExtra(MainActivity.MESSAGE_KEY, it)
//            intent.putExtra("studentKey", Student())
            startActivityForResult(intent, MainActivity.MESSAGE_REQUEST_CODE)


        },{
            pacijentViewModel.movePacijentToOtpusteni(it)
        })

        fragmentHospitalizovaniRW.adapter = hospitalizacijaPacijentAdapter
    }


}