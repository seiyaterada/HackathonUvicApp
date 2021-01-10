package com.example.hackathonuvicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import directionhelpers.FetchURL;
import directionhelpers.TaskLoadedCallback;

public class ExploreMapActivity extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback {

    GoogleMap map;

    Button btnGetDirection;
    MarkerOptions begin, end;
    Polyline currentPolyline;

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        String mode = "mode=" + directionMode;

        String parameters = str_origin + "&" + str_dest + "&" + mode;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.map_key);
        return url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploremap);
        btnGetDirection = findViewById(R.id.btnGetDirection);
        btnGetDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FetchURL(ExploreMapActivity.this).execute(getUrl(begin.getPosition(), end.getPosition(), "driving"), "driving");
            }
        });
        begin = new MarkerOptions().position(new LatLng(48.463427, -123.311385)).title("Start");
        end = new MarkerOptions().position(new LatLng(48.461299941502084, -123.31151413906024)).title("Destination");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Uvic = new LatLng(48.463427, -123.311385);
        map.addMarker(new MarkerOptions().position(Uvic).title("University of Victoria"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Uvic));
        map.setMinZoomPreference(16f);
        map.setMaxZoomPreference(19.0f);

    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        currentPolyline = map.addPolyline((PolylineOptions) values[0]);
    }
}