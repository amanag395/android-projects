package com.example.amangupta.pnv;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class FourthFragment extends android.support.v4.app.Fragment {
    Context context;
    TextView name;
    TextView email;
    TextView describe;
    TextView mobileNo;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        name = (TextView) view.findViewById(R.id.tv_name);
        email = (TextView) view.findViewById(R.id.tv_email);
        describe = (TextView) view.findViewById(R.id.tv_describe);
        mobileNo = (TextView) view.findViewById(R.id.tv_moblie_number);
//        name.setText(DataControler.getControler().getName());
//        email.setText(DataControler.getControler().getEmail());
//        describe.setText(DataControler.getControler().getDescribe());
//        mobileNo.setText(DataControler.getControler().getCountryCode()+" "+DataControler.getControler().getMobileNo());
        name.setText(MyApplication.getMyApplication().getSharedPreferences().getString("name","null"));
        email.setText(MyApplication.getMyApplication().getSharedPreferences().getString("email","null"));
        mobileNo.setText(MyApplication.getMyApplication().getSharedPreferences().getString("country_code","null")+" "+MyApplication.getMyApplication().getSharedPreferences().getString("mobile_no","null"));
        describe.setText(MyApplication.getMyApplication().getSharedPreferences().getString("describe","Nothing Found"));
        view.findViewById(R.id.bt_fourth).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return view;
    }

    private void finish() {
        ((MainActivity)context).finish();
    }
}
