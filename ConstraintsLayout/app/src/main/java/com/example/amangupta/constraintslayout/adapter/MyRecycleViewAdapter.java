package com.example.amangupta.constraintslayout.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amangupta.constraintslayout.R;
import com.example.amangupta.constraintslayout.model.Item;

import java.util.ArrayList;
/**
 * Created by aMAN GUPTA on 2/22/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.UserHolder> {
    private static final String LOG = MyRecycleViewAdapter.class.getName();
    private ArrayList<Item> mDataset;
    private static MyClickListener myClickListener;

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        public UserHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_recycle_name);
            Log.d(LOG, "User Holder");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d(LOG, "onClick");
            String name = mDataset.get(getAdapterPosition()).getName();

//            Toast.makeText(v.getContext(),name,Toast.LENGTH_SHORT).show();

            if (myClickListener != null) {
                myClickListener.onItemClick(name);
            }
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecycleViewAdapter(ArrayList<Item> myDataset) {
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
    }

    public void addItem(Item dataObj, int index) {
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
        public void onItemClick(String name);
    }
}


