package com.example.hackathonuvicapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import com.example.hackathonuvicapp.directionhelpers.FetchURL;
import com.example.hackathonuvicapp.directionhelpers.TaskLoadedCallback;

public class ExploreMapActivity extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback {

    private GoogleMap map;

    Button btnGetDirection;
    private MarkerOptions begin, end;
    private Polyline currentPolyline;

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
                String url = getUrl(begin.getPosition(), end.getPosition(), "walking");
                new FetchURL(ExploreMapActivity.this).execute(url, "walking");
            }
        });
        begin = new MarkerOptions().position(new LatLng(48.463435689901374, -123.30971879296496)).title("Start");
        end = new MarkerOptions().position(new LatLng(48.461299941502084, -123.31151413906024)).title("Destination");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(begin);
        map.addMarker(end);

        LatLng Uvic = new LatLng(48.463435689901374, -123.30971879296496);
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