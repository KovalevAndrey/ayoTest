package com.example.ayo.avkovalev.myapplication.di

import com.example.ayo.avkovalev.myapplication.AyoApplication
import com.example.ayo.avkovalev.myapplication.detailed.DetailedActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: AyoApplication)

    fun inject(activity: DetailedActivity)
}