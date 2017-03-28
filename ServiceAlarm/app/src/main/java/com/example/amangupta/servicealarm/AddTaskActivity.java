package com.example.amangupta.servicealarm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by aMAN GUPTA on 3/10/2017.
 */

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextTime;
    EditText editTextName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setTitle("Add Task");
        editTextName = (EditText) findViewById(R.id.et_task_name);
        editTextTime = (EditText) findViewById(R.id.et_task_time);
        findViewById(R.id.bt_add_time).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_add_time && editTextName.getText().length() > 0 && editTextTime.getText().length() >= 0) {
            final long sec = Long.parseLong(editTextTime.getText().toString());
            long timestamp = System.currentTimeMillis()+(sec*1000);
            MyThread.taskList.add(new Task( timestamp,editTextName.getText().toString()));
            Toast.makeText(this,"Task Added",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
