package com.example.amangupta.giftapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amangupta.giftapi.R;
import com.example.amangupta.giftapi.activity.OnClickActivity;
import com.example.amangupta.giftapi.controler.Controler;
import com.example.amangupta.giftapi.model.Item;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 3/17/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyHolder> {
    ArrayList<Item> items;
    Context context;
    public MyRecycleViewAdapter(ArrayList<Item> items,Context context ) {
        this.items = items;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).load(items.get(position).getHres_url()).into(holder.imageView);
        holder.title.setText(items.get(position).getTitle());
        holder.cost.setText(items.get(position).getGift_cost());
        holder.type.setText(items.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView type;
        TextView cost;
        ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_item);
            type = (TextView) itemView.findViewById(R.id.tv_type);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            cost = (TextView) itemView.findViewById(R.id.tv_cost);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Controler.getControler().setImageView(imageView);
            Controler.getControler().setItem(new Item(title.getText().toString(),type.getText().toString(),cost.getText().toString(),null));
            Intent intent = new Intent(context, OnClickActivity.class);
            context.startActivity(intent);
        }
    }
}
