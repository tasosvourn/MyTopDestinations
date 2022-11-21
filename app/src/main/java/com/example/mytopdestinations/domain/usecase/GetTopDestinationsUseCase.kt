package com.example.mytopdestinations.domain.usecase

import com.example.mytopdestinations.domain.model.*
import com.example.mytopdestinations.domain.model.common.LocationsDomainModel
import com.example.mytopdestinations.domain.repository.LocationsRepository
import com.example.mytopdestinations.presentation.features.topdestinations.ItemDestinationCardUiItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTopDestinationsUseCase @Inject constructor(private val locationsRepository: LocationsRepository) {
    operator fun invoke(): Flow<DomainResult<MutableList<LocationsDomainModel>>> =
        locationsRepository.getTopDestinations()
}