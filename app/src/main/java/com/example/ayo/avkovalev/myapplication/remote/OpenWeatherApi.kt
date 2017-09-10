package com.example.ayo.avkovalev.myapplication.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherApi {

    @GET("data/2.5/weather")
    fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appId") appId: String): Observable<WeatherResponse>

}