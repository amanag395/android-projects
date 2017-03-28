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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by aMAN GUPTA on 3/7/2017.
 */

public class SecondFragment extends android.support.v4.app.Fragment {
    Context context;
    TextView mobileNo;
    EditText code;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_second, container, false);
        mobileNo = (TextView) view.findViewById(R.id.tv_moblie_no);
        code = (EditText) view.findViewById(R.id.et_code);
        mobileNo.setText(MyApplication.getMyApplication().getSharedPreferences().getString("mobile_no","null"));
        view.findViewById(R.id.bt_sec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        return view;
    }

    private void check() {
        if (code.getText().toString().equals("12345")) {
            SharedPreferences.Editor editor = MyApplication.getMyApplication().getSharedPreferences().edit();
            editor.putBoolean("is_verified",true);
            editor.commit();
            ThirdFragment thirdFragment = new ThirdFragment();
            ((MainActivity)context).addFragment(thirdFragment,"third",false);
            return;
        }
        Toast.makeText(context, "Enter a valid code", Toast.LENGTH_SHORT).show();
    }
}
