package craterzone.selectmultiplefromlist.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import craterzone.selectmultiplefromlist.R;
import craterzone.selectmultiplefromlist.model.Country;

/**
 * Created by aMAN GUPTA on 3/6/2017.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.UserHolder> {
    ArrayList<Country> mDataset;
    ArrayList<Country> searchSet;
    MyClickListener myClickListener;


    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }


    public MyRecycleViewAdapter(ArrayList<Country> myDataset) {
        this.mDataset = myDataset;
        this.searchSet = new ArrayList<>();
        this.searchSet.addAll(myDataset);
    }

    public MyRecycleViewAdapter() {
        this.mDataset = new ArrayList<>();
        this.searchSet = new ArrayList<>();
    }


//    public void addItem(Country dataObj, int index) {
//        mDataset.add(dataObj);
//        notifyItemInserted(index);
//    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        mDataset.clear();
        if (charText.length() == 0) {
            mDataset.addAll(searchSet);
        } else {
            for (Country country : searchSet) {
                if (country.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    mDataset.add(country);
                }
            }
        }
        notifyDataSetChanged();
    }

    class Asc implements Comparator<Country> {

        @Override
        public int compare(Country o1, Country o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    class Desc implements Comparator<Country> {

        @Override
        public int compare(Country o1, Country o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }

    Asc asc = new Asc();
    Desc desc = new Desc();

    public void sortA() {
//        ArrayList<String> sortList = new ArrayList<>();
//        for (int i = 0; i<mDataset.size();i++){
//            sortList.add(i,mDataset.get(i).getName());
//        }
//        Collections.sort(sortList);
//        mDataset.clear();
//        for (String country : sortList) {
//            mDataset.add(new Country(country));
//        }
        Collections.sort(mDataset, asc);
//        Collections.sort(mDataset);
        notifyDataSetChanged();
    }

    public void sortZ() {
//        ArrayList<String> sortList = new ArrayList<>();
//        for (int i = 0; i<mDataset.size();i++){
//            sortList.add(i,mDataset.get(i).getName());
//        }
//        Collections.sort(sortList);
//        Collections.reverse(sortList);
//        mDataset.clear();
//        for (String country : sortList) {
//            mDataset.add(new Country(country));
//        }
        Collections.sort(mDataset, desc);
        notifyDataSetChanged();
    }

    public class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView countryName;

        public UserHolder(View itemView) {
            super(itemView);
            countryName = (TextView) itemView.findViewById(R.id.tv_item);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Country country = mDataset.get(getAdapterPosition());
            if (myClickListener != null) {
                myClickListener.onItemClick(country, v);
            }
        }

    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        UserHolder userHolder = new UserHolder(view);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        Country country = mDataset.get(position);
        holder.countryName.setBackgroundColor(country.isSlected() ? Color.CYAN : Color.WHITE);
        holder.countryName.setText(mDataset.get(position).getName());
    }

    public ArrayList<Country> getmDataset() {
        return mDataset;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(Country country, View view);
    }
}
