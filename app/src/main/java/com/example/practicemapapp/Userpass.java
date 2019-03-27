package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Userpass extends Activity{

    Button login;           // button is login button

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usrpass);

        // button listener for the login button
        login = findViewById(R.id.button4);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewUserpass = new Intent(Userpass.this, Userpass.class);
                startActivity(viewUserpass);
            }

        });
    }
}
