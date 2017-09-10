package com.example.ayo.avkovalev.myapplication.remote

import com.google.gson.annotations.SerializedName

class Main(@SerializedName("temp") val temp: Double,
           @SerializedName("pressure") val pressure: Double)