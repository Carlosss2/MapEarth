package com.carlos.mapearth.features.home.domain.usescases

import com.carlos.mapearth.features.home.domain.entities.Country
import com.carlos.mapearth.features.home.domain.repositories.CountryRepository

class GetCountriesByRegionUseCase(
    private val repository: CountryRepository
) {

    suspend operator fun invoke(region: String): Result<List<Country>> {
        return try {

            if (region.isBlank()) {
                return Result.failure(Exception("La región no puede estar vacía"))
            }

            val countries = repository.getCountriesByRegion(region)

            val filteredCountries = countries.filter { it.name.isNotBlank() }

            if (filteredCountries.isEmpty()) {
                Result.failure(Exception("No se encontraron países en esa región"))
            } else {
                Result.success(filteredCountries)
            }

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}