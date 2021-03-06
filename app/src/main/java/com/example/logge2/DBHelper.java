package com.example.logge2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper  {

     static   String name= "felhasznalo.db";
      static  int   version= 1;
String createTableUser="CREATE TABLE if not exists `felhasznalo`(`id` INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "`email`TEXT NOT NULL,"+" `felhnev` TEXT NOT NULL,"+"`jelszo`TEXT NOT NULL,"+
        "`teljesnev` TEXT NOT NULL)";

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
        getWritableDatabase().execSQL(createTableUser);


    }
public void insertUser(ContentValues contentValues)
{
    getWritableDatabase().insert("felhasznalo","",contentValues);
}
public boolean isLoginValid(String felhnev,String jelszo)
{
    String sql="Select count(*) from user where felhnev='"+felhnev+"'and jelszo='"+jelszo+"'";
    SQLiteStatement statement=getReadableDatabase().compileStatement(sql);
    long l=statement.simpleQueryForLong();
    statement.close();
    if (l==1)
    {
        return true;
    }
    else
    {
        return false;
    }

}

public boolean isLoginemail(String email,String jelszo)
{
    String sql="Select count(*) from user where email='"+email+"'and jelszo='"+jelszo+"'";
    SQLiteStatement statement=getReadableDatabase().compileStatement(sql);
    long l=statement.simpleQueryForLong();
    statement.close();
    if (l==1)
    {
        return true;
    }
    else
    {
        return false;
    }
}

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
