package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_country.view.*
import olga.ku.restcountries.R
import olga.ku.restcountries.model.Country

class CountryFragment : Fragment() {
    var country: Country? = null

    companion object {
        const val COUNTRY = "country"
        fun newInstance(country: Country) = CountryFragment().apply {
            arguments = Bundle().apply { putSerializable(COUNTRY, country) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_country, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            country = it.getSerializable(COUNTRY) as Country
            country?.let {
                view.textViewName.text = it.name
            }
        }
    }
}