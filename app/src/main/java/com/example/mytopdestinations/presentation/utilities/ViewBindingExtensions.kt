package com.example.mytopdestinations.presentation.utilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Activity extension function used to create ViewBinding object for an activity
 * @param T
 * @param bindingInflater The inflater of the view binding
 */
inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

/**
 * ViewGroup extension to create ViewBinding object
 * @param bindingInflater The inflater of the view binding
 * @param attachToParent Attach or not to the parent
 */
inline fun <T : ViewBinding> ViewGroup.viewBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
    attachToParent: Boolean = true
) = bindingInflater.invoke(LayoutInflater.from(this.context), this, attachToParent)