package com.example.amangupta.notification.activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.amangupta.notification.R;
import com.example.amangupta.notification.controller.FileController;
import com.example.amangupta.notification.service.MyService;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("copy", MODE_PRIVATE);
        findViewById(R.id.bt_copy).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_copy && !FileController.getFileController().isCopying()) {
            FileController.getFileController().setCopying(true);
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("*/*");
            startActivityForResult(intent, 42);
        } else {
            Toast.makeText(this, "Already Copying a file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 42 && resultCode == Activity.RESULT_OK) {
            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                File file = new File("/storage/emulated/0/" + uri.getPath().replace("/document/primary:", ""));
                FileController.getFileController().setFile(file);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("src", FileController.getFileController().getFile().getPath());
                editor.commit();
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MainActivity onDestroy", Toast.LENGTH_SHORT).show();
        if (FileController.getFileController().isCopying()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("src", FileController.getFileController().getFile().getPath());
            editor.commit();
            Log.d("MainActivity", "onDestroy");
        }
    }
}
