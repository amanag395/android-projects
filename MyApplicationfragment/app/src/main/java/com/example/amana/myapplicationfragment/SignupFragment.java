package com.example.amana.myapplicationfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupFragment extends Fragment {
    EditText sName;
    EditText sUserName;
    EditText sPassword;
    TextView signUpTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.signup_fragment,container,false);
        sName = (EditText) view.findViewById(R.id.et_signup_name);
        sUserName = (EditText) view.findViewById(R.id.et_signup_userName);
        sPassword = (EditText) view.findViewById(R.id.et_signup_password);
        signUpTextView = (TextView) view.findViewById(R.id.tv_signup);
        Button button = (Button) view.findViewById(R.id.bt_createUser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        return view;
    }

    private void registerUser() {
        String name = sUserName.getText().toString();
        String userName = sUserName.getText().toString();
        String password = sPassword.getText().toString();
        if (!userName.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            signUpTextView.setText("Not a valid userName");
        } else if (password.length() < 8) {
            signUpTextView.setText("Not a valid Password");
        } else {
            signUpTextView.setText(name + "Registered");

            DataController.getController().setUserData(userName);
            ((MainActivity)getContext()).onBackPressed();
        }
    }

}
