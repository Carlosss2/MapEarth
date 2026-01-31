package com.carlos.mapearth.features.home.data.datasources.remote.mapper

import com.carlos.mapearth.features.home.data.datasources.remote.model.CountryDto
import com.carlos.mapearth.features.home.domain.entities.Country

fun CountryDto.toDomain(): Country {

    val currency = currencies?.values?.firstOrNull()

    return Country(
        name = name.common,
        officialName = name.official,
        capital = capital?.firstOrNull() ?: "N/A",
        region = region,
        subregion = subregion ?: "N/A",
        population = population,
        area = area,
        languages = languages?.values?.toList() ?: emptyList(),
        currencyName = currency?.name ?: "N/A",
        currencySymbol = currency?.symbol ?: "",
        flagPng = flags.png,
        flagSvg = flags.svg,
        googleMapsUrl = maps.googleMaps,
        borders = borders ?: emptyList(),
        timezones = timezones,
        independent = independent,
        unMember = unMember
    )
}
