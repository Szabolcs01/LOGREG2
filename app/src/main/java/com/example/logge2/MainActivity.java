package com.example.logge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText re_userinput,re_passwordinput;
Button bejelentkezes,regisztracio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re_userinput=findViewById(R.id.re_userinput);
        re_passwordinput=findViewById(R.id.re_passwordinput);
        bejelentkezes=findViewById(R.id.bejelentkezes);
        regisztracio=findViewById(R.id.regisztracio);

        bejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String usernameValue=re_userinput.getText().toString();
             String passwordValue=re_passwordinput.getText().toString();

            }
        });

        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

    }
}