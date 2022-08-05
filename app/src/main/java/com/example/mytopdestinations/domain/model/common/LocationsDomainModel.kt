package com.example.mytopdestinations.domain.model.common

data class LocationsDomainModel(
    val id: String,
    val active: Boolean,
    val name: String,
    val slug: String,
    val slugEn: String,
    val code: String,
    val alternativeNames: List<String>,
    val rank: Int,
    val globalRankDst: Int,
    val dstPopularityScore: Int,
    val timezone: String,
    val population: Int,
    val airports: Int,
    val stations: Int,
    val hotels: Int,
    val busStations: Int,
    val subdivision: SubdivisionDomainModel?,
    val autonomousTerritory: String,
    val country: CountryDomainModel?,
    val region: RegionDomainModel?,
    val continent: ContinentDomainModel?,
    val nearbyCountry: String,
    val location: LocationDomainModel?,
    val tags: List<TagsDomainModel>?,
    val alternativeDeparturePoints: List<AlternativeDeparturePointsDomainModel>?,
    val providers: List<Int>,
    val carRentals: List<CarRentalsDomainModel>?,
    val type: String
)

