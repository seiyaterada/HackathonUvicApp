package com.example.hackathonuvicapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static java.security.AccessController.getContext;

public class MondayActivity extends AppCompatActivity {

        String mCourse, mBuilding, mTime, userID;
        FirebaseAuth fAuth;
        FirebaseFirestore fStore;
        DocumentReference documentReference1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.monday);

            fAuth = FirebaseAuth.getInstance();
            fStore = FirebaseFirestore.getInstance();

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


        //alertdialog beginning
        private void addClass() {
            Button addClassButton = findViewById(R.id.btnNew);
            addClassButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MondayActivity.this);
                    builder.setTitle("Add Course");
                    View viewInflated = LayoutInflater.from(MondayActivity.this).inflate(R.layout.dialogitems, (ViewGroup) findViewById(android.R.id.content), false);
                    // Set up the input
                    final EditText courseInput = viewInflated.findViewById(R.id.textCourse);
                    final EditText buildingInput = viewInflated.findViewById(R.id.textBuilding);
                    // Specify the type of input expected
                    builder.setView(viewInflated);

                    // Set up the buttons
                    builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mCourse = courseInput.getText().toString();
                            mBuilding = buildingInput.getText().toString();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            DocumentReference documentReference1 = fStore.collection("/users/"+userID+"/courses").document(mCourse);
                            Map<String, Object> courses = new HashMap<>();
                            courses.put("cName", mCourse);
                            courses.put("bName", mBuilding);
                            documentReference1.set(courses).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "onSuccess: DB created for" + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", "onFailure: "+ e.toString());
                                }
                            });
                            dialog.dismiss();
                        }
                    });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
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
