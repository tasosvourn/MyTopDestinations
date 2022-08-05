package com.example.mytopdestinations.presentation.common

import com.example.mytopdestinations.domain.model.ErrorDomainModel

sealed class LceState

object LoadingState : LceState()
object ContentState : LceState()
class ErrorState(val errorDomainModel: ErrorDomainModel? = null, var message: String? = null) : LceState()
