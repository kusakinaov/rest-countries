package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_countries.view.*
import olga.ku.restcountries.R
import olga.ku.restcountries.RestCountriesApplication
import olga.ku.restcountries.adapter.CountriesAdapter
import olga.ku.restcountries.adapter.OnCountryClickListener
import olga.ku.restcountries.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountriesFragment : Fragment() {
    val countriesAdapter = CountriesAdapter(object : OnCountryClickListener {
        override fun onCountryClick(country: Country) {
            view?.let { Snackbar.make(it, country.name.toString(), Snackbar.LENGTH_SHORT).show() }
        }
    })

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

        RestCountriesApplication.instance.restCountriesService.getAll().enqueue(object :
            Callback<Array<Country>> {
            override fun onFailure(call: Call<Array<Country>>, t: Throwable) {
                t.message?.let {
                    Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(
                call: Call<Array<Country>>,
                response: Response<Array<Country>>
            ) {
                response.body()?.let {
                    countriesAdapter.items.addAll(it)
                    countriesAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}