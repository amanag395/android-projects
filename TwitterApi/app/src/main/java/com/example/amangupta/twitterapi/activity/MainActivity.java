package com.example.amangupta.twitterapi.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.example.amangupta.twitterapi.R;
import com.example.amangupta.twitterapi.pager.Pager;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "HS2H0gmnJOce4AviJ4VJ419Wv";
    private static final String TWITTER_SECRET = "dmcOiPEv5ztHiwbYx0HDnnHebDI6piiuAWvLzhbAOAWHB63bht";
    private static final String SEARCH = "#srk";
    private TwitterAuthConfig authConfig;
    ViewPager viewPager;
    TabLayout tabLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics());
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.addTab(tabLayout.newTab().setText("SRK"));
        tabLayout.addTab(tabLayout.newTab().setText("DEMONETISATION"));
        tabLayout.addTab(tabLayout.newTab().setText("MODI"));
        tabLayout.addTab(tabLayout.newTab().setText("BOMBAY"));
        Pager pager = new Pager(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pager);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
