package com.example.amangupta.userlistfromdb.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.amangupta.userlistfromdb.table.Table;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    //    static DBHelper dbHelper;
    private static ArrayList<Table> tables;

    static {
        tables = new ArrayList<>();
    }
//    private static final String DBNAME = RegisterUser.RegisterUserConctants.DATABASE_NAME;

    public static boolean addTable(Table table) {
        return tables.add(table);
    }

    public DBHelper(Context context, String DBNAME) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int index = 0; index < tables.size(); index++) {
            tables.get(index).onCreate(db);
        }
//        db.execSQL(Constants.TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*public boolean insertUser(User user) {
        String name = user.getName();
        String age = user.getAge();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.NAME, name);
        contentValues.put(Constants.Age, age);
        return -1 != db.insert(Constants.TABLE_NAME, null, contentValues);
    }*/

    /*public void deleteUser(User user) {
        String name = user.getName();
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(Constants.DELETE_QUERY+name+"'");
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor resultSet = db.rawQuery(Constants.SELECT_ALL_QUERY,null);
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            User user = new User(null,null);
            user.setName(resultSet.getString(resultSet.getColumnIndex(Constants.NAME)));
            user.setAge(resultSet.getString(resultSet.getColumnIndex(Constants.Age)));
            list.add(user);
            resultSet.moveToNext();
        }
        return list;
    }*/
}
