package com.example.ayo.avkovalev.myapplication.detailed

import android.preference.PreferenceManager
import com.example.ayo.avkovalev.myapplication.AyoApplication
import com.example.ayo.avkovalev.myapplication.remote.WeatherResponse
import com.google.gson.Gson


interface WeatherStorage {

    fun storeWeather(value: WeatherResponse)

    fun getWeather(): WeatherResponse?

}

class WeatherStorageImpl(application: AyoApplication) : WeatherStorage {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(application)

    override fun storeWeather(value: WeatherResponse) {
        val prefsEditor = prefs.edit()
        val gson = Gson()
        val json = gson.toJson(value)
        prefsEditor.putString("weather", json)
        prefsEditor.apply()
    }

    override fun getWeather(): WeatherResponse? {
        val gson = Gson()
        val json = prefs.getString("weather", null) ?: return null
        return gson.fromJson<WeatherResponse>(json, WeatherResponse::class.java)
    }

}