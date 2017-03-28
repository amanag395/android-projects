package craterzone.database.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import craterzone.database.R;
import craterzone.database.helper.DBHelper;
import craterzone.database.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_login).setOnClickListener(this);
        findViewById(R.id.bt_signup).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_login) {
            login();
        } else if (v.getId() == R.id.bt_signup) {
            signup();
        }
    }

    private void login() {
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        this.userName = (EditText) findViewById(R.id.et_login_username);
        this.password = (EditText) findViewById(R.id.et_login_password);
        if (userName.getText().toString().equals(null) || password.getText().toString().equals(null)) {
            Toast toast = Toast.makeText(getApplicationContext(), "Feilds can't be null", Toast.LENGTH_SHORT);
            toast.show();
        }
        User user = dbHelper.getUser(userName.getText().toString(), password.getText().toString());
        if (user == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "No user find with details", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        Intent intent = new Intent(getApplication(), LoginActivity.class);
        intent.putExtra("user", user);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private void signup() {
        Intent intent = new Intent(getApplication(), SignupActivity.class);
        startActivityForResult(intent, 1);
    }

}
