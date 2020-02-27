package olga.ku.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import olga.ku.restcountries.fragment.CountriesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.addOnBackStackChangedListener {
            val hasFragments = supportFragmentManager.backStackEntryCount > 0
            supportActionBar?.apply {
                setHomeButtonEnabled(hasFragments)
                setDisplayHomeAsUpEnabled(hasFragments)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, CountriesFragment())
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
