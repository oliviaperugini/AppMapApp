package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;

public class MainActivity extends Activity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView mMapView = (MapView) findViewById(R.id.map);


        // OSM Map Initialize
        // important! set your user agent to prevent getting banned from the osm servers
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        // Setup MapView
        //setupMapView();
    }
}