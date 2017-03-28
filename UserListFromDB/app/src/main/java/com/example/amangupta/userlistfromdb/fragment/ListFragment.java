package com.example.amangupta.userlistfromdb.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amangupta.userlistfromdb.constant.Constants;
import com.example.amangupta.userlistfromdb.R;
import com.example.amangupta.userlistfromdb.adapter.MyRecycleViewAdapter;
import com.example.amangupta.userlistfromdb.controller.UserController;
import com.example.amangupta.userlistfromdb.model.User;

import org.json.JSONException;
import org.json.JSONObject;

public class ListFragment extends Fragment implements View.OnClickListener, MyRecycleViewAdapter.MyClickListener {
    private Context context;
    RecyclerView recyclerView;
    private MyRecycleViewAdapter mAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_user_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecycleViewAdapter();
        mAdapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(mAdapter);
        view.findViewById(R.id.bt_add_user).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_add_user) {
            String name = Constants.NAME + ((int) (Math.random() * 113));
            String age = Constants.Age + ((int) (Math.random() * 113));
            String response = "{ \"Name\":" + name + " \"Age\":" + age + " }";
            try {
                JSONObject jsonObject = new JSONObject(response);
                name = jsonObject.getString(Constants.NAME);
                age = jsonObject.getString(Constants.Age);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UserController.getUserController().insertUserToDataBase(new User(name, age));
            mAdapter.addItem(new User(name, age), mAdapter.getItemCount());
        }
    }

    @Override
    public void onItemDelete(final int position, final User user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(Constants.DELETE_MESSAGE).setTitle(Constants.DELETE_TITLE);
        builder.setPositiveButton(Constants.YES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UserController.getUserController().deleteFromDataBase(user);
                mAdapter.deleteItem(position);
            }
        });
        builder.setNegativeButton(Constants.NO, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
