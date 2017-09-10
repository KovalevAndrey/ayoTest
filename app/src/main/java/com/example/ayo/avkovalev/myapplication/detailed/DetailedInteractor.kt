package com.example.ayo.avkovalev.myapplication.detailed

import com.example.ayo.avkovalev.myapplication.remote.OpenWeatherApi
import com.example.ayo.avkovalev.myapplication.remote.WeatherResponse
import io.reactivex.Observable

interface DetailedInteractor {

    fun loadWeather(lon: Double, lat: Double): Observable<WeatherResponse>
}

class DetailedInteractorImpl(private val api: OpenWeatherApi, private val storage: WeatherStorage) : DetailedInteractor {

    override fun loadWeather(lon: Double, lat: Double): Observable<WeatherResponse> {
        return api.
                getWeather(lon, lat, "d02ddf771c5d35c089977337e6ffbe44")
                .doOnNext {
                    storage.storeWeather(it)
                }
                .onErrorReturn {
                    storage.getWeather()!!
                }
    }

}