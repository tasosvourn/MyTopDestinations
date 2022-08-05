package com.example.mytopdestinations.data.mapper


import com.example.mytopdestinations.data.model.response.common.*
import com.example.mytopdestinations.data.model.response.TopDestinationsResponse
import com.example.mytopdestinations.domain.model.common.*
import com.example.mytopdestinations.domain.model.topdestinations.TopDestinationsDomainModel

fun TopDestinationsResponse.mapToDomain(): TopDestinationsDomainModel {
    return TopDestinationsDomainModel(
        locations = locations?.map { it.mapToDomain() } as MutableList<LocationsDomainModel>?,
        meta = meta?.mapToDomain(),
        lastRefresh = lastRefresh ?: 0,
        resultsRetrieved = resultsRetrieved ?: 0
    )
}

fun Locations.mapToDomain(): LocationsDomainModel {
    return LocationsDomainModel(
        id = id ?: "",
        active = active ?: false,
        name = name ?: "",
        slug = slug ?: "",
        slugEn = slugEn ?: "",
        code = code ?: "",
        alternativeNames = alternativeNames ?: mutableListOf(),
        rank = rank ?: 0,
        globalRankDst = globalRankDst ?: 0,
        dstPopularityScore = dstPopularityScore ?: 0,
        timezone = timezone ?: "",
        population = population ?: 0,
        airports = airports ?: 0,
        stations = stations ?: 0,
        hotels = hotels ?: 0,
        busStations = busStations ?: 0,
        subdivision = subdivision?.mapToDomain(),
        autonomousTerritory = autonomousTerritory ?: "",
        country = country?.mapToDomain(),
        region = region?.mapToDomain(),
        continent = continent?.mapToDomain(),
        nearbyCountry = nearbyCountry ?: "",
        location = location?.mapToDomain(),
        tags = tags?.map { it.mapToDomain() },
        alternativeDeparturePoints = alternativeDeparturePoints?.map { it.mapToDomain() },
        providers = providers ?: mutableListOf(),
        carRentals = carRentals?.map { it.mapToDomain() },
        type = type ?: ""
    )
}

fun Meta.mapToDomain(): MetaDomainModel {
    return MetaDomainModel(
        locale = locale?.mapToDomain()
    )
}

fun Locale.mapToDomain(): LocaleDomainModel {
    return LocaleDomainModel(
        code = code ?: "",
        status = status ?: ""
    )
}

fun City.mapToDomain(): CityDomainModel {
    return CityDomainModel(
        id = id ?: "",
        name = name ?: "",
        slug = slug ?: "",
        code = code ?: "",
        subdivision = subdivision ?: "",
        autonomousTerritory = autonomousTerritory ?: "",
        country = country?.mapToDomain(),
        region = region?.mapToDomain(),
        continent = continent?.mapToDomain(),
    )
}

fun Subdivision.mapToDomain() : SubdivisionDomainModel {
    return SubdivisionDomainModel(
        id = id ?: "",
        name = name ?: "",
        slug = slug ?: "",
        code = code?: ""
    )
}

fun Country.mapToDomain(): CountryDomainModel {
    return CountryDomainModel(
        id = id ?: "",
        name = name ?: "",
        slug = slug ?: "",
        code = code ?: ""
    )
}

fun Region.mapToDomain(): RegionDomainModel {
    return RegionDomainModel(
        id = id ?: "",
        name = name ?: "",
        slug = slug ?: ""
    )
}

fun Continent.mapToDomain(): ContinentDomainModel {
    return ContinentDomainModel(
        id = id ?: "",
        name = name ?: "",
        slug = slug ?: "",
        code = code ?: ""
    )
}

fun Location.mapToDomain(): LocationDomainModel {
    return LocationDomainModel(
        lon = (lon ?: 0) as Double,
        lat = (lat ?: 0) as Double
    )
}

fun Tags.mapToDomain() : TagsDomainModel {
    return TagsDomainModel(
        tag = tag ?: "",
        monthFrom = monthFrom ?: 0,
        monthTo = monthTo ?: 0
    )
}

fun AlternativeDeparturePoints.mapToDomain(): AlternativeDeparturePointsDomainModel {
    return AlternativeDeparturePointsDomainModel(
        id = id ?: "",
        distance = distance ?: 0.0,
        duration = duration ?: 0.0
    )
}

fun CarRentals.mapToDomain() : CarRentalsDomainModel {
    return CarRentalsDomainModel(
        providerId = providerId ?: 0,
        providersLocations = providersLocations ?: mutableListOf()
    )
}