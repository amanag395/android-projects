package com.example.amangupta.loginapi.application;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by aMAN GUPTA on 3/20/2017.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    private SharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        this.myApplication = this;
        this.sharedPreferences = this.getSharedPreferences("name",MODE_PRIVATE);
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
