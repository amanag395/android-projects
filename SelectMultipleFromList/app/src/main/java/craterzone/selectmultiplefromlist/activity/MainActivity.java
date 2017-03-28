package craterzone.selectmultiplefromlist.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import craterzone.selectmultiplefromlist.R;
import craterzone.selectmultiplefromlist.adapter.MyRecycleViewAdapter;
import craterzone.selectmultiplefromlist.model.Country;
import craterzone.selectmultiplefromlist.thread.AddCountryThread;

public class MainActivity extends AppCompatActivity implements MyRecycleViewAdapter.MyClickListener, AddCountryThread.AddCountryListner {
    RecyclerView recyclerView;
    MyRecycleViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    //    AddCountryThread addCountryThread;
    Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        //SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort_z:
                adapter.sortZ();
                return true;
            case R.id.action_sort_a:
                adapter.sortA();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.rv_country_list);
        recyclerView.setBackgroundColor(Color.WHITE);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(getDataSet());
//        adapter = new MyRecycleViewAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
//        addCountryThread = new AddCountryThread(this);
//        Thread thread = new Thread(addCountryThread);
//        thread.start();
//        findViewById(R.id.bt_add_country).setOnClickListener(this);
    }

    private ArrayList<Country> getDataSet() {
        ArrayList results = new ArrayList<Country>();
        results.add(new Country("India"));
        results.add(new Country("China"));
        results.add(new Country("United States"));
        results.add(new Country("Indonesia"));
        results.add(new Country("Brazil"));
        results.add(new Country("Pakistan"));
        results.add(new Country("Nigeria"));
        results.add(new Country("Bangladesh"));
        results.add(new Country("Mexico"));
        results.add(new Country("Japan"));
        results.add(new Country("Philippines"));
        results.add(new Country("Ethiopia"));
        results.add(new Country("Vietnam"));
        results.add(new Country("Egypt"));
        results.add(new Country("Germany"));
        results.add(new Country("Iran"));
        results.add(new Country("Turkey"));
        results.add(new Country("Thailand"));
        results.add(new Country("United Kingdom"));
        results.add(new Country("Italy"));
        results.add(new Country("Burma"));
        results.add(new Country("South Africa"));
        results.add(new Country("Korea, South"));
        results.add(new Country("Spain"));
        results.add(new Country("Colombia"));
        results.add(new Country("Kenya"));
        results.add(new Country("Ukraine"));
        results.add(new Country("Argentina"));
        results.add(new Country("Algeria"));
        return results;
    }


    @Override
    public void onItemClick(Country country, View view) {
        view.findViewById(R.id.tv_item).setBackgroundColor(country.isSlected() ? Color.WHITE : Color.CYAN);
        country.setSlected();
    }

    @Override
    public void addCountry(final String name) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                adapter.addItem(new Country(name),adapter.getItemCount());
//            }
//        });
    }

//    @Override
//    public void onClick(View v) {
//        if (v.getId()==R.id.bt_add_country){
//            addCountryThread.add100Countries();
////            addCountryThread.setStartStop();
//        }
//    }

//    public ArrayList<Country> getDataSet() {
//        ArrayList<Country> list = new ArrayList<>();
//        list.add()
//        return dataSet;
//    }
}
