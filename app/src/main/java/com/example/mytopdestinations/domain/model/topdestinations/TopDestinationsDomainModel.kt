package com.example.mytopdestinations.domain.model.topdestinations

import androidx.annotation.StringRes
import com.example.mytopdestinations.domain.model.common.LocationsDomainModel
import com.example.mytopdestinations.domain.model.common.MetaDomainModel

data class TopDestinationsDomainModel(
    val locations: MutableList<LocationsDomainModel>?,
    val meta: MetaDomainModel?,
    val lastRefresh: Int,
    val resultsRetrieved: Int,
    val disliked: Boolean
)