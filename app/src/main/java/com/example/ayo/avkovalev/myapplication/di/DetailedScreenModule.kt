package com.example.ayo.avkovalev.myapplication.di

import com.example.ayo.avkovalev.myapplication.detailed.DetailedInteractor
import com.example.ayo.avkovalev.myapplication.detailed.DetailedInteractorImpl
import com.example.ayo.avkovalev.myapplication.detailed.DetailedPresenter
import com.example.ayo.avkovalev.myapplication.detailed.DetailedPresenterImpl
import com.example.ayo.avkovalev.myapplication.remote.OpenWeatherApi
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(ApplicationModule::class))
class DetailedScreenModule(private val lon: Double, private val lat: Double) {



}