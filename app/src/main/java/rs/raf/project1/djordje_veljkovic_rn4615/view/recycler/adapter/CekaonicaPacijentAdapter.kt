package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder.CekaonicaPacijentViewHolder

class CekaonicaPacijentAdapter(pacijentDiffItemCallback: PacijentDiffItemCallback,
                               val onZdravClicked: (Pacijent)->Unit,
                               val onHospitalizacijaClicked:(Pacijent)->Unit) : ListAdapter<Pacijent,
        CekaonicaPacijentViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CekaonicaPacijentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_cekaonica, parent, false)
        return CekaonicaPacijentViewHolder(view, {  // hvala drazo :)
            val pacijent = getItem(it)
                onZdravClicked.invoke(pacijent)
        },{
            val pacijent = getItem(it)
            onHospitalizacijaClicked.invoke(pacijent)
        })


    }

    override fun onBindViewHolder(holder: CekaonicaPacijentViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}