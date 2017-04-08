package com.example.amangupta.twitterapi.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.amangupta.twitterapi.activity.BombayFragment;
import com.example.amangupta.twitterapi.activity.DemonetisationFragment;
import com.example.amangupta.twitterapi.activity.ModiFragment;
import com.example.amangupta.twitterapi.activity.SrkFragment;

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                SrkFragment srkFragment = new SrkFragment();
                return srkFragment;
            case 1:
                DemonetisationFragment demonetisationFragment = new DemonetisationFragment();
                return demonetisationFragment;
            case 2:
                ModiFragment modiFragment = new ModiFragment();
                return modiFragment;
            case 3:
                BombayFragment bombayFragment = new BombayFragment();
                return bombayFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
