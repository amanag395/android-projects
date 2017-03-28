package com.example.amangupta.userlistfromdb.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amangupta.userlistfromdb.R;
import com.example.amangupta.userlistfromdb.model.User;
import com.example.amangupta.userlistfromdb.controller.UserController;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.UserHolder> {
    private static MyClickListener myClickListener;

    public static class UserHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView name;
        TextView age;
        ImageView imageView;

        public UserHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_item_name);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            age = (TextView) itemView.findViewById(R.id.tv_item_age);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            User user = new User(name.getText().toString(),null);
            myClickListener.onItemDelete(UserController.getController().getUsers().indexOf(user),user);
            return false;
        }
    }

    public void setOnItemLongClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.name.setText(UserController.getController().getUsers().get(position).getName());
        holder.age.setText(UserController.getController().getUsers().get(position).getAge());
    }

    public void addItem(User dataObj, int index) {
        UserController.getController().getUsers().add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        UserController.getController().getUsers().remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return UserController.getController().getUsers().size();
    }

    public interface MyClickListener {
        public void onItemDelete(int position,User user);
    }
}


