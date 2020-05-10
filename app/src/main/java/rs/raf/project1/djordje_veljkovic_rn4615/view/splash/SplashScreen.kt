package rs.raf.project1.djordje_veljkovic_rn4615.view.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.LoginActivity
import rs.raf.project1.djordje_veljkovic_rn4615.view.activity.MainActivity
import timber.log.Timber

public class SplashScreen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }


    private fun init() {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)


        var username : String = sharedPreferences.getString(MainActivity.USERNAME, "")?: ""
        var surname : String = sharedPreferences.getString(MainActivity.SURNAME, "")?: ""
        var pin : String = sharedPreferences.getString(MainActivity.PIN, "")?: ""

        Timber.e(username, surname, pin)
        isLogged(username, surname, pin)


    }

    private fun isLogged(username : String, surname : String, pin : String) {
        if (username.length in 1..11 && surname.length in 1..18 && pin == "1234") {

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra(MainActivity.USERNAME, username)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
            finish()
        }
    }


}