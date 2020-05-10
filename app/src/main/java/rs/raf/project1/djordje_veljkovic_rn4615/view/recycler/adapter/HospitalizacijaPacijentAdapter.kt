package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder.HospitalizacijaPacijentViewHolder

class HospitalizacijaPacijentAdapter(pacijentDiffItemCallback: PacijentDiffItemCallback,
                                     val onKartonClicked:(Pacijent)->Unit,
                                     val onOtpustClicked:(Pacijent)->Unit) : ListAdapter<Pacijent,
        HospitalizacijaPacijentViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizacijaPacijentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_hospitalizacija, parent, false)
        return HospitalizacijaPacijentViewHolder(view, {
            val pacijent = getItem(it)
            onKartonClicked.invoke(pacijent)

        },{
            val pacijent = getItem(it)
            onOtpustClicked.invoke(pacijent)

        })
    }

    override fun onBindViewHolder(holder: HospitalizacijaPacijentViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}