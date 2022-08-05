package com.example.mytopdestinations.presentation.features.topdestinations

import android.os.Bundle
import com.example.mytopdestinations.databinding.ActivityTopDestinationsBinding
import com.example.mytopdestinations.presentation.common.BaseActivity
import com.example.mytopdestinations.presentation.utilities.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopDestinationsActivity : BaseActivity() {

    private val viewBinding by viewBinding(ActivityTopDestinationsBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
    }
}