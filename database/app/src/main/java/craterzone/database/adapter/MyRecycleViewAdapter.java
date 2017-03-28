package craterzone.database.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import craterzone.database.R;
import craterzone.database.constants.Constants;
import craterzone.database.model.User;

/**
 * Created by aMAN GUPTA on 2/27/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String LOG = MyRecycleViewAdapter.class.getName();
    private ArrayList<User> mDataset;
    private static String string;
    private static MyClickListener myClickListener;

    public void setOnItemClickListener(MyClickListener onItemClickListener) {
        this.myClickListener = onItemClickListener;
    }
    public class UserHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userName;

        public UserHolder1(View UserView) {
            super(UserView);
            userName = (TextView) UserView.findViewById(R.id.bt_recycle_view_item_username);
            userName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            User user = mDataset.get(getAdapterPosition());
            if (myClickListener != null) {
                myClickListener.onUserClick(user.getName(),user.getUserName(),user.getDescribe());
            }
        }
    }

    public class UserHolder0 extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button userName;

        public UserHolder0(View UserView) {
            super(UserView);
            userName = (Button) UserView.findViewById(R.id.bt_recycle_view_item_username);
            userName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            User user = mDataset.get(getAdapterPosition());
            if (myClickListener != null) {
                myClickListener.onUserClick(user.getName(),user.getUserName(),user.getDescribe());
            }
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder userHolder = null;
        switch (viewType){
            case Constants.CASE_ZERO:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item_button, parent, false);
                userHolder = new UserHolder0(view);
                return userHolder;
            case Constants.CASE_ONE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item_text_view, parent, false);
                userHolder = new UserHolder1(view);
                return userHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case Constants.CASE_ZERO:
                UserHolder0 userHolder0 = (UserHolder0) holder;
                userHolder0.userName.setText(mDataset.get(position).getUserName());
                break;
            case Constants.CASE_ONE:
                UserHolder1 userHolder1 = (UserHolder1) holder;
                userHolder1.userName.setText(mDataset.get(position).getUserName());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position%2;
    }

    public void setOnUserClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecycleViewAdapter(ArrayList<User> myDataset) {
        this.mDataset = myDataset;
    }


//    @Override
//    public void onBindViewHolder(UserHolder0 holder, int position) {
//        holder.userName.setText(mDataset.get(position).getUserName());
//    }
//
    @Override
    public int getItemCount() {
        return mDataset.size();
    }




    public interface MyClickListener {
        public void onUserClick(String name,String userName,String desc);
    }
}
