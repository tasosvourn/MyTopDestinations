package com.example.mytopdestinations.data.di

import com.example.mytopdestinations.data.networking.RestApiService
import com.example.mytopdestinations.data.repository.LocationsRepositoryImpl
import com.example.mytopdestinations.domain.repository.LocationsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppRepositoryModule {

    @Provides
    fun provideLocationRepository(
        restApiService: RestApiService
    ): LocationsRepository {
        return LocationsRepositoryImpl(restApiService)
    }
}