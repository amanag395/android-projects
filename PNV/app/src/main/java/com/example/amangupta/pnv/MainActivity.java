package com.example.amangupta.pnv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        if (MyApplication.getMyApplication().getSharedPreferences().getString("country_code","null").equals("null")) {
            FirstFragment firstFragment = new FirstFragment();
            addFragment(firstFragment, "first", false);
        }else if(MyApplication.getMyApplication().getSharedPreferences().getBoolean("is_verified",false)==false){
            SecondFragment secondFragment = new SecondFragment();
            addFragment(secondFragment,"sec",false);
        }else if(MyApplication.getMyApplication().getSharedPreferences().getString("email","null").equals("null")){
            ThirdFragment thirdFragment = new ThirdFragment();
            addFragment(thirdFragment,"third",false);
        }else{
            FourthFragment fourthFragment = new FourthFragment();
            addFragment(fourthFragment,"fourth",false);
        }


    }
    public void addFragment(android.support.v4.app.Fragment fragment, String tag, boolean backStackAdd) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if (backStackAdd)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else super.onBackPressed();
    }
}
