package com.example.mytopdestinations.presentation.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.StateFlow
import com.example.mytopdestinations.presentation.utilities.collect

abstract class BaseFragment(layout: Int) : Fragment(layout) {
    private var lceViewModel: LceStateViewModel? = null

    abstract fun provideLceViewModel(): LceStateViewModel?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lceViewModel = provideLceViewModel()
    }

//Might not need to implement
/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lceViewModel?.let {
            observeLceState(it.lceState)
        }
    }

    private fun observeLceState(lceStateFlow: StateFlow<LceState>) {
        lceStateFlow.collect(viewLifecycleOwner) {
            when (it) {
                LoadingState -> showProgress()
                ContentState -> hideProgress()
                is ErrorState -> {
                    hideProgress()
                    handleErrorInternal(it.errorDomainModel)
                }
            }
        }
    }*/
}