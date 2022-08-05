package com.example.mytopdestinations.presentation.features.topdestinations.adapterdelegates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mytopdestinations.databinding.ItemDestinationCardBinding
import com.example.mytopdestinations.presentation.common.adapterdelegates.RowUiItem
import com.example.mytopdestinations.presentation.features.topdestinations.ItemDestinationCardUiItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

interface ItemDestinationCardEventHandler {
    fun onLeftButtonClicked(name: String)
    fun onRightButtonClicked()
}

fun itemDestinationCardDelegate(
    eventHandler: ItemDestinationCardEventHandler
) =
    adapterDelegateViewBinding<ItemDestinationCardUiItem, RowUiItem, ItemDestinationCardBinding>(
        {
            layoutInflater: LayoutInflater, parent: ViewGroup ->
            ItemDestinationCardBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        }
    ) {
        bind {
            binding.apply {
                Glide.with(context).asBitmap().load(item.imageUrl).into(itemDestinationCardImageView)
                itemDestinationCardTitle.text = item.title
                itemDestinationCardSecondaryText.text = item.secondaryText
                itemDestinationCardSupportingText.text = item.supportingText
                if(item.supportingTextVisibility == View.VISIBLE) {
                    itemDestinationCardSupportingText.visibility = View.GONE
                } else {
                    itemDestinationCardSupportingText.visibility = View.GONE
                }

                itemDestinationCardLeftButton.apply {
                    text = getString(item.leftButtonText)
                    setOnClickListener { eventHandler.onLeftButtonClicked(item.title) }
                }
                itemDestinationCardRightButton.apply {
                    text = getString(item.rightButtonText)
                    setOnClickListener { eventHandler.onRightButtonClicked() }
                }

            }
        }
    }