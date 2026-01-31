package com.carlos.mapearth.core.network

import com.carlos.mapearth.features.home.data.datasources.remote.model.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountriesApi {

    @GET("name/{name}")
    suspend fun getCountryByName(
        @Path("name") name: String
    ): List<CountryDto>

    @GET("lang/{language}")
    suspend fun getCountriesByLanguage(
        @Path("language") language: String
    ): List<CountryDto>

    @GET("capital/{capital}")
    suspend fun getCountriesByCapital(
        @Path("capital") capital: String
    ): List<CountryDto>

    @GET("region/{region}")
    suspend fun getCountriesByRegion(
        @Path("region") region: String
    ): List<CountryDto>
}
