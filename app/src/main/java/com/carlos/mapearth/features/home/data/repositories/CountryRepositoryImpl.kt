package com.carlos.mapearth.features.home.data.repositories

import com.carlos.mapearth.core.network.RestCountriesApi
import com.carlos.mapearth.features.home.data.datasources.remote.mapper.toDomain
import com.carlos.mapearth.features.home.domain.entities.Country
import com.carlos.mapearth.features.home.domain.repositories.CountryRepository

class CountryRepositoryImpl(
    private val api: RestCountriesApi
) : CountryRepository {

    override suspend fun getCountryByName(name: String): List<Country> {
        val response = api.getCountryByName(name)
        return response.map { it.toDomain() }
    }

    override suspend fun getCountriesByLanguage(language: String): List<Country> {
        val response = api.getCountriesByLanguage(language)
        return response.map { it.toDomain() }
    }

    override suspend fun getCountriesByCapital(capital: String): List<Country> {
        val response = api.getCountriesByCapital(capital)
        return response.map { it.toDomain() }
    }

    override suspend fun getCountriesByRegion(region: String): List<Country> {
        val response = api.getCountriesByRegion(region)
        return response.map { it.toDomain() }
    }
}
