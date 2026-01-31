package com.carlos.mapearth.features.home.di

import com.carlos.mapearth.core.di.AppContainer
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByCapitalUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByLanguageUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByRegionUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountryByNameUseCase
import com.carlos.mapearth.features.home.presentation.viewmodels.HomeViewModelFactory

class CountryModule(
    private val appContainer: AppContainer
) {

    private fun provideGetCountryByNameUseCase(): GetCountryByNameUseCase {
        return GetCountryByNameUseCase(
            repository = appContainer.countryRepository
        )
    }

    private fun provideGetCountriesByRegionUseCase(): GetCountriesByRegionUseCase {
        return GetCountriesByRegionUseCase(
            repository = appContainer.countryRepository
        )
    }

    private fun provideGetCountriesByLanguageUseCase(): GetCountriesByLanguageUseCase {
        return GetCountriesByLanguageUseCase(
            repository = appContainer.countryRepository
        )
    }

    private fun provideGetCountriesByCapitalUseCase(): GetCountriesByCapitalUseCase {
        return GetCountriesByCapitalUseCase(
            repository = appContainer.countryRepository
        )
    }

    fun provideHomeViewModelFactory(): HomeViewModelFactory {
        return HomeViewModelFactory(
            getCountryByNameUseCase = provideGetCountryByNameUseCase(),
            getCountriesByRegionUseCase = provideGetCountriesByRegionUseCase(),
            getCountriesByLanguageUseCase = provideGetCountriesByLanguageUseCase(),
            getCountriesByCapitalUseCase = provideGetCountriesByCapitalUseCase()
        )
    }
}