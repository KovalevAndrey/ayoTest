package com.example.ayo.avkovalev.myapplication.remote

import com.google.gson.annotations.SerializedName

class Wind(@SerializedName("speed") val speed: Double, @SerializedName("deg") val deg: Double)