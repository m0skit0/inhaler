package org.m0skit0.android.inhaler

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InhalerApplication : Application() {

    companion object {
        lateinit var instance: InhalerApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
