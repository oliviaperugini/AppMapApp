package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Homepage extends Activity{

    Button login;           // button is login button
    Button register;        // button2 is register button
    Button viewMapButton;   // button3 is view map button

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // button listener for the login button
        login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent viewUserpass = new Intent(Homepage.this, Userpass.class);
                    startActivity(viewUserpass);
                }

        });

        // button listener for the register button
        register = findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewNewUser = new Intent(Homepage.this, Newuser.class);
                startActivity(viewNewUser);
            }

        });

        // button listener for the view map button on the homepage
        viewMapButton = findViewById(R.id.button3);
        viewMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentViewMap = new Intent(Homepage.this, MainActivity.class);
                startActivity(intentViewMap);
            }

        });


    }
}
