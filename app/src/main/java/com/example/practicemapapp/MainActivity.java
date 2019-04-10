package com.example.practicemapapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Context;
import android.preference.PreferenceManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.ActivityCompat;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.overlay.infowindow.MarkerInfoWindow;
import org.osmdroid.views.overlay.Marker;



public class MainActivity extends Activity {
    MapView map;
    IMapController mapController;

    LocationManager locationManager;

    Marker srcMarker;
    Marker walkerMarker;
    Button navigate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // IMPORTANT: handle permissions before map is created.
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);

        // OSM Map Initialize
        // important! set your user agent to prevent getting banned from the osm servers
        //Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(17);
        GeoPoint startPoint = new GeoPoint(36.214201, -81.679850);
        mapController.setCenter(startPoint);



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        srcMarker = new Marker(map);
        GeoPoint srcPoint = new GeoPoint(36.216649, -81.686158);
        srcMarker.setPosition(srcPoint);
        srcMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        srcMarker.setTitle("Student Recreation Center (SRC)");
        map.getOverlays().add(srcMarker);

        walkerMarker = new Marker(map);
        GeoPoint walkerPoint = new GeoPoint(36.216868, -81.684925);
        walkerMarker.setPosition(walkerPoint);
        walkerMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        walkerMarker.setTitle("Walker Hall");
        map.getOverlays().add(walkerMarker);

        navigate = findViewById(R.id.navigate);
        navigate.bringToFront();
        navigate.invalidate();
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewNavigation = new Intent(MainActivity.this, Navigation.class);
                startActivity(viewNavigation);
            }

        });

    }



}