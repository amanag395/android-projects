package com.example.amangupta.servicealarm;

import android.util.Log;
import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 3/10/2017.
 */

public class MyThread implements Runnable {
    public static ArrayList<Task> taskList = new ArrayList<>();
    OnTimerExpireListener expireListener;

    public MyThread(OnTimerExpireListener expireListener) {
        this.expireListener = expireListener;
    }

    public interface OnTimerExpireListener {
        public void onExpire();
    }

    @Override
    public void run() {
        while (true) {
            ArrayList<Task> tempList = new ArrayList<>();
            long timestamp = System.currentTimeMillis();
            boolean isExtire = false;
            for (Task task : taskList) {
                if (timestamp >= task.getTime()) {
                    Log.d("Alarm", task.getName());
                    tempList.add(task);
                    isExtire = true;
                }
            }

            if (isExtire) {
                taskList.removeAll(tempList);
                tempList.clear();
                expireListener.onExpire();
            }
        }
    }
}
