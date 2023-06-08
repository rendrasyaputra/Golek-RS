package com.example.golekrs;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Sardjito = new LatLng(-7.768575, 110.3734782);
        mMap.addMarker(new MarkerOptions().position(Sardjito).title("RSUP Sardjito"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Sardjito,12));

        LatLng Rsudkota = new LatLng(-7.8258225, 110.3758179);
        mMap.addMarker(new MarkerOptions().position(Rsudkota).title("RSUD Kota Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rsudkota,13));

        LatLng Rspku = new LatLng(-7.8007352, 110.3601221);
        mMap.addMarker(new MarkerOptions().position(Rspku).title("RSU PKU Muhammadiyah Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Rspku,14));

        LatLng hida = new LatLng(-7.8153295, 110.3855665);
        mMap.addMarker(new MarkerOptions().position(hida).title("RSI Hidayatullah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hida,15));

        LatLng Bi = new LatLng(-7.814845, 110.3793402);
        mMap.addMarker(new MarkerOptions().position(Bi).title("Rumah Sakit Bhakti Ibu"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bi,11));

    }
}