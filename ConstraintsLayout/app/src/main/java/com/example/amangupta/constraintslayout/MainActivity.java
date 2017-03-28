package com.example.amangupta.constraintslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.amangupta.constraintslayout.adapter.MyRecycleViewAdapter;
import com.example.amangupta.constraintslayout.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecycleViewAdapter.MyClickListener {
    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecycleViewAdapter(getDataSet());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Item> getDataSet() {
        ArrayList results = new ArrayList<Item>();
        int index;
        for (index = 0; index < 20; index++) {
            Item obj = new Item("Name " + index);
            results.add(index, obj);
        }
        Item obj = new Item("Add Someone");
        results.add(index, obj);
        return results;
    }

    @Override
    public void onItemClick(String name) {
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}
