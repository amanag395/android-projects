package com.example.amangupta.servicealarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_add_task).setOnClickListener(this);
        findViewById(R.id.bt_delete_task).setOnClickListener(this);
        Intent intent = new Intent(getApplicationContext(),TaskService.class);
        startService(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_add_task) {
            Intent intent = new Intent(getApplicationContext(), AddTaskActivity.class);
            startActivity(intent);
        }else if (v.getId()==R.id.bt_delete_task){
            Intent intent = new Intent(getApplicationContext(), DeleteTaskActivity.class);
            startActivity(intent);
        }
    }
}
