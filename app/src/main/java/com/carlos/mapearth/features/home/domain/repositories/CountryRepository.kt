package com.carlos.mapearth.features.home.domain.repositories

import com.carlos.mapearth.features.home.domain.entities.Country

interface CountryRepository {

    suspend fun getCountryByName(name: String): List<Country>

    suspend fun getCountriesByLanguage(language: String): List<Country>

    suspend fun getCountriesByCapital(capital: String): List<Country>

    suspend fun getCountriesByRegion(region: String): List<Country>
}
