package craterzone.chatbubble.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import craterzone.chatbubble.R;
import craterzone.chatbubble.model.ChatItem;

/**
 * Created by aMAN GUPTA on 3/3/2017.
 */

public class MyRecycleViewAdpeter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ChatItem> dataSet;
    MyClickListener myClickListener;

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public MyRecycleViewAdpeter() {
        this.dataSet = new ArrayList<>();
        this.myClickListener = null;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_send, parent, false);
                MyHolder0 myHolder = new MyHolder0(view);
                return myHolder;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_recive, parent, false);
                MyHolder1 myHolder1 = new MyHolder1(view);
                return myHolder1;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyHolder0) {
            MyHolder0 userHolder0 = (MyHolder0) holder;
            userHolder0.message.setText(dataSet.get(position).getMessage());
        } else {
            MyHolder1 userHolder1 = (MyHolder1) holder;
            userHolder1.message.setText(dataSet.get(position).getMessage());
        }
    }
//
//    @Override
//    public void onBindViewHolder(MyHolder holder, int position) {
//        holder.message.setText(dataSet.get(position).getMessage());
//    }

    public void addMessage(ChatItem chatItem) {
        dataSet.add(chatItem);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView message;

        public MyHolder1(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.tv_chat_message_recive);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String time = dataSet.get(getAdapterPosition()).getTime();
            if (myClickListener != null) {
                myClickListener.onItemClick(time);
            }

        }
    }

    public class MyHolder0 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView message;

        public MyHolder0(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.tv_chat_message_send);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String time = dataSet.get(getAdapterPosition()).getTime();
            if (myClickListener != null) {
                myClickListener.onItemClick(time);
            }

        }
    }

    public interface MyClickListener {
        public void onItemClick(String time);
    }

}
