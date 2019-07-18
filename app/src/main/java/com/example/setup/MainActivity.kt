package com.example.setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esri.arcgisruntime.geometry.Point
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.Basemap
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay
import com.esri.arcgisruntime.mapping.view.MapView


class MainActivity : AppCompatActivity() {

    private lateinit var mMapView: MapView
    private val mGraphicsOverlay: GraphicsOverlay? = null
    private val mStart: Point? = null
    private val mEnd: Point? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMapView = findViewById(R.id.mapView)
        setupMap()
    }

    private fun setupMap() {
        val baseMapType: Basemap.Type = Basemap.Type.STREETS_VECTOR
        val latitude = 34.09042
        val longitude: Double = -118.71511
        val levelOfDetail= 11
        val map = ArcGISMap(baseMapType, latitude, longitude, levelOfDetail)
        mMapView.map = map
    }

    override fun onPause() {
        mMapView.pause()
        super.onPause()
    }

    override fun onResume() {
        mMapView.resume()
        super.onResume()
    }

    override fun onDestroy() {
        mMapView.dispose()
        super.onDestroy()
    }
}
