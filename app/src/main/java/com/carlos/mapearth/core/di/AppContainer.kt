package com.carlos.mapearth.core.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.carlos.mapearth.BuildConfig
import com.carlos.mapearth.core.network.RestCountriesApi
import com.carlos.mapearth.features.home.data.repositories.CountryRepositoryImpl
import com.carlos.mapearth.features.home.domain.repositories.CountryRepository

class AppContainer {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val restCountriesApi: RestCountriesApi by lazy {
        retrofit.create(RestCountriesApi::class.java)
    }

    val countryRepository: CountryRepository by lazy {
        CountryRepositoryImpl(restCountriesApi)
    }
}
