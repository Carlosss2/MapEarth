package com.carlos.mapearth.features.home.domain.entities

data class Country(
    val name: String,
    val officialName: String,
    val capital: String,
    val region: String,
    val subregion: String,
    val population: Long,
    val area: Double,
    val languages: List<String>,
    val currencyName: String,
    val currencySymbol: String,
    val flagPng: String,
    val flagSvg: String,
    val googleMapsUrl: String,
    val borders: List<String>,
    val timezones: List<String>,
    val independent: Boolean,
    val unMember: Boolean
)
