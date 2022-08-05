package com.example.mytopdestinations.presentation.common.adapterdelegates

/**
 * Basic Item for adapter delegates
 *
 */
interface RowUiItem

/**
 * An item which has a loading functionality
 *
 */
interface LoadingRowUiItem : RowUiItem {
    var loading: Boolean
}