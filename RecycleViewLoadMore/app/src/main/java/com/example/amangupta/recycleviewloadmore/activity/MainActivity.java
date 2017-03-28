package com.example.amangupta.recycleviewloadmore.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.amangupta.recycleviewloadmore.R;
import com.example.amangupta.recycleviewloadmore.adapter.MyRecycleViewAdapter;
import com.example.amangupta.recycleviewloadmore.controler.Controler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyRecycleViewAdapter.OnLoadMore {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter();
        adapter.setOnLoadMore(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void loadMore() {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "Wait", "Getting more items for list");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    Controler.getControler().addToList();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                });
            }
        });
        thread.start();
    }

    @Override
    public void onClick(View v) {

    }
}
