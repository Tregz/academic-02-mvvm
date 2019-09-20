package com.tregz.mvvm

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class MvvmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // vector drawables on older platforms (< API 21)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}