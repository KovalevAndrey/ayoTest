package com.example.ayo.avkovalev.myapplication.remote

import com.google.gson.annotations.SerializedName

class Weather(@SerializedName("id") val id: Int,
              @SerializedName("main") val main: String,
              @SerializedName("description") val description: String)