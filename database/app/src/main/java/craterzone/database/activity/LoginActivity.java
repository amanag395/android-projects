package craterzone.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import craterzone.database.R;
import craterzone.database.adapter.MyRecycleViewAdapter;
import craterzone.database.helper.DBHelper;
import craterzone.database.model.User;

/**
 * Created by aMAN GUPTA on 2/27/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, MyRecycleViewAdapter.MyClickListener {
    TextView name;
    TextView userName;
    TextView password;
    TextView describe;
    DBHelper dbHelper;
    private RecyclerView mRecyclerView;
    private MyRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (TextView) findViewById(R.id.tv_login_name);
        userName = (TextView) findViewById(R.id.tv_login_username);
        password = (TextView) findViewById(R.id.tv_login_password);
        describe = (TextView) findViewById(R.id.tv_login_desbribe);
        fillUserData();
        findViewById(R.id.bt_login_logout).setOnClickListener(this);
        findViewById(R.id.bt_login_view_user).setOnClickListener(this);
    }

    private void fillUserData() {
        Intent intent = getIntent();
        User user = intent.getParcelableExtra("user");
        name.setText(user.getName());
        userName.setText(user.getUserName());
        password.setText(user.getPassword());
        describe.setText(user.getDescribe());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_login_logout) {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.bt_login_view_user) {
            showUserList();
        }
    }

    private void showUserList() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view_login);
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecycleViewAdapter(getDataSet());
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public ArrayList<User> getDataSet() {
        dbHelper = new DBHelper(getApplicationContext());
        return dbHelper.getUsers();
    }

    @Override
    public void onUserClick(String name, String userName, String describe) {
        Toast toast = Toast.makeText(getApplicationContext(), name+"  "+describe, Toast.LENGTH_SHORT);
        toast.show();
    }
}
