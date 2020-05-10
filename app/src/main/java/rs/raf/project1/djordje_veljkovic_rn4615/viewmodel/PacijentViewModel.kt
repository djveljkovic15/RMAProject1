package rs.raf.project1.djordje_veljkovic_rn4615.viewmodel

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.project1.djordje_veljkovic_rn4615.model.Pacijent
import timber.log.Timber
import java.time.LocalDate
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
class PacijentViewModel : ViewModel(){

    private val cekaonicaList : MutableList<Pacijent> = mutableListOf(
        Pacijent(2, "Pera", "Peric",
            "Pera peric dosao da pera peric",
            " https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png",
            LocalDate.parse("2015-05-05")),

           Pacijent( 5, "Mika", "Mikic",
            "Mika mikic dosao da mika mikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
            //"https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 10, "Laza", "Lazic",
            "Laza lazic dosao da laza lazic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05"))
            //"https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png")

        )

    private val hospitalizovaniList : MutableList<Pacijent> = mutableListOf(
        Pacijent(7, "Zika", "Zikic",
            "Zika Zikic dosao da Zika Zikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
          //  "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 12, "Pika", "Pikic",
            "Pika Pikic dosao da Pika Pikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
         //   "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 15, "Sika", "Sikic",
            "Sika Sikic dosao da Sik Sikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05"))
         //   "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png")
    )

    private val otpusteniList : MutableList<Pacijent> = mutableListOf(
        Pacijent(21, "Draga", "Dragic",
            "Zika Zikic dosao da Zika Zikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
          //  "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 24, "Pika", "Pikic",
            "Pika Pikic dosao da Pika Pikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
         //   "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 27, "Sika", "Sikic",
            "Sika Sikic dosao da Sik Sikic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05")),
          //  "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png"),
        Pacijent( 30, "Laza", "Lazic",
            "Laza lazic dosao da laza lazic",
            "drawable/face.jpg",
            LocalDate.parse("2015-05-05"))
          //  "https://www.pngitem.com/pimgs/m/33-332378_boy-boy-face-icon-png-transparent-png.png")
    )



    private val cekaonica : MutableLiveData<List<Pacijent>> = MutableLiveData()

    private val hospitalizovani : MutableLiveData<List<Pacijent>> = MutableLiveData()

    private val otpusteni : MutableLiveData<List<Pacijent>> = MutableLiveData()

    init {
        initCekaonica()
        initHospitalizovani()
        initOtpusteni()
    }
    private fun initCekaonica(){
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekaonicaList)
        cekaonica.value = listToSubmit
    }
    private fun initOtpusteni(){
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(otpusteniList)
        otpusteni.value = listToSubmit
    }
    private fun initHospitalizovani(){
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospitalizovaniList)
        hospitalizovani.value = listToSubmit
    }
    fun getCekaonica() : LiveData<List<Pacijent>>{
        return cekaonica
    }
    fun getHospitalizovani() : LiveData<List<Pacijent>>{
        return hospitalizovani
    }
    fun getOtpusteni() : LiveData<List<Pacijent>>{
        return otpusteni
    }
    fun filterCekaonicaPacijent(filter: String){
        val filteredList = cekaonicaList.filter{
            it.ime.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().startsWith(filter.toLowerCase())
        }
        cekaonica.value = filteredList

    }
    fun filterHospitalizovaniPacijent( filter: String){
        val filteredList = hospitalizovaniList.filter{
            it.ime.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().startsWith(filter.toLowerCase())
        }
        hospitalizovani.value = filteredList

    }

    fun addPacijent(ime:String, prezime:String, simp: String){ //
        val pacijent = Pacijent(
            Random.nextInt(1,99999),
            ime,
            prezime,
            simp,
            //null
            "drawable/face.jpg",
            LocalDate.parse("2020-05-05") //.now() da lupi sdasnje

        // ubaciti vreme

        )
        cekaonicaList.add(pacijent)
        initCekaonica()
    }

    fun removePacijentCekaonica(pacijent: Pacijent){
        cekaonicaList.remove(pacijent)
        initCekaonica()
    }

    fun removePacijentHospitalizovani(pacijent: Pacijent){
        hospitalizovaniList.remove(pacijent)
        initHospitalizovani()
    }
    fun movePacijentToHospitalizovani(pacijent: Pacijent){
        pacijent.vreme = LocalDate.now()//LocalDateTime.now()
        hospitalizovaniList.add(pacijent)
        initHospitalizovani()
        removePacijentCekaonica(pacijent)

    }
    fun openKarton(pacijent: Pacijent,intent: Intent){  // Nema smisla da ovde pozivam ContextCompat.startActivity()

        // REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE

    }
    fun editPacijentHospitalizovani(pacijent: Pacijent){
         /*hospitalizovaniList.find {
            it.id == pacijent.id
        }?.apply {
            this.ime = pacijent.ime
            this.prezime = pacijent.prezime
            this.simp = pacijent.simp
        }*/

        hospitalizovaniList.removeAll {
            it.id == pacijent.id
        }
        hospitalizovaniList.add(pacijent)


        Timber.e("PVW: $pacijent")
        Timber.e("PVW: $hospitalizovaniList")
        //initHospitalizovani()

        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospitalizovaniList)
        hospitalizovani.value = listToSubmit
    }
    fun movePacijentToOtpusteni(pacijent: Pacijent){
        pacijent.vreme = LocalDate.now()
        otpusteniList.add(pacijent)
        initOtpusteni()
        removePacijentHospitalizovani(pacijent)

    }

    fun getPacijentiCekaonica(): Int {
        return cekaonicaList.size
    }
    fun getPacijentiHospitalizacija(): Int {
        return hospitalizovaniList.size
    }
    fun getPacijentiOtpusteni(): Int {
        return otpusteniList.size
    }





}