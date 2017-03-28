package com.example.amangupta.pnv;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by aMAN GUPTA on 3/8/2017.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    private SharedPreferences sharedPreferences;

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        Log.d("aaa","onCreate");
        super.onCreate();
        this.myApplication = this;
        this.sharedPreferences = this.getSharedPreferences("name",MODE_PRIVATE);
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
