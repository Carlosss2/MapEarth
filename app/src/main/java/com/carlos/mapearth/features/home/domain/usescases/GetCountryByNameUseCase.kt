package com.carlos.mapearth.features.home.domain.usescases

import com.carlos.mapearth.features.home.domain.entities.Country
import com.carlos.mapearth.features.home.domain.repositories.CountryRepository

class GetCountryByNameUseCase(
    private val repository: CountryRepository
) {

    suspend operator fun invoke(name: String): Result<List<Country>> {
        return try {

            if (name.isBlank()) {
                return Result.failure(Exception("El nombre del país no puede estar vacío"))
            }

            val countries = repository.getCountryByName(name)

            val filteredCountries = countries.filter { it.name.isNotBlank() }

            if (filteredCountries.isEmpty()) {
                Result.failure(Exception("No se encontraron países con ese nombre"))
            } else {
                Result.success(filteredCountries)
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
