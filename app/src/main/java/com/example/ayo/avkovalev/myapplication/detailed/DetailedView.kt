package com.example.ayo.avkovalev.myapplication.detailed

import android.view.View
import android.widget.TextView
import com.example.ayo.avkovalev.myapplication.R


interface DetailedView {

    fun setCityName(name: String)

    fun setTemperature(temp: Double)

    fun setClouds(value: Int)

    fun setRain(value: Int)

    fun setWind(value: Int)

}

class DetailedViewImpl(view: View) : DetailedView {

    val cityName = view.findViewById<TextView>(R.id.cityName)
    val tempView = view.findViewById<TextView>(R.id.temp)

    override fun setCityName(name: String) {
        cityName.text = name
    }

    override fun setTemperature(temp: Double) {
        tempView.text = temp.toString()
    }

    override fun setClouds(value: Int) {

    }

    override fun setRain(value: Int) {

    }

    override fun setWind(value: Int) {

    }

}