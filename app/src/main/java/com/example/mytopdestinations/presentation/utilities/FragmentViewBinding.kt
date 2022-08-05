package com.example.mytopdestinations.presentation.utilities

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * FragmentViewBinding class is for view binding for fragment
 * This class observe the fragment lifecycle and it remove the viewBinding on fragments onDestroy method
 */
class FragmentViewBinding<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T,
    private val viewProvider: (() -> View?)? = null
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null
    init {
        fragment.lifecycle.addObserver(object : DefaultLifecycleObserver {
            val viewLifecycleOwnerLiveDataObserver =
                Observer<LifecycleOwner?> {
                    val viewLifecycleOwner = it ?: return@Observer
                    viewLifecycleOwner.lifecycle.addObserver(object : DefaultLifecycleObserver {
                        override fun onDestroy(owner: LifecycleOwner) {
                            binding = null
                        }
                    })
                }
            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observeForever(
                    viewLifecycleOwnerLiveDataObserver
                )
            }

            /**
             * observer the fragment's onDestroy and remove the view binding observer
             */
            override fun onDestroy(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.removeObserver(
                    viewLifecycleOwnerLiveDataObserver
                )
            }
        })
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        val view = viewProvider?.invoke() ?: thisRef.requireView()
        return viewBindingFactory(view).also { this.binding = it }
    }
}

/**
 * This is extension function for viewBinding on the Fragment
 */
fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBinding(this, viewBindingFactory)

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T, viewProvider: (() -> View?)?) =
    FragmentViewBinding(this, viewBindingFactory, viewProvider)