package com.example.amana.myapplicationfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragmaent loginFragmaent = new LoginFragmaent();
        fragmentManager = getSupportFragmentManager();
        addFragment(loginFragmaent, "login", true);
    }

    public void addFragment(Fragment fragment, String tag, boolean backStackAdd) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if (backStackAdd)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else super.onBackPressed();

    }
}
