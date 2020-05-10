package rs.raf.project1.djordje_veljkovic_rn4615.application

import android.app.Application
import timber.log.Timber

class Domaci1Application : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}