package craterzone.avtivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import craterzone.adapter.MyRecycleViewAdapter;
import craterzone.model.Item;
import craterzone.ui.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MyRecycleViewAdapter.MyClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecycleViewAdapter(getDataSet());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        findViewById(R.id.bt_avaliable).setOnClickListener(this);
        findViewById(R.id.recycle_view).setOnClickListener(this);

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
    public void onClick(View v) {
        if (v.getId() == R.id.bt_avaliable) {
            Toast.makeText(getApplicationContext(), ((EditText) findViewById(R.id.et_describe)).getText(), Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.recycle_view){
           // Toast.makeText(getApplicationContext(),, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemClick(String name) {
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}
