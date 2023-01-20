package com.ulch.rickandmorty.application

import android.app.Application
import com.ulch.rickandmorty.di.KoinInjector

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInjector.setup(this)
    }
}