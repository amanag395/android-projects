package com.example.amangupta.loginapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.amangupta.loginapi.R;
import com.example.amangupta.loginapi.application.MyApplication;

/**
 * Created by aMAN GUPTA on 3/20/2017.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ((TextView) findViewById(R.id.tv_id)).setText(MyApplication.getMyApplication().getSharedPreferences().getInt("id", -1) + "");
        ((TextView) findViewById(R.id.tv_email)).setText(MyApplication.getMyApplication().getSharedPreferences().getString("email_id", "null"));
        ((TextView) findViewById(R.id.tv_name)).setText(MyApplication.getMyApplication().getSharedPreferences().getString("name", "null"));
        ((TextView) findViewById(R.id.tv_phone)).setText(MyApplication.getMyApplication().getSharedPreferences().getLong("phone", Long.parseLong("888888888888")) + "");
        ((TextView) findViewById(R.id.tv_is_active)).setText(MyApplication.getMyApplication().getSharedPreferences().getBoolean("is_active", false) + "");
        findViewById(R.id.bt_logout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_logout) {
            MyApplication.getMyApplication().getSharedPreferences().edit().clear().commit();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
