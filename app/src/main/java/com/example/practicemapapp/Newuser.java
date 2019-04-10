package com.example.practicemapapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Newuser extends Activity{

    Button login;           // button is login button

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newusr);

        // button listener for the login button
        login = findViewById(R.id.button6);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewNewUser = new Intent(Newuser.this, MainActivity.class);
                startActivity(viewNewUser);
            }

        });
    }
}
