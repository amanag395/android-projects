package com.example.amangupta.recycleviewloadmore.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amangupta.recycleviewloadmore.R;
import com.example.amangupta.recycleviewloadmore.controler.Controler;

import java.util.ResourceBundle;

/**
 * Created by aMAN GUPTA on 3/21/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyHolder> {
    OnLoadMore onLoadMore;

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    public interface OnLoadMore {
        void loadMore();
    }

    public void setOnLoadMore(OnLoadMore onLoadMore) {
        this.onLoadMore = onLoadMore;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (position >= getItemCount() - 1) {
            onLoadMore.loadMore();
        }
        holder.textView.setText(Controler.getControler().getList().get(position));
    }

    @Override
    public int getItemCount() {
        return Controler.getControler().getList().size();
    }

}
