package com.example.amangupta.userlistfromdb.application;

import android.app.Application;
import android.content.res.TypedArray;

import com.example.amangupta.userlistfromdb.R;

/**
 * Created by aMAN GUPTA on 3/27/2017.
 */

public class MyApplication extends Application {
    private static MyApplication application;
//    TypedArray typedArray = getResources().obtainTypedArray(R.array.tables);

    public MyApplication(){
        application = this;
        try {
            Class.forName("com.example.amangupta.userlistfromdb.table.RegisterUser");
//            Class.forName((String) typedArray.getText(0));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MyApplication getApplication() {
        return application;
    }
}
