package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recycler_cekaonica.*
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent

class CekaonicaPacijentViewHolder(override val containerView: View,
                                  onZdravClicked: (Int)->Unit,
                                  onHospitalizacijaClicked:(Int)->Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{


    init {
        recyclerCekaonicaZdravBtn.setOnClickListener {
            onZdravClicked.invoke(adapterPosition)
        }
        recyclerCekaonicaHospBtn.setOnClickListener {
            onHospitalizacijaClicked.invoke(adapterPosition)
        }
    }


    fun bind(pacijent : Pacijent){
//        Picasso
//            .get()
//            //.load("drawable/face.jpg")
//            .load(pacijent.slika)
//            .into(recyclerCekaonicaIv)
        recyclerCekaonicaImeTv.text = pacijent.ime
        recyclerCekaonicaPrezimeTv.text = pacijent.prezime
        recyclerCekaonicaSimpTv.text = pacijent.simp
    }


}