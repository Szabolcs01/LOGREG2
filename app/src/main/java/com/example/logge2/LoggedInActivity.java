package com.example.logge2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoggedInActivity extends AppCompatActivity {
    Button btnVissza;
    TextView userName;
    DBHelper dbHelper;
    SharedPreferences sharedPref;
    private void init() {
        btnVissza = findViewById(R.id.btnVissza);
        userName = findViewById(R.id.userName);
        dbHelper = new DBHelper(LoggedInActivity.this);
        sharedPref = getSharedPreferences("adatok", Context.MODE_PRIVATE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged);

        init();
        String nev = sharedPref.getString("nev","");
        String jelszo = sharedPref.getString("jelszo","");
        StringBuilder builder = new StringBuilder();
        userName.setText(builder.toString());

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent visszaMainre = new Intent(LoggedInActivity.this, MainActivity.class);
                startActivity(visszaMainre);
                finish();
            }
        });
    }
}
