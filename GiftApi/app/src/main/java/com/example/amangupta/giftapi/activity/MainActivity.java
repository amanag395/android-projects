package com.example.amangupta.giftapi.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.amangupta.giftapi.thread.MyThread;
import com.example.amangupta.giftapi.R;
import com.example.amangupta.giftapi.controler.Controler;
import com.example.amangupta.giftapi.adapter.MyRecycleViewAdapter;

public class MainActivity extends AppCompatActivity implements MyThread.PostExecute {
    String response = null;
    RecyclerView recyclerView;
    MyRecycleViewAdapter adpeter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_json_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adpeter = new MyRecycleViewAdapter(Controler.getControler().getList(),this);
        recyclerView.setAdapter(adpeter);
        getJsonDataList();
    }

    private void getJsonDataList() {
        MyThread myThread = new MyThread(this);
        Thread thread = new Thread(myThread);
        thread.start();
        /*AsyncTask asyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                try {
                    URL url = new URL("http://52.221.252.215:1992/v1/gifts");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    if (connection.getResponseCode() == 200) {
                        Log.d("connection", "successfull");
                        InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                        response = convertStreamToString(inputStream);
                        if (response != null) {
                            try {
                                String title;
                                String cost;
                                String type;
                                String imageSrc;
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject temp = jsonArray.getJSONObject(i);
                                    title = temp.getString("title");
                                    cost = temp.getString("gift_cost");
                                    type = temp.getString("gift_type");
                                    imageSrc = temp.getString("hres_url");
                                    Controler.getControler().addtemToList(new Item(title, type, cost,imageSrc));
                                    Log.d("title", temp.getString("title"));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        *//*InputStream inputStream = connection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
                        JsonReader jsonReader = new JsonReader(inputStreamReader);
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()){
                            JSONObject jsonObject
                            String key = jsonReader.nextName();
                            if (key.equals("title")){
                                String value = jsonReader.nextString();
                                Log.d("title",value);
                            }else {
                                jsonReader.skipValue();
                            }
                        }*//*
                    } else {
                        Log.d("connection", "fail");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adpeter.notifyDataSetChanged();
                    }
                });
            }
        };
        asyncTask.execute();*/
    }

    @Override
    public void afterExecute() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adpeter.notifyDataSetChanged();
            }
        });
    }

    /*private String convertStreamToString(InputStream inputStream) {
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
    }*/
}
