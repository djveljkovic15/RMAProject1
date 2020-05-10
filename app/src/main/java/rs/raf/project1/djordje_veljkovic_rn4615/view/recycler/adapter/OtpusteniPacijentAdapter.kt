package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.project1.R
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.viewholder.OtpusteniPacijentViewHolder

class OtpusteniPacijentAdapter(pacijentDiffItemCallback:PacijentDiffItemCallback): ListAdapter<Pacijent,
       OtpusteniPacijentViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtpusteniPacijentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_otpusteni, parent, false)
        return OtpusteniPacijentViewHolder(view)


    }

    override fun onBindViewHolder(holder: OtpusteniPacijentViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}