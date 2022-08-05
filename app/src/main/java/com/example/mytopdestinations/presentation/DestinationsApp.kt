package com.example.mytopdestinations.presentation

import android.app.Application
import com.example.mytopdestinations.data.networking.EndPointConfiguration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class DestinationsApp : Application() {

    @Inject
    lateinit var endPointConfiguration: EndPointConfiguration
}