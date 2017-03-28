package com.example.amangupta.giftapi.thread;

import android.util.Log;

import com.example.amangupta.giftapi.controler.Controler;
import com.example.amangupta.giftapi.model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aMAN GUPTA on 3/17/2017.
 */

public class MyThread implements Runnable {
    private String response;
    private PostExecute postExecute;

    public MyThread(PostExecute postExecute) {
        this.postExecute = postExecute;
    }

    public interface PostExecute{
        public void afterExecute();
    }
    @Override
    public void run() {
        try {
            URL url = new URL("http://52.221.252.215:1992/v1/gifts");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == 200) {
                Log.d("connection", "successfull");
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());

                Reader reader = new InputStreamReader(inputStream);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
//                Item item = gson.fromJson(reader,Item.class);
                ArrayList<Item> items = gson.fromJson(reader,new TypeToken<ArrayList<Item>>(){}.getType());
                Controler.getControler().setList(items);
                postExecute.afterExecute();
                /*response = convertStreamToString(inputStream);
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
                        postExecute.afterExecute();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/
                        /*InputStream inputStream = connection.getInputStream();
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
                        }*/
            } else {
                Log.d("connection", "fail");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
