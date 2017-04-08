package com.example.amangupta.twittertweetprototype.requester;

import com.twitter.sdk.android.tweetui.SearchTimeline;

public class GetStatus extends Thread {
    String queryString;
    CallBackListner callBackListner;

    public GetStatus(String queryString, CallBackListner callBackListner) {
        this.queryString = queryString;
        this.callBackListner = callBackListner;
    }

    @Override
    public void run() {
        SearchTimeline searchTimeline = new SearchTimeline.Builder().query("imsrk").build();

    }

    public interface CallBackListner{
        public void setQuery(SearchTimeline searchTimeline);
    }
}
