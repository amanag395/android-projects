package com.example.amana.myapplication;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getName();
    private EditText mUserName;
    private EditText mPassword;
    private TextView userNameTextView;
//    TextView passwordTextView;
//    TextView userNameSignupTextView;
//    EditText userNameSignupEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("OnCreateMain","OnCreateMain");
        setContentView(R.layout.activity_main);
        mUserName = (EditText) findViewById(R.id.et_userName);
        mPassword = (EditText) findViewById(R.id.et_password);
        userNameTextView = (TextView) findViewById(R.id.tv_userName);
//        userNameSignupEditText = (EditText) findViewById(R.id.et_signup_userName);
//        userNameSignupTextView = (TextView) findViewById(R.id.tv_signup_userName);
//        passwordTextView = (TextView) findViewById(R.id.tv_password);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_signup).setOnClickListener(this);
//        Intent i = getIntent();
//        String stringData = "";
//        if (i!=null) {
//            stringData= i.getStringExtra("signUpName");
//            mUserName.setText(stringData);
//        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStartMain");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResumeMain");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPauseMain");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStopMain");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroyMain");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestartMain");
    }

    @Override
    public void onClick(View v) {
//        Log.d("Hello", "click");
        if(v.getId()==R.id.bt_login){
            login();
        }
        else if(v.getId()==R.id.bt_signup){
            signup();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            String extraData = data.getStringExtra("signUpUserName");
            mUserName.setText(extraData);
        }

    }

    private void signup() {
//        setContentView(R.layout.activity_signup_);
        Intent myintent=new Intent(getApplicationContext(),SignupActivity.class);
        startActivityForResult(myintent,1);
    }

    private void login() {
        String userName = mUserName.getText().toString();
        String password = mPassword.getText().toString();
        if (!userName.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            userNameTextView.setText("Not a valid userName");
        } else if (password.length() < 8) {
            userNameTextView.setText("Not a valid Password");
        } else {
            userNameTextView.setText("User Name = " + userName + "\nPassword = " + password);
        }
    }
}
