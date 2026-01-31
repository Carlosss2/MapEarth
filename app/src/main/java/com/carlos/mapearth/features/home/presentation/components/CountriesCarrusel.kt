package com.carlos.mapearth.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.carlos.mapearth.features.home.domain.entities.Country

@Composable
fun CountriesCarousel(
    countries: List<Country>,
    isLoading: Boolean,
    error: String?
) {
    when {
        isLoading -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                //
                CircularProgressIndicator(
                    color = Color(0xFF2D48CC) //
                )


            }
        }

        error != null -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = error,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }
        }

        countries.isEmpty() -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Search for a country to see results",
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }

        else -> {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(countries) { country ->
                    CountryCard(country = country)
                }
            }
        }
    }
}

@Composable
fun CountryCard(country: Country) {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(390.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D48CC)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Flag Image
            AsyncImage(
                model = country.flagPng,
                contentDescription = "Flag of ${country.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0E0E0)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Country Name
            Text(
                text = country.name,

                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp

                ),
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Region
            Text(
                text = country.region,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Language
            Text(
                text = country.languages.firstOrNull() ?: "N/A",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            // Language
            Text(
                text = country.capital ?: "N/A",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = country.currencyName ?: "N/A",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
            Text(
                text = country.googleMapsUrl ?: "N/A",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))


        }
    }
}