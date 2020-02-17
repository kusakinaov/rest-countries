package olga.ku.restcountries

import android.app.Application
import olga.ku.restcountries.api.RestCountriesService

class RestCountriesApplication : Application() {
    val restCountriesService = RestCountriesService()

    companion object {
        lateinit var instance: RestCountriesApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}