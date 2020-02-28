package olga.ku.restcountries.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_country.view.*
import kotlinx.android.synthetic.main.fragment_country.view.textViewName
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
            setValue(textViewHeaderName, textViewName, country.name)
            setValue(
                textViewHeaderDomain,
                textViewDomain,
                country.topLevelDomain?.joinToString(separator = ", ")
            )
            setValue(textViewHeaderAlpha2Code, textViewAlpha2Code, country.alpha2Code)
            setValue(textViewHeaderAlpha3Code, textViewAlpha3Code, country.alpha3Code)
            setValue(
                textViewHeaderCallingCodes,
                textViewCallingCodes,
                country.callingCodes?.joinToString(separator = ", ")
            )
            setValue(textViewHeaderCapital, textViewCapital, country.capital)
            setValue(
                textViewHeaderAltSpellings,
                textViewAltSpellings,
                country.altSpellings?.joinToString(separator = ", ")
            )
            setValue(textViewHeaderRegion, textViewRegion, country.region)
            setValue(textViewHeaderSubRegion, textViewSubRegion, country.subregion)
            setValue(textViewHeaderPopulation, textViewPopulation, country.population?.toString())
            setValue(
                textViewHeaderLatLon,
                textViewLatLon,
                country.latlng?.joinToString(", ") { it.toString() })
            setValue(textViewHeaderDemonym, textViewDemonym, country.demonym)
            setValue(textViewHeaderArea, textViewArea, country.area?.toString())
            setValue(textViewHeaderGini, textViewGini, country.gini?.toString())
            setValue(
                textViewHeaderTimezones,
                textViewTimezones,
                country.timezones?.joinToString(separator = ", ")
            )
            setValue(
                textViewHeaderBorders,
                textViewBorders,
                country.borders?.joinToString(separator = ", ")
            )
            setValue(textViewHeaderNativeName, textViewNativeName, country.nativeName)
            setValue(textViewHeaderNumericCode, textViewNumericCode, country.numericCode)
            setValue(textViewHeaderCurrencies, textViewCurrencies,
                country.currencies?.joinToString(separator = "\n") { it.fullLine() })
            setValue(textViewHeaderLanguages, textViewLanguages,
                country.languages?.joinToString(separator = "\n") { it.fullLine() })
            setValue(textViewHeaderTranslations, textViewTranslations, null)
            setValue(textViewHeaderFlag, textViewFlag, country.flag)
            setValue(textViewHeaderRegionalBlocs, textViewRegionalBlocs,
                country.regionalBlocs?.joinToString(separator = "\n") { it.fullLine() })
            setValue(textViewHeaderCioc, textViewCioc, country.cioc)
        }
    }

    private fun setValue(textViewHeader: TextView, textView: TextView, text: String?) {
        textView.text = text

        val visibility = if (text.isNullOrEmpty()) View.GONE else View.VISIBLE
        textViewHeader.visibility = visibility
        textView.visibility = visibility
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