package olga.ku.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import olga.ku.restcountries.fragment.CountriesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, CountriesFragment())
            .commit()
    }
}
