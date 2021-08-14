package org.journey.tridy_android.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TridyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}