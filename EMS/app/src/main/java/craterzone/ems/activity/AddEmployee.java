package craterzone.ems.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import craterzone.ems.R;
import craterzone.ems.controler.ListControler;
import craterzone.ems.model.Employee;

/**
 * Created by aMAN GUPTA on 3/2/2017.
 */

public class AddEmployee extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText id;
    EditText name;
    EditText salary;
    RadioGroup genderRadioGroup;
    RadioButton genderRadioButton;
    Spinner departmentSpinner;
    String department;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee);
        id = (EditText) findViewById(R.id.et_id);
        name = (EditText) findViewById(R.id.et_name);
        salary = (EditText) findViewById(R.id.et_salary);
        genderRadioGroup = (RadioGroup) findViewById(R.id.rg_gender);
        departmentSpinner = (Spinner) findViewById(R.id.spnner_department);
        ArrayAdapter<CharSequence> departmentList = ArrayAdapter.createFromResource(this,R.array.department_array,android.R.layout.simple_spinner_item);
        departmentList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departmentSpinner.setAdapter(departmentList);
        departmentSpinner.setOnItemSelectedListener(this);
        findViewById(R.id.bt_register_employee).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_register_employee && (!name.getText().toString().equals("")) && (!salary.getText().toString().equals("")) && (!id.getText().toString().equals(""))){
            genderRadioButton = (RadioButton) findViewById(genderRadioGroup.getCheckedRadioButtonId());
            Employee employee = new Employee(id.getText().toString(),name.getText().toString(),Double.parseDouble(salary.getText().toString()),genderRadioButton.getText().toString(),department);
            if(ListControler.addEmployee(employee)){
                Toast toast = Toast.makeText(getApplicationContext(),"Employee Added",Toast.LENGTH_SHORT);
                toast.show();
                finish();
                return;
            }
            Toast toast = Toast.makeText(getApplicationContext(),"An employee with same id already exist",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(),"Id or Name or Salary Can't be blank",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        department = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        department = parent.getItemAtPosition(0).toString();
    }
}
