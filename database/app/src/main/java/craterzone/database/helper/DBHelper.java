package craterzone.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import craterzone.database.model.User;

/**
 * Created by aMAN GUPTA on 2/27/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "database";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS RegesterUser(Name VARCHAR,Username VARCHAR PRIMARY KEY,Password VARCHAR,Describe VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser(String name, String userName, String password, String descrive) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Username", userName);
        contentValues.put("Password", password);
        contentValues.put("Describe", descrive);
        if (db.insert("RegesterUser", null, contentValues) == -1) {
            return false;
        }
        return true;
    }

    public User getUser(String userName, String password) {
        User user = null;

        SQLiteDatabase db = getReadableDatabase();
        Cursor resultSet = db.rawQuery("SELECT * FROM RegesterUser", null);
        resultSet.moveToFirst();

        while (resultSet.isAfterLast() == false) {
            if (resultSet.getString(resultSet.getColumnIndex("Username")).equals(userName) && resultSet.getString(resultSet.getColumnIndex("Password")).equals(password)) {
                user = new User();
                user.setName(resultSet.getString(resultSet.getColumnIndex("Name")));
                user.setUserName(resultSet.getString(resultSet.getColumnIndex("Username")));
                user.setPassword(resultSet.getString(resultSet.getColumnIndex("Password")));
                user.setDescribe(resultSet.getString(resultSet.getColumnIndex("Describe")));

            }
            resultSet.moveToNext();
        }
        return user;
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor resultSet = db.rawQuery("SELECT * FROM RegesterUser",null);
        resultSet.moveToFirst();

        while(resultSet.isAfterLast() == false){
            User user = new User();
            user.setName(resultSet.getString(resultSet.getColumnIndex("Name")));
            user.setUserName(resultSet.getString(resultSet.getColumnIndex("Username")));
            user.setPassword(resultSet.getString(resultSet.getColumnIndex("Password")));
            user.setDescribe(resultSet.getString(resultSet.getColumnIndex("Describe")));
            list.add(user);
            resultSet.moveToNext();
        }
        return list;
    }

}
