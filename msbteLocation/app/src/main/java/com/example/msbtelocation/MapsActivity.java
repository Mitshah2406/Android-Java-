package com.example.msbtelocation;

import androidx.fragment.app.FragmentActivity;

import android.location.*;
import android.os.Bundle;
import android.widget.*;
import java.io.*;
import java.util.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geoCoder;
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

//        Marker at MSBTE
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in MSBTE"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//        zoom controls

        UiSettings ui = mMap.getUiSettings();
        ui.setZoomControlsEnabled(true);


//        geocoding

        geoCoder = new Geocoder(this);
        try{
            String address = "Empire State Buliding";
            ArrayList<Address> coords = (ArrayList<Address>) geoCoder.getFromLocationName(address, 1);
            LatLng loc = new LatLng(coords.get(0).getLatitude(), coords.get(0).getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc).title("MArker at empire state building"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(loc));

    } catch (IOException e) {}

//        reverse geocoding

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick( LatLng latLng) {
//                toast for tapped location
                Toast.makeText(getApplicationContext(), latLng.latitude+", "+latLng.longitude, Toast.LENGTH_LONG).show();
                geoCoder = new Geocoder(getApplicationContext());
                try {
                    ArrayList<Address> addresses = (ArrayList<Address>) geoCoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    mMap.addMarker(new MarkerOptions().position(latLng).title("My Location"));
                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    Toast.makeText(getApplicationContext(), addresses.get(0).getAddressLine(0), Toast.LENGTH_LONG).show();
                } catch (IOException e) {}

            }
        });
    }
    }