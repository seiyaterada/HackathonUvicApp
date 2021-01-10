package com.example.hackathonuvicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        configureScheduleButton();
        logoutConfiguration();
    }

    private void configureScheduleButton(){
        Button homeButton = (Button) findViewById(R.id.btnSchedule);
        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MondayActivity.class));
            }
        });
    }

    public void logoutConfiguration () {
        Button homeButton = findViewById(R.id.btnLogOut);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut(); //logout
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}