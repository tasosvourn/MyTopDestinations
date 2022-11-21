package com.example.mytopdestinations.presentation.features.topdestinations

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.mytopdestinations.R
import com.example.mytopdestinations.databinding.FragmentTopDestinationsBinding
import com.example.mytopdestinations.presentation.common.BaseFragment
import com.example.mytopdestinations.presentation.common.LceStateViewModel
import com.example.mytopdestinations.presentation.common.adapterdelegates.RowUiItem
import com.example.mytopdestinations.presentation.utilities.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.mytopdestinations.presentation.utilities.collect

@AndroidEntryPoint
class TopDestinationsFragment : BaseFragment(R.layout.fragment_top_destinations) {

    private val viewBinding: FragmentTopDestinationsBinding by viewBinding(
        FragmentTopDestinationsBinding::bind
    )
    private val viewModel: TopDestinationsViewModel by activityViewModels()
    private lateinit var topDestinationsListAdapter: TopDestinationsListAdapter

    override fun provideLceViewModel(): LceStateViewModel = viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topDestinationsListAdapter =
            TopDestinationsListAdapter(
                viewModel.itemDestinationCardEventHandler
            )

        viewBinding.recyclerView.adapter = topDestinationsListAdapter
        viewModel.items.collect(this) { list -> updateDestinationsList(list) }
    }

    private fun updateDestinationsList(list: List<RowUiItem>) {
        topDestinationsListAdapter.items = list
    }
}