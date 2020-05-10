package rs.raf.project1.djordje_veljkovic_rn4615.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent

class PacijentDiffItemCallback : DiffUtil.ItemCallback<Pacijent>(){
    override fun areItemsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
       return oldItem.ime==newItem.ime &&
               oldItem.prezime==newItem.prezime &&
               oldItem.simp == newItem.simp &&
               oldItem.slika == newItem.slika

    }


}