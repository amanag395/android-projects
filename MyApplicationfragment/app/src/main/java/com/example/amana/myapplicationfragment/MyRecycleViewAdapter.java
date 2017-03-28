package com.example.amana.myapplicationfragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 2/22/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.UserHolder> {
    private static final String LOG = MyRecycleViewAdapter.class.getName();
    private ArrayList<User> mDataset;
    private static MyClickListener myClickListener;

    public static class UserHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView name;
        TextView userName;
        TextView password;

        public UserHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name_recycle);
            password = (TextView) itemView.findViewById(R.id.tv_password_recycle);
            userName = (TextView) itemView.findViewById(R.id.tv_userName_recycle);
            Log.d(LOG, "User Holder");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(LOG, "onClick");
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecycleViewAdapter(ArrayList<User> myDataset) {
        this.mDataset = myDataset;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(LOG, "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        Log.d(LOG, "onBindViewHolder");
        holder.name.setText(mDataset.get(position).getName());
        holder.userName.setText(mDataset.get(position).getUserName());
        holder.password.setText(mDataset.get(position).getPassword());

    }

    public void addItem(User dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        Log.d(LOG, "getItemCount");
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}


