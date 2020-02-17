package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_countries.view.*
import olga.ku.restcountries.R
import olga.ku.restcountries.adapter.CountriesAdapter

class CountriesFragment : Fragment() {
    val countriesAdapter = CountriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_countries, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = countriesAdapter
        }
    }
}