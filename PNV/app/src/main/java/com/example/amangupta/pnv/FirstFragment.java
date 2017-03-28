package com.example.amangupta.pnv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class FirstFragment extends android.support.v4.app.Fragment {
    Context context;
    EditText countryCode;
    EditText mobileNo;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_first, container, false);
        countryCode = (EditText) view.findViewById(R.id.et_country_code);
        mobileNo = (EditText) view.findViewById(R.id.et_mobile_no);
        view.findViewById(R.id.bt_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        return view;
    }

    private void check() {
        if (countryCode.getText().toString().length() == 2 && mobileNo.getText().toString().length() == 10) {
            SharedPreferences.Editor editor = MyApplication.getMyApplication().getSharedPreferences().edit();
            editor.putString("country_code",countryCode.getText().toString());
            editor.putString("mobile_no",mobileNo.getText().toString());
            editor.commit();
//            DataControler.getControler().setCountryCode(Integer.parseInt(countryCode.getText().toString()));
//            DataControler.getControler().setMobileNo(Long.parseLong(mobileNo.getText().toString()));
            SecondFragment secondFragment = new SecondFragment();
            ((MainActivity)context).addFragment(secondFragment,"second",false);
            return;
        }
        Toast.makeText(context, "Counter Must be of Two Digits and Mobile No. must be of Ten Digits", Toast.LENGTH_SHORT).show();
    }
}
