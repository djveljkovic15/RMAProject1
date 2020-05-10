package rs.raf.project1.djordje_veljkovic_rn4615.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class Pacijent (
    var id: Int,
    var ime: String,
    var prezime : String,
    var simp: String,
    var slika: String?,
    var vreme: LocalDate?
    //ubaciti vreme

): Parcelable //Serializable