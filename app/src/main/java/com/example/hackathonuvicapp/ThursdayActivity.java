package com.example.hackathonuvicapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThursdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thursday);

        ConfigurePrev();
        ConfigureNext();
        //addClass();
    }

    private void ConfigurePrev() {
        ImageButton prevButton = (ImageButton) findViewById(R.id.btnThuWed);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThursdayActivity.this, WednesdayActivity.class));
            }

        });
    }

    private void ConfigureNext() {
        ImageButton nextButton = (ImageButton) findViewById(R.id.btnThuFri);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThursdayActivity.this, FridayActivity.class));
            }

        });
    }
}
