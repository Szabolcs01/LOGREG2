package com.example.logge2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText re_email,re_teljesNev,re_password,re_felhasznaloNev;
    Button regisztracioelkuldese,visszabejelentkezeshez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        re_email=findViewById(R.id.re_email);
        re_teljesNev=findViewById(R.id.re_teljesNev);
        re_password=findViewById(R.id.re_password);
        re_felhasznaloNev=findViewById(R.id.re_felhasznaloNev);
        regisztracioelkuldese=findViewById(R.id.regisztracioelkuldese);
        visszabejelentkezeshez=findViewById(R.id.visszabejelentkezeshez);


        regisztracioelkuldese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue=re_email.getText().toString();
                String teljesnevlValue=re_teljesNev.getText().toString();
                String passwordValue=re_password.getText().toString();
                String usernameValue=re_felhasznaloNev.getText().toString();
            }
        });

    }
}
