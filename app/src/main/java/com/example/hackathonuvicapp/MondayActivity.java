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

    public class MondayActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.monday);

            ConfigurePrev();
            ConfigureNext();
            //addClass();
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


//          alertdialog beginning
//        private void addClass() {
//            Button addClassButton = (Button) findViewById(R.id.btnNew);
//            addClassButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MondayActivity.this);
//                    builder.setMessage("This is a test")
//                            .setPositiveButton("Testing", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    btnClass.setText("Here is some stuff");
//                                }
//                            });
//                    startActivity(new Intent(MondayActivity.this, MondayActivityOneCourse.class));
//                }
//            });
//        }
}
