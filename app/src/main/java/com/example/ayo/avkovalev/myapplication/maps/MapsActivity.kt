package com.example.ayo.avkovalev.myapplication.maps

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ayo.avkovalev.myapplication.R
import com.example.ayo.avkovalev.myapplication.detailed.createDetailedActivityIntent
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapLongClick(coord: LatLng) {
        val intent = createDetailedActivityIntent(this, coord.latitude, coord.longitude)
        startActivity(intent)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.setOnMapLongClickListener(this)


//        val lastKnowLocation = new
//        if (lastKnowLocation != null) {
//            map.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lastKnowLocation.latitude, lastKnowLocation.longitude), 13f))
//
//            val cameraPosition = CameraPosition.Builder()
//                    .target(LatLng(lastKnowLocation.latitude, lastKnowLocation.longitude))
//                    .zoom(17f)
//                    .bearing(90f)
//                    .tilt(40f)
//                    .build()
//            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
//        }
//        map.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
