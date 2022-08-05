package com.example.mytopdestinations.presentation.common

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mytopdestinations.domain.model.ErrorDomainModel
import com.example.mytopdestinations.domain.model.UnknownErrorType
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class LceStateViewModel : ViewModel() {

    private val APPLICATION_TAG = "My top destinations"

    protected val _lceState = MutableStateFlow<LceState>(ContentState)
    val lceState: StateFlow<LceState> = _lceState

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        throwable.message?.let { Log.e(APPLICATION_TAG, it) }

        _lceState.value =
            ErrorState(errorDomainModel = ErrorDomainModel(UnknownErrorType(), throwable.message))
    }
}
