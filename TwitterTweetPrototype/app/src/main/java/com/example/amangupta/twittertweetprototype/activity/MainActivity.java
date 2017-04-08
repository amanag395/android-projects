package com.example.amangupta.twittertweetprototype.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.example.amangupta.twittertweetprototype.R;

import com.example.amangupta.twittertweetprototype.constants.Constants;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    

    private static final String TWITTER_KEY = "5RPEwEVYVewvfdqmMrw378Y8Z";
    private static final String TWITTER_SECRET = "IKmBYmX6gr9yXnd08TchW6FxCGRl1FsAd21ZGjhC2UMlnRP0Xm";

    Button srk;
    Button demonetisation;
    Button modi;
    Button bombay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Crashlytics(), new Twitter(authConfig));
        TwitterCore twitterCore = new TwitterCore(authConfig);
        srk = (Button) findViewById(R.id.bt_srk);
        demonetisation = (Button) findViewById(R.id.bt_demonetisation);
        modi = (Button) findViewById(R.id.bt_modi);
        bombay = (Button) findViewById(R.id.bt_bombay);
        srk.setOnClickListener(this);
        demonetisation.setOnClickListener(this);
        modi.setOnClickListener(this);
        bombay.setOnClickListener(this);
        srk.callOnClick();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_srk){
            demonetisation.setTextColor(Color.BLUE);
            modi.setTextColor(Color.BLUE);
            bombay.setTextColor(Color.BLUE);
            srk.setTextColor(Color.RED);
            SearchTimeline searchTimeline = new SearchTimeline.Builder().query(Constants.IMSRK).build();
            final TweetTimelineListAdapter tweetTimelineListAdapter = new TweetTimelineListAdapter(this,searchTimeline);
            ListView timelineView = (ListView) findViewById(R.id.event_timeline);

            timelineView.setAdapter(tweetTimelineListAdapter);
        }else if (v.getId() == R.id.bt_demonetisation){
            srk.setTextColor(Color.BLUE);
            modi.setTextColor(Color.BLUE);
            bombay.setTextColor(Color.BLUE);
            demonetisation.setTextColor(Color.RED);
            SearchTimeline searchTimeline = new SearchTimeline.Builder().query(Constants.DEMONETISATION).build();
            final TweetTimelineListAdapter tweetTimelineListAdapter = new TweetTimelineListAdapter(this,searchTimeline);
            ListView timelineView = (ListView) findViewById(R.id.event_timeline);
            timelineView.setAdapter(tweetTimelineListAdapter);
        }else if (v.getId() == R.id.bt_modi){
            srk.setTextColor(Color.BLUE);
            demonetisation.setTextColor(Color.BLUE);
            bombay.setTextColor(Color.BLUE);
            modi.setTextColor(Color.RED);
            SearchTimeline searchTimeline = new SearchTimeline.Builder().query(Constants.MODI).build();
            final TweetTimelineListAdapter tweetTimelineListAdapter = new TweetTimelineListAdapter(this,searchTimeline);
            ListView timelineView = (ListView) findViewById(R.id.event_timeline);
            timelineView.setAdapter(tweetTimelineListAdapter);
        }else if (v.getId() == R.id.bt_bombay){
            srk.setTextColor(Color.BLUE);
            demonetisation.setTextColor(Color.BLUE);
            modi.setTextColor(Color.BLUE);
            bombay.setTextColor(Color.RED);
            SearchTimeline searchTimeline = new SearchTimeline.Builder().query(Constants.BOMBAY).build();
            final TweetTimelineListAdapter tweetTimelineListAdapter = new TweetTimelineListAdapter(this,searchTimeline);
            ListView timelineView = (ListView) findViewById(R.id.event_timeline);
            timelineView.setAdapter(tweetTimelineListAdapter);
        }
    }
}
