package craterzone.thered;

import android.app.Application;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyThread.OnTimeUpdateListener {

    private TextView counterTextView;
    private Button startStop;
    private MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTextView = (TextView) findViewById(R.id.tv_counter);
        startStop = (Button) findViewById(R.id.bt_start_stop);
        findViewById(R.id.bt_start_stop).setOnClickListener(this);
        myThread = new MyThread(this);//action / task
        Thread thread = new Thread(myThread);
        thread.start();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_start_stop) {
            if(myThread.isStart()){
                startStop.setText("Start");
            }else {
                startStop.setText("Stop");
            }
            myThread.startStopTimer();
        }
        Application application;
    }

    @Override
    public void onTimeUpdate(final int counter) {
        MyApplication.getApplication().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                counterTextView.setText(counter +"");
            }
        });
    }
}
