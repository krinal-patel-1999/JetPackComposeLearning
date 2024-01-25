package com.shahenDemoCompose

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Shahen :Application() {
    companion object{
       var  appContext : Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}