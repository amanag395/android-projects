package com.example.amana.myapplicationfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginFragmaent extends Fragment {

    Context context;
    private EditText mUserName;
    private EditText mPassword;
    private TextView userNameTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.login_fragment, container, false);
        mUserName = (EditText) view.findViewById(R.id.et_userName);
        mPassword = (EditText) view.findViewById(R.id.et_password);
        userNameTextView = (TextView) view.findViewById(R.id.tv_userName);
        Button button = (Button) view.findViewById(R.id.bt_signup);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegister();
            }
        });
        button = (Button) view.findViewById(R.id.bt_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        button = (Button) view.findViewById(R.id.bt_userList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userList();
            }
        });

        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String data = DataController.getController().getUserData();
        if(!TextUtils.isEmpty(data))
            mUserName.setHint(data);
    }

    private void userList(){
        Intent myintent=new Intent(context,RecycleViewActivity.class);
        startActivity(myintent);
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


    public void onRegister() {
        /*String userName =  DataController.getController().getUserData();
        if(userName!=null){
            mUserName.setText(userName);
        }*/
        SignupFragment signupFragment = new SignupFragment();
        ((MainActivity) context).addFragment(signupFragment, "sign_up", true);
    }
}
