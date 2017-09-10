package com.example.ayo.avkovalev.myapplication.remote

import com.google.gson.annotations.SerializedName

class WeatherResponse(@SerializedName("coord") val coordinates: Coordinates,
                      @SerializedName("wind") val wind: Wind,
                      @SerializedName("main") val main: Main,
                      @SerializedName("clouds") val clouds: Clouds,
                      @SerializedName("snow") val snow: Snow,
                      @SerializedName("rain") val rain: Rain,
                      @SerializedName("name") val name: String)