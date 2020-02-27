package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_country.view.*
import olga.ku.restcountries.R
import olga.ku.restcountries.model.Country
import olga.ku.restcountries.model.Currency
import olga.ku.restcountries.model.Language
import olga.ku.restcountries.model.RegionalBloc

class CountryFragment : Fragment() {
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
        arguments?.apply { setCountry(getSerializable(COUNTRY) as Country) }
    }

    private fun setCountry(country: Country) {
        activity?.title = country.name
        view?.apply {
            textViewName.text = country.name
            textViewDomain.text = country.topLevelDomain?.joinToString(separator = ", ")
            textViewAlpha2Code.text = country.alpha2Code
            textViewAlpha3Code.text = country.alpha3Code
            textViewCallingCodes.text = country.callingCodes?.joinToString(separator = ", ")
            textViewCapital.text = country.capital
            textViewAltSpellings.text = country.altSpellings?.joinToString(separator = ", ")
            textViewRegion.text = country.region
            textViewSubRegion.text = country.subregion
            textViewPopulation.text = country.population?.toString()
            textViewLatLon.text = country.latlng?.joinToString(", ") { d -> d.toString() }
            textViewDemonym.text = country.demonym
            textViewArea.text = country.area?.toString()
            textViewGini.text = country.gini?.toString()
            textViewTimezones.text = country.timezones?.joinToString(separator = ", ")
            textViewBorders.text = country.borders?.joinToString(separator = ", ")
            textViewNativeName.text = country.nativeName
            textViewNumericCode.text = country.numericCode
            textViewCurrencies.text =
                country.currencies?.joinToString(separator = "\n") { currency -> currency.fullLine() }
            textViewLanguages.text =
                country.languages?.joinToString(separator = "\n") { language -> language.fullLine() }
            //translations
            textViewFlag.text = country.flag
            textViewRegionalBlocs.text =
                country.regionalBlocs?.joinToString(separator = "\n") { regionalBlock -> regionalBlock.fullLine() }
            textViewCioc.text = country.cioc
        }
    }

    private fun Currency.fullLine() = getString(R.string.pattern_currency, name, code, symbol)

    private fun Language.fullLine() =
        getString(R.string.pattern_language, name, nativeName, iso639_1, iso639_2)

    private fun RegionalBloc.fullLine() = getString(
        R.string.pattern_regional_bloc,
        acronym,
        name,
        otherAcronyms?.joinToString(separator = ", "),
        otherNames?.joinToString(separator = ", ")
    )
}