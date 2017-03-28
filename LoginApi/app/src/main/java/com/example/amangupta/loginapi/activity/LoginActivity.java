package com.example.amangupta.loginapi.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amangupta.loginapi.R;
import com.example.amangupta.loginapi.application.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aMAN GUPTA on 3/20/2017.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mobileNo = null;
    EditText password;
    TextView wait;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man);
        mobileNo = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
        wait = (TextView) findViewById(R.id.tv_wait);
        login = (Button) findViewById(R.id.bt_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final String mobileNO = this.mobileNo.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        if (mobileNO.length() == 12 && password.length() != 0) {
            AsyncTask asyncTask = new AsyncTask() {
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    login.setVisibility(View.INVISIBLE);
                    wait.setVisibility(View.VISIBLE);
                }

                @Override
                protected Object doInBackground(Object[] params) {
                    try {
                        URL url = new URL("http://prod-api-core.wedoshoes.com:8088/api/v1/users/login");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setRequestProperty("Device-Token", getUUID(getApplicationContext()));
                        connection.setRequestProperty("Device-Type", "ANDROID");
                        connection.setRequestProperty("Content-type", "application/json");
                        connection.setRequestProperty("Accept", "application/json");
                        connection.setDoInput(true);
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("phone", Long.parseLong(mobileNO));
                        jsonObject.put("password", password);
                        String query = jsonObject.toString();
                        byte[] outputInBytes = query.getBytes("UTF-8");
                        OutputStream os = connection.getOutputStream();
                        os.write(outputInBytes);
                        os.close();
                        connection.connect();
                        if (connection.getResponseCode() == 200) {
                            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                            String response = convertStreamToString(inputStream);
                            JSONObject temp = new JSONObject(response);
                            SharedPreferences.Editor editor = MyApplication.getMyApplication().getSharedPreferences().edit();
                            editor.putInt("id", temp.getInt("id"));
                            editor.putString("email_id", temp.getString("email_id"));
                            editor.putString("name", temp.getString("name"));
                            editor.putLong("phone", temp.getLong("phone"));
                            editor.putBoolean("is_active", temp.getBoolean("is_active"));
                            editor.commit();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User found", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Object o) {
                    super.onPostExecute(o);
                    wait.setVisibility(View.INVISIBLE);
                    login.setVisibility(View.VISIBLE);
                }
            };
            asyncTask.execute();

        } else {
            Toast.makeText(getApplicationContext(), "Enter valid details", Toast.LENGTH_SHORT).show();
        }
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String getUUID(Context context) {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
    }
}