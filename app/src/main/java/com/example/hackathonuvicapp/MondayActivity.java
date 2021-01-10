package com.example.hackathonuvicapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

    public class MondayActivity extends AppCompatActivity {

        String m_Text;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.monday);

            ConfigurePrev();
            ConfigureNext();
            addClass();
        }

        private void ConfigurePrev() {
            ImageButton prevButton = (ImageButton) findViewById(R.id.btnMonFri);
            prevButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MondayActivity.this, FridayActivity.class));
                }

            });
        }

        private void ConfigureNext() {
            ImageButton nextButton = (ImageButton) findViewById(R.id.btnMonTue);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MondayActivity.this, TuesdayActivity.class));
                }

            });
        }


        //          alertdialog beginning
        private void addClass() {
            Button addClassButton = findViewById(R.id.btnNew);
            addClassButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MondayActivity.this);
                    builder.setTitle("Add Course");

                    // Set up the input
                    final EditText input = new EditText(MondayActivity.this);
                    // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    // Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                }

            });
        }
    }
