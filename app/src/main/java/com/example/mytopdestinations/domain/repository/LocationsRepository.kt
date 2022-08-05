package com.example.mytopdestinations.domain.repository

import com.example.mytopdestinations.data.model.request.FetchTopDestinationsQuery
import com.example.mytopdestinations.domain.model.DomainResult
import com.example.mytopdestinations.domain.model.topdestinations.TopDestinationsDomainModel
import kotlinx.coroutines.flow.Flow

interface LocationsRepository {
    fun getTopDestinations(searchQuery: FetchTopDestinationsQuery): Flow<DomainResult<TopDestinationsDomainModel>>
}