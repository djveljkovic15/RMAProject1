package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_otpusteni.*
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent

class OtpusteniPacijentViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer{


    fun bind(pacijent : Pacijent){
//        Picasso
//            .get()
//            //.load(pacijent.slika)
//            .load("drawable/face.jpg")
//            .into(recyclerOtpusteniIv)
        recyclerOtpusteniImeTv.text = pacijent.ime
        recyclerOtpusteniPrezimeTv.text = pacijent.prezime
        recyclerOtpusteniVremeTv.text = pacijent.vreme.toString()  // Ovde ubaciti vreme !!!
    }


}