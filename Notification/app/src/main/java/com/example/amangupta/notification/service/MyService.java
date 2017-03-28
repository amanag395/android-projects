package com.example.amangupta.notification.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import com.example.amangupta.notification.R;
import com.example.amangupta.notification.controller.FileController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyService extends Service {
    NotificationCompat.Builder builder;
    NotificationManager notificationManager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "onStartCommand", Toast.LENGTH_SHORT).show();
        copy();
        return START_STICKY;
    }

    private void copy() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    File src;
                    long file = 0;
                    if (getApplicationContext().getSharedPreferences("copy", MODE_PRIVATE).getString("src", "aaa").equals("aaa")) {
                        return;
                    } else {
                        src = new File(getApplicationContext().getSharedPreferences("copy", MODE_PRIVATE).getString("src", null));
                    }
                    File dst = new File("/storage/emulated/0/Download/", src.getName());
                    if (dst.exists()) {
                        file = dst.length();
                    }
                    InputStream in = new FileInputStream(src);
                    OutputStream out = (file == 0) ? new FileOutputStream(dst) : new FileOutputStream(dst, true);
                    byte[] buf = new byte[1024];
                    int len;
                    long lengthOfFile = src.length();
                    in.skip(file);
                    while ((len = in.read(buf)) >= 0) {
                        out.write(buf, 0, len);
                        file += len;
                        builder.setContentText("Progress :" + ((int) (+(file * 100) / lengthOfFile)) + "%");
                        notificationManager.notify(100, builder.build());
                    }
                    builder.setContentText("Copy Successful");
                    notificationManager.notify(100, builder.build());

                } catch (IOException e) {
                    e.printStackTrace();
                    builder.setContentText("Copy fail");
                    notificationManager.notify(100, builder.build());
                } finally {
                    FileController.getFileController().setCopying(false);
                }
            }
        });
        thread.start();
    }


    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(), "service on create", Toast.LENGTH_SHORT).show();
        builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Copy Process");
        builder.setContentText("My Notification Text");
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
