package com.example.amangupta.pnv;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class DataControler {
//    int countryCode;
//    long mobileNo;
//    String name;
//    String email;
//    String password;
//    String describe;
    static DataControler dataControler;
    static SharedPreferences sharedPreferences;
    private DataControler() {

    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static DataControler getControler(Context context){
        if (dataControler==null){
            dataControler = new DataControler();
            sharedPreferences = context.getSharedPreferences("my_pref",Context.MODE_PRIVATE);
        }
        return dataControler;
    }

//    public int getCountryCode() {
//        return countryCode;
//    }
//
//    public void setCountryCode(int countryCode) {
//        this.countryCode = countryCode;
//    }
//
//    public long getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(long mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getDescribe() {
//        return describe;
//    }
//
//    public void setDescribe(String describe) {
//        this.describe = describe;
//    }
}
