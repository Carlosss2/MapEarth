package com.carlos.mapearth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview
import com.carlos.mapearth.core.di.AppContainer
import com.carlos.mapearth.features.home.di.CountryModule
import com.carlos.mapearth.features.home.presentation.screens.HomeScreen

import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer()
        val countryModule = CountryModule(appContainer)
        enableEdgeToEdge()
        setContent {
            AppTheme{
                HomeScreen(countryModule.provideHomeViewModelFactory())

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {

    }
}