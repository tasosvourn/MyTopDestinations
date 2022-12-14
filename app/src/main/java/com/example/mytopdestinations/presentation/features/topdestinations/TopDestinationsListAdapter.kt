package com.example.mytopdestinations.presentation.features.topdestinations

import com.example.mytopdestinations.presentation.common.adapterdelegates.RowUiItem
import com.example.mytopdestinations.presentation.features.topdestinations.adapterdelegates.ItemDestinationCardEventHandler
import com.example.mytopdestinations.presentation.features.topdestinations.adapterdelegates.itemDestinationCardDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class TopDestinationsListAdapter(
    topDestinationsEventHandler: ItemDestinationCardEventHandler
) : ListDelegationAdapter<List<RowUiItem>>(itemDestinationCardDelegate(topDestinationsEventHandler))