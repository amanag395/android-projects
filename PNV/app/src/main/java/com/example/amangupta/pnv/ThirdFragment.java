package com.example.amangupta.pnv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class ThirdFragment extends android.support.v4.app.Fragment {
    Context context;
    EditText name;
    EditText email;
    EditText password;
    EditText describe;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_third, container, false);
        name = (EditText) view.findViewById(R.id.et_name);
        email = (EditText) view.findViewById(R.id.et_email);
        password = (EditText) view.findViewById(R.id.et_password);
        describe = (EditText) view.findViewById(R.id.et_describe);
        view.findViewById(R.id.bt_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        return view;
    }

    private void check() {
        if (name.getText().toString().length()==0){
            Toast.makeText(context,"Name feild can't be blank",Toast.LENGTH_SHORT).show();
        }else if(!email.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
            Toast.makeText(context,"Invalid e-mail",Toast.LENGTH_SHORT).show();
        }else if (password.getText().toString().length()<8){
            Toast.makeText(context,"Password length must be more than 7",Toast.LENGTH_SHORT).show();
        }else {
            SharedPreferences.Editor editor = MyApplication.getMyApplication().getSharedPreferences().edit();
            editor.putString("name",name.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.putString("email",email.getText().toString());
            editor.putString("describe",describe.getText().toString());
            editor.commit();
//            DataControler.getControler().setName(name.getText().toString());
//            DataControler.getControler().setEmail(email.getText().toString());
//            DataControler.getControler().setPassword(password.getText().toString());
//            DataControler.getControler().setDescribe(describe.getText().toString());
            FourthFragment fourthFragment = new FourthFragment();
            ((MainActivity)context).addFragment(fourthFragment,"fourth",true);
        }
    }
}
