package com.example.amangupta.userlistfromdb.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.amangupta.userlistfromdb.application.MyApplication;
import com.example.amangupta.userlistfromdb.helper.DBHelper;
import com.example.amangupta.userlistfromdb.model.User;

import java.util.ArrayList;

public class RegisterUser implements Table {
    private static final String DBNAME = RegisterUserConctants.DATABASE_NAME;
    private static DBHelper dbHelper;
    private static RegisterUser registerUser;
    static {
        registerUser = new RegisterUser();
        dbHelper = new DBHelper(MyApplication.getApplication().getApplicationContext(),DBNAME);
        DBHelper.addTable(registerUser);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RegisterUserConctants.TABLE_CREATE_QUERY);
    }

    public static RegisterUser getRegisterUser() {
        return registerUser;
    }

    public interface RegisterUserConctants{
        String DATABASE_NAME = "database";
        String TABLE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS RegesterUser(Name VARCHAR PRIMARY KEY,Age VARCHAR);";
        String TABLE_NAME = "RegesterUser";
        String SELECT_ALL_QUERY = "SELECT * FROM RegesterUser";
        String DELETE_QUERY = "DELETE FROM RegesterUser WHERE Name ='";
        String NAME = "Name";
        String Age = "Age";

    }

    public boolean insertUser(User user) {
        String name = user.getName();
        String age = user.getAge();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RegisterUserConctants.NAME, name);
        contentValues.put(RegisterUserConctants.Age, age);
        return -1 != db.insert(RegisterUserConctants.TABLE_NAME, null, contentValues);
    }
    public void deleteUser(User user) {
        String name = user.getName();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(RegisterUserConctants.DELETE_QUERY+name+"'");
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor resultSet = db.rawQuery(RegisterUserConctants.SELECT_ALL_QUERY,null);
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            User user = new User(null,null);
            user.setName(resultSet.getString(resultSet.getColumnIndex(RegisterUserConctants.NAME)));
            user.setAge(resultSet.getString(resultSet.getColumnIndex(RegisterUserConctants.Age)));
            list.add(user);
            resultSet.moveToNext();
        }
        return list;
    }
}
