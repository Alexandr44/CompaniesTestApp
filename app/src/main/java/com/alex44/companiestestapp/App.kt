package com.alex44.companiestestapp

import android.app.Application
import timber.log.Timber


class App : Application() {

    companion object{
        lateinit var instance : App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
    }

}