package com.example.ayo.avkovalev.myapplication.remote

import com.google.gson.annotations.SerializedName

class Coordinates(@SerializedName("lon") val long: Double, @SerializedName("lat") val lat: Double)
