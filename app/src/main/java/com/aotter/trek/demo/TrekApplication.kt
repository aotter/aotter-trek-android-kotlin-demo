package com.aotter.trek.demo

import android.app.Application

class TrekApplication : Application() {

    companion object {
        lateinit var context: TrekApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}