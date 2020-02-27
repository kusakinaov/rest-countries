package olga.ku.restcountries.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestCountriesService {
    private val api: RestCountriesApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://restcountries.eu")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(RestCountriesApi::class.java)
    }

    suspend fun getAll() = api.getAll()
}