package com.example.mytopdestinations.domain.model.common

data class CityDomainModel(
    val id: String,
    val name: String,
    val code: String,
    val slug: String,
    val subdivision: String,
    val autonomousTerritory: String,
    val country: CountryDomainModel?,
    val region: RegionDomainModel?,
    val continent: ContinentDomainModel?
)
