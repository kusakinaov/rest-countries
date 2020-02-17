package olga.ku.restcountries.api

import olga.ku.restcountries.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface RestCountriesApi {
    @GET("/rest/v2/all")
    fun getAll(): Call<Array<Country>>
}