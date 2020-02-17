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
        arguments?.let { it ->
            country = it.getSerializable(COUNTRY) as Country
            country?.let { country ->
                view.textViewName.text = country.name
                view.textViewDomain.text = country.topLevelDomain?.joinToString(separator = ", ")
                view.textViewAlpha2Code.text = country.alpha2Code
                view.textViewAlpha3Code.text = country.alpha3Code
                view.textViewCallingCodes.text =
                    country.callingCodes?.joinToString(separator = ", ")
                view.textViewCapital.text = country.capital
                view.textViewAltSpellings.text =
                    country.altSpellings?.joinToString(separator = ", ")
                view.textViewRegion.text = country.region
                view.textViewSubRegion.text = country.subregion
                view.textViewPopulation.text = country.population?.toString()
                view.textViewLatLon.text = country.latlng?.joinToString(", ") { d -> d.toString() }
                view.textViewDemonym.text = country.demonym
                view.textViewArea.text = country.area?.toString()
                view.textViewGini.text = country.gini?.toString()
                view.textViewTimezones.text = country.timezones?.joinToString(separator = ", ")
                view.textViewBorders.text = country.borders?.joinToString(separator = ", ")
                view.textViewNativeName.text = country.nativeName
                view.textViewNumericCode.text = country.numericCode
                view.textViewCurrencies.text =
                    country.currencies?.joinToString(separator = "\n") { currency -> currency.fullLine() }
                view.textViewLanguages.text =
                    country.languages?.joinToString(separator = "\n") { language -> language.fullLine() }
                //translations
                view.textViewFlag.text = country.flag
                view.textViewRegionalBlocs.text =
                    country.regionalBlocs?.joinToString(separator = "\n") { regionalBlock -> regionalBlock.fullLine() }
                view.textViewCioc.text = country.cioc
            }
        }
    }

    private fun Currency.fullLine() = "$name ($code=$symbol)"

    private fun Language.fullLine() = "$name $nativeName ($iso639_1, $iso639_2)"

    private fun RegionalBloc.fullLine() =
        "$acronym $name ${otherAcronyms?.joinToString(separator = ", ")} ${otherNames?.joinToString(
            separator = ", "
        )}"
}