package com.example.logge2;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText re_email,re_teljesNev,re_password,re_felhasznaloNev;
    Button regisztracioelkuldese,visszabejelentkezeshez;
DBHelper dbHelper;
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
        dbHelper=new DBHelper(this);

        regisztracioelkuldese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emailValue=re_email.getText().toString();
                String teljesnevlValue=re_teljesNev.getText().toString();
                String passwordValue=re_password.getText().toString();
                String usernameValue=re_felhasznaloNev.getText().toString();
                if (re_email.getText().toString().trim().equals(" "))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg e-mailt!!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else   if (re_teljesNev.getText().toString().trim().equals(" "))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg teljesnevet nevet !!!",Toast.LENGTH_SHORT);
                    toast.show();
                } else   if (re_password.getText().toString().trim().equals(" "))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg jelszót !!!",Toast.LENGTH_SHORT);
                    toast.show();
                } else   if (re_felhasznaloNev.getText().toString().trim().equals(" "))
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Nem adtál meg felhasználó nevet !!!",Toast.LENGTH_SHORT);
                    toast.show();
                }
              else  if (usernameValue.length()>1 )
                {
                    ContentValues contentValues=new ContentValues();
                    contentValues.put("email",emailValue);
                    contentValues.put("felhnev",usernameValue);
                    contentValues.put("jelszo",passwordValue);
                    contentValues.put("teljesnev",teljesnevlValue);

                    dbHelper.insertUser(contentValues);
                    Toast.makeText(Register.this,"Sikeres regisztráció",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Register.this,"Sikertelen regisztráció",Toast.LENGTH_SHORT).show();
                }
            }


        });
        visszabejelentkezeshez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(Register.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

    }
}
