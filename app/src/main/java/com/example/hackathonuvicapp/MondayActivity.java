package com.example.hackathonuvicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

    public class MondayActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.monday);

            ConfigurePrev();
            ConfigureNext();
        }

        private void ConfigurePrev(){
            ImageButton prevButton = (ImageButton) findViewById(R.id.btnMonFri);
            prevButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MondayActivity.this, LoginActivity.class));
                }

            });
        }

        private void ConfigureNext(){
            ImageButton nextButton = (ImageButton) findViewById(R.id.btnMonTue);
           nextButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MondayActivity.this, TuesdayActivity.class));
                }

            });
        }
}
