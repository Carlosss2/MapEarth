package com.carlos.mapearth.features.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header() {
    Spacer(modifier = Modifier.height(29.dp))
    val mapEarthBlue = Color(0xFF2D48CC)

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White, //
        shape = RoundedCornerShape(24.dp),
        tonalElevation = 4.dp
    ) {

        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = "MapEarth",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    ),
                    color = mapEarthBlue
                )
                Text(
                    text = "Explore countries around the world",
                    style = MaterialTheme.typography.bodyMedium,
                    color = mapEarthBlue.copy(alpha = 0.7f) //
                )

            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(mapEarthBlue, CircleShape), // 🎨 COLOR MAPEARTH
                contentAlignment = Alignment.Center
            )
            {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User",
                    tint = Color.White
                )
            }
        }
    }
}
