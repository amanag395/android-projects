package com.example.amana.myapplicationfragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 2/22/2017.
 */

public class RecycleViewActivity extends AppCompatActivity {

        public static final String LOG = RecycleViewActivity.class.getName();
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            Log.d(LOG,"onCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycle_view);

            mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new MyRecycleViewAdapter(getDataSet());
            mRecyclerView.setAdapter(mAdapter);
            /*RecyclerView.ItemDecoration itemDecoration =
                    new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
            mRecyclerView.addItemDecoration(itemDecoration);
*/
        }

        @Override
        protected void onResume() {
            Log.d(LOG,"onResume");
            super.onResume();

        }

        private ArrayList<User> getDataSet() {
            ArrayList results = new ArrayList<User>();
            for (int index = 0; index < 20; index++) {
                User obj = new User("Name " + index,
                        "name"+index+"@web.com " ,"Password"+ index);
                results.add(index, obj);
            }
            return results;
        }
    }
