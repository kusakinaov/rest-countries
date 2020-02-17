package olga.ku.restcountries.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Country(
    @SerializedName("name") val name: String?,
    @SerializedName("topLevelDomain") val topLevelDomain: Array<String>?,
    @SerializedName("alpha2Code") val alpha2Code: String?,
    @SerializedName("alpha3Code") val alpha3Code: String?,
    @SerializedName("callingCodes") val callingCodes: Array<String>?,
    @SerializedName("capital") val capital: String?,
    @SerializedName("altSpellings") val altSpellings: Array<String>?,
    @SerializedName("region") val region: String?,
    @SerializedName("subregion") val subregion: String?,
    @SerializedName("population") val population: Long?,
    @SerializedName("latlng") val latlng: Array<Double>?,// [4.0, -72.0],
    @SerializedName("demonym") val demonym: String?,
    @SerializedName("area") val area: Double?,
    @SerializedName("gini") val gini: Float?,
    @SerializedName("timezones") val timezones: Array<String>?,
    @SerializedName("borders") val borders: Array<String>,
    @SerializedName("nativeName") val nativeName: String?,
    @SerializedName("numericCode") val numericCode: String?,
    @SerializedName("currencies") val currencies: Array<Currency>,
    @SerializedName("languages") val languages: Array<Language>?,
    @SerializedName("translations") val translations: Map<String, String>?,
    @SerializedName("flag") val flag: String?,
    @SerializedName("regionalBlocs") val regionalBlocs: Array<RegionalBloc>?,
    @SerializedName("cioc") val cioc: String?
) : Serializable