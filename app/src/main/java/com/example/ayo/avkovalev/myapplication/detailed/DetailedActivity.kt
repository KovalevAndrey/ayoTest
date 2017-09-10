package com.example.ayo.avkovalev.myapplication.detailed

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.example.ayo.avkovalev.myapplication.AyoApplication
import com.example.ayo.avkovalev.myapplication.R
import javax.inject.Inject

class DetailedActivity : AppCompatActivity() {

    @Inject lateinit var presenter: DetailedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AyoApplication.instance.getComponent().inject(this)
        val lon = intent.getDoubleExtra(KEY_LON, -0.11)
        val lat = intent.getDoubleExtra(KEY_LAT, 51.5)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val container = findViewById<ViewGroup>(R.id.container)
        val view = DetailedViewImpl(container)
        presenter.attachView(view)
        presenter.load(lon, lat)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}

fun createDetailedActivityIntent(context: Context, lon: Double, lat: Double): Intent =
        Intent(context, DetailedActivity::class.java)
                .putExtra(KEY_LON, lon)
                .putExtra(KEY_LAT, lat)

const val KEY_LON = "lon"
const val KEY_LAT = "lat"