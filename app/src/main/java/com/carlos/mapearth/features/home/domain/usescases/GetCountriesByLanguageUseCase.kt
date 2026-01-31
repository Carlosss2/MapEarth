package com.carlos.mapearth.features.home.domain.usescases

import com.carlos.mapearth.features.home.domain.entities.Country
import com.carlos.mapearth.features.home.domain.repositories.CountryRepository

class GetCountriesByLanguageUseCase(
    private val repository: CountryRepository
) {

    suspend operator fun invoke(language: String): Result<List<Country>> {
        return try {

            if (language.isBlank()) {
                return Result.failure(Exception("El idioma no puede estar vacío"))
            }

            val countries = repository.getCountriesByLanguage(language)

            val filteredCountries = countries.filter { it.name.isNotBlank() }

            if (filteredCountries.isEmpty()) {
                Result.failure(Exception("No se encontraron países que hablen ese idioma"))
            } else {
                Result.success(filteredCountries)
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}