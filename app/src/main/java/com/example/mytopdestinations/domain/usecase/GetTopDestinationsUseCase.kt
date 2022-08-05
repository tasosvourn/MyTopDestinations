package com.example.mytopdestinations.domain.usecase

import com.example.mytopdestinations.R
import com.example.mytopdestinations.data.model.request.FetchTopDestinationsQuery
import com.example.mytopdestinations.domain.model.*
import com.example.mytopdestinations.domain.model.common.ContinentDomainModel
import com.example.mytopdestinations.domain.model.common.CountryDomainModel
import com.example.mytopdestinations.domain.model.common.LocationsDomainModel
import com.example.mytopdestinations.domain.repository.LocationsRepository
import com.example.mytopdestinations.presentation.features.topdestinations.ItemDestinationCardUiItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.http.Url
import javax.inject.Inject

class GetTopDestinationsUseCase @Inject constructor(private val locationsRepository: LocationsRepository) {
    operator fun invoke(
        searchQuery: FetchTopDestinationsQuery
    ): Flow<DomainResult<MutableList<ItemDestinationCardUiItem>>> = flow {
        when (val result = locationsRepository.getTopDestinations(searchQuery).first()) {
            is DomainResult.Error -> emit(result)
            is DomainResult.Success -> {
                val destinations = result.data.locations!!

                val destinationCards = mutableListOf<ItemDestinationCardUiItem>()

                destinations.let { destination ->

                    destination.forEach { destinationDomainModelItem ->
                        destinationDomainModelItem.let { destinationDomainModel ->
                            while (destinationCards.size < 5) {
                                destinationCards.add(
                                    ItemDestinationCardUiItem(
                                        imageUrl = getImageUrl(destinationDomainModel.id),
                                        title = destinationDomainModel.name,
                                        secondaryText = destinationDomainModel.country!!.name,
                                        supportingText = getSupportingText(
                                            destinationDomainModel.alternativeNames,
                                            destinationDomainModel.rank,
                                            destinationDomainModel.country.name,
                                            destinationDomainModel.continent!!.name
                                        ),
                                        leftButtonText = R.string.more_about_this,
                                        rightButtonText = R.string.i_dont_like_it
                                    )
                                )
                            }
                        }
                    }
                }
                emit(DomainResult.Success(destinationCards))
            }
        }
    }
}

private fun getImageUrl(name: String): String {
    return "https://images.kiwi.com/photos/600x330/$name.jpg"
}


fun getSupportingText(
    alternativeNames: List<String>,
    rank: Int,
    country: String,
    continent: String,
): String {
    var supportText = String()
    supportText += "Country: $country\n" +
            "Continent:$continent\n" +
            "Kiwi rank:$rank\n" +
            "Alternative names:"
    for (name in alternativeNames) {
        supportText += "${name}\n"
    }
    return supportText
}