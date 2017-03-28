package com.example.amangupta.servicealarm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by aMAN GUPTA on 3/10/2017.
 */

public class TaskService extends Service implements MyThread.OnTimerExpireListener {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new MyThread(this));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onExpire() {
        Intent intent = new Intent("aaa");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        Intent intent1 = new Intent();
        intent1.setAction("ServiceAlarm.CUSTOM_INTENT");
        sendBroadcast(intent1);

    }
}
