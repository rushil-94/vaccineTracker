package com.rushil.navigationexample.misc

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}