package com.example.mytopdestinations.data.repository

import com.example.mytopdestinations.data.mapper.mapToDomain
import com.example.mytopdestinations.data.model.request.FetchTopDestinationsQuery
import com.example.mytopdestinations.data.networking.RestApiService
import com.example.mytopdestinations.data.networking.handleApiResponse
import com.example.mytopdestinations.domain.model.DomainResult
import com.example.mytopdestinations.domain.model.topdestinations.TopDestinationsDomainModel
import com.example.mytopdestinations.domain.repository.LocationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocationsRepositoryImpl(
    private val restApiService: RestApiService
) : LocationsRepository {
    override fun getTopDestinations(searchQuery: FetchTopDestinationsQuery): Flow<DomainResult<TopDestinationsDomainModel>> =
        flow {
            when (val response =
                handleApiResponse {
                    restApiService.getTopDestinations(
                        term = "london_gb",
                        locale = "en-US",
                        limit = 100,
                        sort = "name",
                        activeOnly = "true",
                        sourcePopularity = "bookings"
                    )
                }
            ) {
                is DomainResult.Error -> emit(response)
                is DomainResult.Success -> {
                    val topDestinationsResponse = response.data
                    emit(DomainResult.Success(topDestinationsResponse.mapToDomain()))
                }
            }
        }

}