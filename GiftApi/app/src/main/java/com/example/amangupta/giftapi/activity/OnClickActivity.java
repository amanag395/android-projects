package com.example.amangupta.giftapi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amangupta.giftapi.R;
import com.example.amangupta.giftapi.controler.Controler;

/**
 * Created by aMAN GUPTA on 3/17/2017.
 */

public class OnClickActivity extends AppCompatActivity {
    ImageView imageView;
    TextView title;
    TextView type;
    TextView cost;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_item);
        imageView = (ImageView) findViewById(R.id.iv_item_image);
        title = (TextView) findViewById(R.id.tv_title_item);
        type = (TextView) findViewById(R.id.tv_type_item);
        cost = (TextView) findViewById(R.id.tv_cost_item);
        title.setText(Controler.getControler().getItem().getTitle());
        type.setText(Controler.getControler().getItem().getType());
        cost.setText(Controler.getControler().getItem().getGift_cost());
        imageView.setImageDrawable(Controler.getControler().getImageView().getDrawable());
    }
}
