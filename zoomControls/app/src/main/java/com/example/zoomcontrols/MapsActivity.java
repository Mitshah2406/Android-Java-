package com.example.zoomcontrols;

import androidx.fragment.app.FragmentActivity;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Polyline routePolyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng start = new LatLng(35.4542, 150.4567);
        LatLng end = new LatLng(45.4542, 150.4567);

        mMap.addMarker(new MarkerOptions().position(start).title("Start"));
        mMap.addMarker(new MarkerOptions().position(end).title("End"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(start));
        drawRoute(start,end);
    }
    private void drawRoute(LatLng start, LatLng end){
        PolylineOptions pO = new PolylineOptions().add(start,end).color(Color.BLUE).width(9);
        routePolyline = mMap.addPolyline(pO);
    }
}