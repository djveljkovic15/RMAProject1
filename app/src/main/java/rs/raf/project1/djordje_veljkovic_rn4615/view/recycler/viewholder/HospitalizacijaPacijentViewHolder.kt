package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_hospitalizacija.*
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent

class HospitalizacijaPacijentViewHolder(override val containerView: View,
                                        onKartonClicked:(Int)->Unit,
                                        onOtpustClicked:(Int)->Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    init {
        recyclerHospitalizacijaKartonBtn.setOnClickListener {
            onKartonClicked.invoke(adapterPosition)
        }
        recyclerHospitalizacijaOtpustBtn.setOnClickListener {
            onOtpustClicked.invoke(adapterPosition)
        }
    }

    fun bind(pacijent : Pacijent){
//        Picasso
//            .get()
//            //.load(pacijent.slika)
//            .load("drawable/face.jpg")
//            .into(recyclerHospitalizacijaIv)
        recyclerHospitalizacijaImeTv.text = pacijent.ime
        recyclerHospitalizacijaPrezimeTv.text = pacijent.prezime
    }


}