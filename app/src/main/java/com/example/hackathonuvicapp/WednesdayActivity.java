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

public class WednesdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wednesday);

        ConfigurePrev();
        ConfigureNext();
        //addClass();
    }

    private void ConfigurePrev() {
        ImageButton prevButton = (ImageButton) findViewById(R.id.btnWedTues);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WednesdayActivity.this, TuesdayActivity.class));
            }

        });
    }

    private void ConfigureNext() {
        ImageButton nextButton = (ImageButton) findViewById(R.id.btnWedThu);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WednesdayActivity.this, ThursdayActivity.class));
            }

        });
    }
}
