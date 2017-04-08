package com.example.amangupta.twitterapi.requester;

import com.example.amangupta.twitterapi.controller.TweetsController;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;

import retrofit2.Call;

/**
 * Created by aMAN GUPTA on 4/6/2017.
 */

public class SrkTweetsRequester implements Runnable {
    private String SEARCH;
    private TwitterCore twitterCore;
    private SrkPostExecute postExecute;

    public SrkTweetsRequester(String string, TwitterCore twitterCore , SrkPostExecute postExecute) {
        this.SEARCH = string;
        this.twitterCore = twitterCore;
        this.postExecute = postExecute;
    }

    @Override
    public void run() {
        Call<Search> searchCall;
        if (TweetsController.getTweetController().getSrkTweets().size()==0){
            searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(SEARCH, null, null, null, "recent", 20, null, null, null, true);
        } else {
            searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(SEARCH, null, null, null, "recent", 20, null, TweetsController.getTweetController().getSrkTweets().get(0).id, null, true);
        }

        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void success(Result<Search> result) {
                TweetsController.getTweetController().addToSrkTweets( result.data.tweets);
                postExecute.srkPostExecute();


            }

            @Override
            public void failure(TwitterException exception) {


            }
        });
    }

    public interface SrkPostExecute {
        void srkPostExecute();
    }
}
