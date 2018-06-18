package eu.execom.android.hawaii.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class HawaiiApplication() : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}