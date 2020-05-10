package rs.raf.project1.djordje_veljkovic_rn4615.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.project1.R

class LoginActivity: AppCompatActivity(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        var username : String = sharedPreferences.getString(MainActivity.USERNAME, "")?: ""
        var surname : String = sharedPreferences.getString(MainActivity.SURNAME, "")?: ""
        var hospital : String = sharedPreferences.getString(MainActivity.HOSPITAL, "")?: ""
        var pin : String = sharedPreferences.getString(MainActivity.PIN, "")?: ""


        if(username.length in 1..11 && surname.length in 1..18 && hospital.length in 1..11 && pin == "1234") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(MainActivity.USERNAME,username)
            startActivity(intent)
            finish()
        }
/*
        usernameEt.doAfterTextChanged {
            username = it.toString()
            Timber.e(username)

        }
        passwordEt.doAfterTextChanged {
            surname = it.toString()
            Timber.e(surname)

        }

        pinEt.doAfterTextChanged {
            pin = it.toString()
            Timber.e(pin)

        }

*/
        val editor = sharedPreferences.edit()

        loginBtn.setOnClickListener(){
            username = usernameEt.text.toString()
            surname = surnameEt.text.toString()
            hospital = bolnicaEt.text.toString()
            pin = pinEt.text.toString()

            if(username.length in 1..11 && surname.length in 1..18 && hospital.length in 1..11 && pin == "1234") {

                editor.putString(MainActivity.USERNAME, username)
                editor.putString(MainActivity.SURNAME, surname)
                editor.putString(MainActivity.HOSPITAL, hospital)
                editor.putString(MainActivity.PIN, pin)
                editor.apply()

                startActivity(intent)
                finish()
            }else{

                when {
                    pin.isEmpty() -> {
                        Toast.makeText(this, "Pin ne sme biti prazan!", Toast.LENGTH_SHORT).show()
                    }
                    pin.length!=4 -> {
                        Toast.makeText(this, "Pin mora biti duzine od 4 cifre!", Toast.LENGTH_SHORT).show()
                    }
                    pin != "1234" -> {
                        Toast.makeText(this, "Pin nije postojec!", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this, "Pogresno uneti podaci!", Toast.LENGTH_SHORT).show()
                    }
                }

            }

            /*
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra(MainActivity.USERNAME,username)
            startActivity(intent)
            finish()
*/
        }
    }
}