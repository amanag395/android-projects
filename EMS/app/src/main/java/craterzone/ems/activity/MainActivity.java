package craterzone.ems.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import craterzone.ems.R;
import craterzone.ems.dialog.MyDiglog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_add_employee).setOnClickListener(this);
        findViewById(R.id.bt_show_report).setOnClickListener(this);
        findViewById(R.id.bt_exit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bt_add_employee){
            Intent intent = new Intent(getApplicationContext(),AddEmployee.class);
            startActivity(intent);
        }else if(v.getId()==R.id.bt_show_report){
            Intent intent = new Intent(getApplicationContext(),ViewReport.class);
            startActivity(intent);
        }else if (v.getId()==R.id.bt_exit){
            MyDiglog myDiglog = new MyDiglog(this);
            myDiglog.show();
        }
    }
}
