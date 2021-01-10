package com.example.hackathonuvicapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coverpage);

        configureLoginButton();
        configureSignupButton();
    }

    private void configureLoginButton(){
        Button loginPageButton = (Button) findViewById(R.id.btnSignIn);
        loginPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        });
    }
    private void configureSignupButton(){
        Button loginPageButton = (Button) findViewById(R.id.btnGoToSignup);
        loginPageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
            }

        });
    }

}