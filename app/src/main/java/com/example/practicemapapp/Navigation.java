package com.example.practicemapapp;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.util.GeoPoint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.lang.Double;

public class Navigation extends AppCompatActivity implements OnItemSelectedListener {

    ArrayList<Marker> markerList = MainActivity.getMarkerList();
    String[] markerArray = markerArraylistToArray(markerList);
    ArrayList<GeoPoint> geopointList = MainActivity.getGeoPointsList();
    double[][] geopointArray = geopointArraylistToArray(geopointList);

    String startString;
    String destString;

    ArrayAdapter adapterStart;
    ArrayAdapter adapterDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);


        Spinner startingPointSpinner = findViewById(R.id.StartingPointSpinner);
        Spinner destinationSpinner = findViewById(R.id.DestinationSpinner);


        adapterStart = new ArrayAdapter(this, android.R.layout.simple_spinner_item, markerArray);
        adapterStart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startingPointSpinner.setAdapter(adapterStart);

        adapterDest = new ArrayAdapter(this, android.R.layout.simple_spinner_item, markerArray);
        adapterDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(adapterDest);

        final Button goButton = findViewById(R.id.GoButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //System.out.println(startString);
                //System.out.print(destString);
                EditText editTextStart = findViewById(R.id.startText);
                editTextStart.setText(startString);

                EditText editTextDest = findViewById(R.id.destText);
                editTextDest.setText(destString);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), markerArray[position], Toast.LENGTH_LONG).show();
        if (id == R.id.StartingPointSpinner) startString = markerArray[position];
        if (id == R.id.DestinationSpinner) destString = markerArray[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public String[] markerArraylistToArray(ArrayList<Marker> arr) {
        String[] mArr = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            mArr[i] = arr.get(i).getTitle();
        }
        return mArr;
    }

    public double[][] geopointArraylistToArray(ArrayList<GeoPoint> arr) {
        double[][] gArr = new double[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) gArr[i][j] = arr.get(i).getLatitude();
                else gArr[i][j] = arr.get(i).getLongitude();
            }
        }
        return gArr;
    }
}
