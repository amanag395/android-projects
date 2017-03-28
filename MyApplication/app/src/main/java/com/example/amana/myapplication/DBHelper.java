package com.example.amana.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static android.R.attr.version;
import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aMAN GUPTA on 2/27/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase myDB;
    public static final String DBNAME = "database";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("helper","onCreate");
        db.execSQL("CREATE TABLE IF NOT EXISTS RegesterUser(Name VARCHAR,Username VARCHAR,Password VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE IF NOT EXISTS tempUser4(Name VARCHAR,Username VARCHAR,Password VARCHAR);");
    }

    public boolean insertContact (String name, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Username", phone);
        contentValues.put("Password", email);
        db.insert("RegesterUser", null, contentValues);

        contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Username", phone);
        contentValues.put("Password", email);
        db.insert("tempUser5", null, contentValues);

        return true;
    }
    /*public void insertValues(String name,String userName,String password){
        myDB.execSQL("INSERT INTO RegesterUser VALUES('"+name+"','"+userName+"','"+password+"');");
    }

    public ArrayList<String> getNames(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor resultSet = db.rawQuery("SELECT * FROM RegesterUser",null);
        resultSet.moveToFirst();

        while(resultSet.isAfterLast() == false){
            list.add(resultSet.getString(resultSet.getColumnIndex("name")));
            resultSet.moveToNext();
        }
        return list;
    }*/
}
