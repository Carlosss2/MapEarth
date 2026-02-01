package com.carlos.mapearth.features.home.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlos.mapearth.features.home.domain.entities.Country
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByCapitalUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByLanguageUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountriesByRegionUseCase
import com.carlos.mapearth.features.home.domain.usescases.GetCountryByNameUseCase
import com.carlos.mapearth.features.home.presentation.screens.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCountryByNameUseCase: GetCountryByNameUseCase,
    private val getCountriesByRegionUseCase: GetCountriesByRegionUseCase,
    private val getCountriesByLanguageUseCase: GetCountriesByLanguageUseCase,
    private val getCountriesByCapitalUseCase: GetCountriesByCapitalUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun searchByName() {
        load { getCountryByNameUseCase(_searchQuery.value) }
    }

    fun searchByRegion(region: String) {
        load { getCountriesByRegionUseCase(region) }
    }

    fun searchByLanguage(language: String) {
        load { getCountriesByLanguageUseCase(language) }
    }

    fun searchByCapital(capital: String) {
        load { getCountriesByCapitalUseCase(capital) }
    }

    private fun load(
        call: suspend () -> Result<List<Country>>
    ) {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = call()
            _uiState.update { state ->
                result.fold(
                    onSuccess = {
                        state.copy(isLoading = false, countries = it)
                    },
                    onFailure = {
                        state.copy(isLoading = false, error = it.message)
                    }
                )
            }
        }
    }
}
