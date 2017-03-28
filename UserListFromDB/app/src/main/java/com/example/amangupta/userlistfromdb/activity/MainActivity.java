package com.example.amangupta.userlistfromdb.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.amangupta.userlistfromdb.R;
import com.example.amangupta.userlistfromdb.controller.UserController;
import com.example.amangupta.userlistfromdb.fragment.ListFragment;
import com.example.amangupta.userlistfromdb.table.RegisterUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserController.getController();
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        findViewById(R.id.bt_show_list).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_show_list) {
            ListFragment listFragment = new ListFragment();
            addFragment(listFragment);
        }
        findViewById(R.id.bt_show_list).setVisibility(View.GONE);
    }

    public void addFragment(Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}
