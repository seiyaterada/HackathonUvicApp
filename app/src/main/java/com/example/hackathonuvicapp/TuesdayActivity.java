package com.example.hackathonuvicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TuesdayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuesday);

        ConfigurePrev();
        ConfigureNext();
    }

    private void ConfigurePrev(){
        ImageButton prevButton = (ImageButton) findViewById(R.id.btnTueMon);
        prevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TuesdayActivity.this, MondayActivity.class));
            }

        });
    }

    private void ConfigureNext(){
        ImageButton nextButton = (ImageButton) findViewById(R.id.btnTueWed);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TuesdayActivity.this, MondayActivity.class));
            }

        });
    }
}
