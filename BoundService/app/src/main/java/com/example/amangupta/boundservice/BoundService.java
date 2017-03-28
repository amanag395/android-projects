package com.example.amangupta.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BoundService extends Service {
    private Listener listener;

    IBinder iBinder = new MyBinder();

    public void setListener(Listener listener) {
        this.listener = listener;
    }


    class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    public void startListener(){
        this.listener.makeToast();
    }

    interface Listener {
        void makeToast();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("BoundService","onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
