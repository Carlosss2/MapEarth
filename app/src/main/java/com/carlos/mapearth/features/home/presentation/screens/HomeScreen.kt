package com.carlos.mapearth.features.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carlos.mapearth.features.home.presentation.components.*
import com.carlos.mapearth.features.home.presentation.viewmodels.HomeViewModel
import com.carlos.mapearth.features.home.presentation.viewmodels.HomeViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(factory: HomeViewModelFactory) {
    val viewModel: HomeViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(Color.White)
            .padding(16.dp)
    ) {

        Header()

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SearchBar(
                searchQuery = searchQuery,
                onSearchQueryChange = { searchQuery = it },
                onSearch = { viewModel.searchByName(searchQuery) }
            )

            FilterIcon(
                onLanguageSelected = { viewModel.searchByLanguage(it) },
                onCapitalSelected = { viewModel.searchByCapital(it) }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                RegionsCard(
                    onRegionSelected = { viewModel.searchByRegion(it) }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Countries",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF2D48CC)
        )

        Spacer(modifier = Modifier.height(16.dp))

        CountriesCarousel(
            countries = uiState.countries,
            isLoading = uiState.isLoading,
            error = uiState.error
        )
    }
}
