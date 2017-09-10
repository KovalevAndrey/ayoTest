package com.example.ayo.avkovalev.myapplication

import android.app.Application
import com.example.ayo.avkovalev.myapplication.di.ApplicationComponent
import com.example.ayo.avkovalev.myapplication.di.ApplicationModule
import com.example.ayo.avkovalev.myapplication.di.DaggerApplicationComponent

class AyoApplication : Application() {

    companion object {
        lateinit var instance: AyoApplication
    }

    private var component: ApplicationComponent? = null

    override fun onCreate() {
        instance = this
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        component!!.inject(this)
    }

    fun getComponent(): ApplicationComponent {
        return component!!
    }
}