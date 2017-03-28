package com.example.amangupta.servicealarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by aMAN GUPTA on 3/16/2017.
 */

public class MyBroadcastReciver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm Alarm Alarm",Toast.LENGTH_SHORT).show();
    }
}

