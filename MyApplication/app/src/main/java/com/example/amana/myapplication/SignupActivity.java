package com.example.amana.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    
    public static final String TAG = SignupActivity.class.getName();
    EditText sName;
    EditText sUserName;
    EditText sPassword;
    TextView signUpTextView;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        sName = (EditText) findViewById(R.id.et_signup_name);
        sUserName = (EditText) findViewById(R.id.et_signup_userName);
        sPassword = (EditText) findViewById(R.id.et_signup_password);
        signUpTextView = (TextView) findViewById(R.id.tv_signup);
        findViewById(R.id.bt_createUser).setOnClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_createUser){
            String name = sUserName.getText().toString();
            String userName = sUserName.getText().toString();
            String password = sPassword.getText().toString();
            if (!userName.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                signUpTextView.setText("Not a valid userName");
//                Intent myintent=new Intent(getApplicationContext(),SignupActivity.class);
//                startActivity(myintent);
            } else if (password.length() < 8) {
                signUpTextView.setText("Not a valid Password");
//                Intent myintent=new Intent(getApplicationContext(),SignupActivity.class);
//                startActivity(myintent);
            } else {
                signUpTextView.setText(name + "Registered");
                dbHelper = new DBHelper(this);
                dbHelper.insertContact(name,userName,password);
              /*  dbHelper.insertValues(name,userName,password);
                Intent i = getIntent();
                i.putExtra("signUpUserName",userName);
                setResult(1,i);
                finish();*/
//                startActivity(myintent);
            }
        }
    }
}
