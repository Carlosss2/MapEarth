package com.carlos.mapearth.features.home.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByCapitalUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByLanguageUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByRegionUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountryByNameUseCase

class HomeViewModelFactory(
    private val getCountryByNameUseCase: GetCountryByNameUseCase,
    private val getCountriesByRegionUseCase: GetCountriesByRegionUseCase,
    private val getCountriesByLanguageUseCase: GetCountriesByLanguageUseCase,
    private val getCountriesByCapitalUseCase: GetCountriesByCapitalUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(
                getCountryByNameUseCase,
                getCountriesByRegionUseCase,
                getCountriesByLanguageUseCase,
                getCountriesByCapitalUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
