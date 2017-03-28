package com.example.amangupta.servicealarm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by aMAN GUPTA on 3/10/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyHonder> {

    public class MyHonder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView task;

        public MyHonder(View itemView) {
            super(itemView);
            task = (TextView) itemView.findViewById(R.id.tv_item_name);
            itemView.findViewById(R.id.bt_delete_item).setOnClickListener(this);
        }

        @Override

        public void onClick(View v) {
            if (v.getId() == R.id.bt_delete_item) {
                MyThread.taskList.remove(new Task(0, task.getText().toString()));
                notifyDataSetChanged();
            }
        }
    }

    @Override
    public MyHonder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view, parent, false);
        MyHonder myHonder = new MyHonder(view);
        return myHonder;
    }

    @Override
    public void onBindViewHolder(MyHonder holder, int position) {
        holder.task.setText(MyThread.taskList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return MyThread.taskList.size();
    }
}
