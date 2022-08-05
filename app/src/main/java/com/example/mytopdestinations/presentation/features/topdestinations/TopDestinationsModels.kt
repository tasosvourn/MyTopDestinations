package com.example.mytopdestinations.presentation.features.topdestinations

import androidx.annotation.StringRes
import com.example.mytopdestinations.presentation.common.adapterdelegates.RowUiItem

/**
 * To hold the data for the destination UI item
 */
data class ItemDestinationCardUiItem(
    val imageUrl: String = "",
    val title: String = "",
    val secondaryText: String = "",
    val supportingText: String = "",
    var supportingTextVisibility: Int = 0,
    @StringRes val leftButtonText: Int = 0,
    @StringRes val rightButtonText: Int = 0
): RowUiItem