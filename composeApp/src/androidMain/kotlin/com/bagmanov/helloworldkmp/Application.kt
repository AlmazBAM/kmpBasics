package com.bagmanov.helloworldkmp

import android.app.Application
import com.bagmanov.helloworldkmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@Application)
        }
    }
}