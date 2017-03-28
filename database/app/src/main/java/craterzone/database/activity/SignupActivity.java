package craterzone.database.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import craterzone.database.R;
import craterzone.database.helper.DBHelper;

/**
 * Created by aMAN GUPTA on 2/27/2017.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText userName;
    private EditText password;
    private EditText discribe;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.et_signup_name);
        userName = (EditText) findViewById(R.id.et_signup_username);
        password = (EditText) findViewById(R.id.et_signup_password);
        discribe = (EditText) findViewById(R.id.et_signup_desbribe);
        findViewById(R.id.bt_register_user).setOnClickListener(this);
        findViewById(R.id.bt_back).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_register_user) {
            registerUser();
        } else if (v.getId() == R.id.bt_back) {
            finish();
        }
    }

    private void registerUser() {
        String name = this.name.getText().toString();
        String userName = this.userName.getText().toString();
        String password = this.password.getText().toString();
        String describe = this.discribe.getText().toString();
        if (!userName.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "Not a valid userName", Toast.LENGTH_SHORT);
            toast.show();
        } else if (password.length() < 8) {
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "Not a valid password", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            dbHelper = new DBHelper(this);
            if (!dbHelper.insertUser(name, userName, password, describe)) {
                Toast toast;
                toast = Toast.makeText(getApplicationContext(), "User already Exist please enter different username", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            Toast toast;
            toast = Toast.makeText(getApplicationContext(), "Registeration Successfull", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }
}
