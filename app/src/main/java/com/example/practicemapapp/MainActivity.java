package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.preference.PreferenceManager;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.api.IMapController;

public class MainActivity extends Activity {
    MapView map = null;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // IMPORTANT: handle permissions before map is created.
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);

        // OSM Map Initialize
        // important! set your user agent to prevent getting banned from the osm servers
        //Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        IMapController mapController = map.getController();
        startMapView(mapController);
        //mapController.setZoom(17);
        //GeoPoint startPoint = new GeoPoint(36.214201, -81.679850);
        //mapController.setCenter(startPoint);



        // Setup MapView
        //setupMapView();
    }

    public void startMapView(IMapController mc) {
        mc.setZoom(17);
        GeoPoint startPoint = new GeoPoint(36.214201, -81.679850);
        mc.setCenter(startPoint);
    }


}