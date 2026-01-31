package com.carlos.mapearth.features.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List

@Composable
fun FilterIcon(
    onLanguageSelected: (String) -> Unit,
    onCapitalSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Color.Black
) {
    var expanded by remember { mutableStateOf(false) }
    var language by remember { mutableStateOf("") }
    var capital by remember { mutableStateOf("") }

    val mapEarthBlue = Color(0xFF2D48CC)

    Box(modifier = modifier) {

        IconButton(onClick = { expanded = true }) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "Filter",
                tint = mapEarthBlue //
            )
        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(260.dp)
                .padding(8.dp)
        ) {

            Text(
                text = "Filters",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )

            // Language input
            OutlinedTextField(
                value = language,
                onValueChange = {
                    language = it
                    onLanguageSelected(it)
                },
                label = { Text("Language") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Capital input
            OutlinedTextField(
                value = capital,
                onValueChange = {
                    capital = it
                    onCapitalSelected(it)
                },
                label = { Text("Capital") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = { expanded = false },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Close")
            }
        }
    }
}
