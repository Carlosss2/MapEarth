package com.carlos.mapearth.features.home.presentation.screens
import com.carlos.mapearth.features.home.domain.entities.Country

data class HomeUiState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false,
)