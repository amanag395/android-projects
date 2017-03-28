package com.example.amangupta.boundservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BoundService.Listener, View.OnClickListener {

    BoundService mService;
    boolean aBoolean = true;
    boolean isStart = false;
    MainActivity mainActivity = this;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mService = myBinder.getService();
            mService.setListener(mainActivity);
            aBoolean = true;
            mService.startListener();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("main", "onServiceDisconnected");
            aBoolean = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_start).setOnClickListener(this);
        findViewById(R.id.bt_stop).setOnClickListener(this);
    }


    @Override
    public void makeToast() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (aBoolean) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Alarm", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_start && !isStart) {
            Intent intent = new Intent(this, BoundService.class);
            bindService(intent, connection, BIND_AUTO_CREATE);
            isStart = true;
        } else if (v.getId() == R.id.bt_stop && isStart) {
            unbindService(connection);
            aBoolean = false;
            isStart = false;
        }
    }
}
