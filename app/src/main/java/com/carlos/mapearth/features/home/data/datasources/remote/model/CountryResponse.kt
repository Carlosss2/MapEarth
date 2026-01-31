package com.carlos.mapearth.features.home.data.datasources.remote.model

data class CountryDto(
    val name: NameDto,
    val capital: List<String>?,
    val region: String,
    val subregion: String?,
    val population: Long,
    val area: Double,
    val languages: Map<String, String>?,
    val currencies: Map<String, CurrencyDto>?,
    val flags: FlagsDto,
    val maps: MapsDto,
    val borders: List<String>?,
    val timezones: List<String>,
    val independent: Boolean,
    val unMember: Boolean
)

data class NameDto(
    val common: String,
    val official: String
)

data class CurrencyDto(
    val name: String,
    val symbol: String?
)

data class FlagsDto(
    val png: String,
    val svg: String
)

data class MapsDto(
    val googleMaps: String,
    val openStreetMaps: String
)
