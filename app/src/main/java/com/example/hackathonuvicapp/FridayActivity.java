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

public class FridayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friday);

        ConfigurePrev();
        ConfigureNext();
        //addClass();
    }

    private void ConfigurePrev() {
        ImageButton prevButton = (ImageButton) findViewById(R.id.btnFriThu);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FridayActivity.this, ThursdayActivity.class));
            }

        });
    }

    private void ConfigureNext() {
        ImageButton nextButton = (ImageButton) findViewById(R.id.btnFriMon);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FridayActivity.this, MondayActivity.class));
            }

        });
    }
}
