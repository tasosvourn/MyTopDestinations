package com.example.mytopdestinations.presentation.features.topdestinations

import android.util.Log
import android.view.View
import androidx.lifecycle.viewModelScope
import com.example.mytopdestinations.R
import com.example.mytopdestinations.data.mapper.getSupportingText
import com.example.mytopdestinations.domain.model.DomainResult
import com.example.mytopdestinations.domain.model.common.LocationsDomainModel
import com.example.mytopdestinations.domain.usecase.GetTopDestinationsUseCase
import com.example.mytopdestinations.presentation.common.LceStateViewModel
import com.example.mytopdestinations.presentation.common.adapterdelegates.RowUiItem
import com.example.mytopdestinations.presentation.features.topdestinations.adapterdelegates.ItemDestinationCardEventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopDestinationsViewModel @Inject constructor(
    private val getTopDestinationsUseCase: GetTopDestinationsUseCase
) : LceStateViewModel() {

    private val list = mutableListOf<ItemDestinationCardUiItem>()
    private val _items = MutableStateFlow(emptyList<RowUiItem>())
    val items = _items.asStateFlow()

    init {
        buildTopDestinationsItem()
    }

    private fun buildTopDestinationsItem() {
        viewModelScope.launch {
            makeTopDestinationsCall()
        }
    }

    private suspend fun makeTopDestinationsCall() {
        when (val result = getTopDestinationsUseCase().first()) {
            is DomainResult.Error -> Log.d(
                "TopDestinationsAPICall",
                "Error buildTopDestinationsItem $result"
            )
            is DomainResult.Success ->
                loadTopFiveDestinations(result.data)
        }
    }

    private fun loadTopFiveDestinations(locations: MutableList<LocationsDomainModel>) {
        locations.take(5).forEachIndexed { _, location ->
            list.add(
                ItemDestinationCardUiItem(
                    imageUrl = location.imageURL,
                    title = location.name,
                    secondaryText = location.country!!.name,
                    supportingText = location.supportingText,
                    leftButtonText = R.string.more_about_this,
                    rightButtonText = R.string.i_dont_like_it
                )
            )
            _items.value = list.toList()
        }
    }

    val itemDestinationCardEventHandler = object : ItemDestinationCardEventHandler {
        override fun onLeftButtonClicked(name: String) {
            showExtraInfo(name)
        }

        override fun onRightButtonClicked() {
            TODO(
                "Not yet implemented." +
                        "Replace the selected destination with another from the list"
            )
        }
    }

    private fun showExtraInfo(name: String) {
        list.forEachIndexed { _, item ->
            if (item.title == name) {
                item.supportingTextVisibility = View.VISIBLE
            }
        }
    }
}