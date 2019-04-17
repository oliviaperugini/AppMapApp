package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class Navigation extends Activity{

    Button go;
    TextView pointA;
    TextView pointB;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentViewMap = new Intent(Navigation.this, MainActivity.class);
                pointA = findViewById(R.id.pointA);
                pointB = findViewById(R.id.pointB);
                intentViewMap.putExtra("pointA", String.valueOf(pointA));
                intentViewMap.putExtra("pointB", String.valueOf(pointB));
                startActivity(intentViewMap);
            }

        });






    }
}
