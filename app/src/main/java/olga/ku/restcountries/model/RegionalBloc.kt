package olga.ku.restcountries.model

import com.google.gson.annotations.SerializedName

data class RegionalBloc(
    @SerializedName("acronym") val acronym: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("otherAcronyms") val otherAcronyms: Array<String>?,
    @SerializedName("otherNames") val otherNames: Array<String>?
)