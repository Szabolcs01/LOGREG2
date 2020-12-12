package com.example.logge2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper  {

     static   String name= "felhasznalo.db";
      static  int   version= 1;
String createTableUser="CREATE TABLE if not exist  \"felhasznalo \" (\n" +
        "\t\"id\"\tINTEGER,\n" +
        "\t\"email\"\tTEXT NOT NULL,\n" +
        "\t\"felhnev\"\tTEXT NOT NULL,\n" +
        "\t\"jelszo\"\tTEXT NOT NULL,\n" +
        "\t\"teljesnev\"\tTEXT NOT NULL,\n" +
        "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
        ")";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        getWritableDatabase().execSQL(createTableUser);


    }
public void insertUser(ContentValues contentValues)
{
    getWritableDatabase().insert("felhasznalo","",contentValues);
}

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
