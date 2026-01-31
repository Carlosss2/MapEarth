package com.carlos.mapearth.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RegionsCard(
    onRegionSelected: (String) -> Unit
) {
    val regions = listOf(
        "Africa" to "africa",
        "Americas" to "americas",
        "Asia" to "asia",
        "Europe" to "europe",
        "Oceania" to "oceania"
    )

    Column {
        Text(
            text = "Continents",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF2D48CC), //
            modifier = Modifier.padding(bottom = 12.dp)
        )


        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(regions) { (region, image) ->
                RegionItem(region, image) {
                    onRegionSelected(region)
                }
            }
        }
    }
}


@Composable
fun RegionItem(
    region: String,
    imageName: String,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(
        imageName,
        "drawable",
        context.packageName
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(90.dp)
            .clickable { onClick() }
    ) {

        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.size(80.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF2D48CC).copy(alpha = 0.08f)),
                contentAlignment = Alignment.Center
            ) {
                if (imageResId != 0) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = region,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = region,
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF2D48CC) //
        )

    }
}
