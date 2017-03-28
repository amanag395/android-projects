package craterzone.ems.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import craterzone.ems.R;
import craterzone.ems.controler.ListControler;
import craterzone.ems.model.Employee;

/**
 * Created by aMAN GUPTA on 3/2/2017.
 */

public class ViewReport extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_report);
        ArrayAdapter<Employee> employeeArrayAdapter = new ArrayAdapter<Employee>(this,R.layout.employee_list_item, ListControler.getList());
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(employeeArrayAdapter);
    }
}
