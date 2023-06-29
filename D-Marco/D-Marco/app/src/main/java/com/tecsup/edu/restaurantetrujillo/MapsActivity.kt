package com.tecsup.edu.restaurantetrujillo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.tecsup.edu.restaurantetrujillo.R

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var titleTextView: TextView

    private var chanChanMarker: Marker? = null
    private var senorSipanMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        titleTextView = findViewById(androidx.core.R.id.title)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val title = intent.getStringExtra("title")
        titleTextView.text = title
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val latitude = intent.getDoubleExtra("latitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        val location = LatLng(latitude, longitude)

        if (title == "Chan Chan") {
            if (chanChanMarker == null) {
                chanChanMarker = mMap.addMarker(MarkerOptions().position(location).title(title).snippet(description))
            } else {
                chanChanMarker?.position = location
                chanChanMarker?.title = title
                chanChanMarker?.snippet = description
            }
            chanChanMarker?.showInfoWindow()
        } else if (title == "Señor de Sipán") {
            if (senorSipanMarker == null) {
                senorSipanMarker = mMap.addMarker(MarkerOptions().position(location).title(title).snippet(description))
            } else {
                senorSipanMarker?.position = location
                senorSipanMarker?.title = title
                senorSipanMarker?.snippet = description
            }
            senorSipanMarker?.showInfoWindow()
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }
}
