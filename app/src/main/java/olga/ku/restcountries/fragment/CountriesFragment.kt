package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_countries.view.*
import kotlinx.coroutines.*
import olga.ku.restcountries.R
import olga.ku.restcountries.adapter.CountriesAdapter
import olga.ku.restcountries.api.RestCountriesService
import olga.ku.restcountries.model.Country

class CountriesFragment : Fragment() {
    private val countriesAdapter = CountriesAdapter { openCountry(it) }

    init {
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_countries, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.ttl_all_countries)
        view.recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = countriesAdapter
        }
        view.buttonError.setOnClickListener { loadCountries() }
        if (countriesAdapter.itemCount > 0) {
            showContent()
        } else {
            loadCountries()
        }
    }

    private fun loadCountries() = CoroutineScope(Dispatchers.IO).launch {
        try {
            withContext(Dispatchers.Main) { showProgress() }
            val response = RestCountriesService.getAll().execute()
            withContext(Dispatchers.Main) { setCountries(response.body()) }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) { showError(e.message) }
        }
    }

    private fun showProgress() = view?.apply {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        layoutError.visibility = View.GONE
    }

    private fun setCountries(countries: Array<Country>?) = countries?.let {
        countriesAdapter.items.addAll(it)
        countriesAdapter.notifyDataSetChanged()
        showContent()
    }

    private fun showContent() = view?.apply {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        layoutError.visibility = View.GONE
    }


    private fun showError(error: String?) = view?.apply {
        textViewError.text = error
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.GONE
        layoutError.visibility = View.VISIBLE
    }

    private fun openCountry(country: Country) {
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment, CountryFragment.newInstance(country))
            ?.addToBackStack(CountryFragment.javaClass.simpleName)
            ?.commit()
    }
}