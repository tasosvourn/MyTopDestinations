package com.example.mytopdestinations.domain.repository

import com.example.mytopdestinations.domain.model.DomainResult
import com.example.mytopdestinations.domain.model.common.LocationsDomainModel
import com.example.mytopdestinations.presentation.features.topdestinations.ItemDestinationCardUiItem
import kotlinx.coroutines.flow.Flow

interface LocationsRepository {
    fun getTopDestinations(): Flow<DomainResult<MutableList<LocationsDomainModel>>>
}