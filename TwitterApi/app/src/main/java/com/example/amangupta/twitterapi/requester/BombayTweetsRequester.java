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

public class BombayTweetsRequester implements Runnable {
    private String SEARCH;
    private TwitterCore twitterCore;
    private BombayPostExecute postExecute;

    public BombayTweetsRequester(String string, TwitterCore twitterCore, BombayPostExecute postExecute) {
        this.SEARCH = string;
        this.twitterCore = twitterCore;
        this.postExecute = postExecute;
    }

    @Override
    public void run() {
        Call<Search> searchCall;
        if (TweetsController.getTweetController().getBombayTweets().size() == 0) {
            searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(SEARCH, null, null, null, "recent", 20, null, null, null, true);
        } else {
            searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(SEARCH, null, null, null, "recent", 20, null, TweetsController.getTweetController().getBombayTweets().get(0).id, null, true);
        }

        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void success(Result<Search> result) {
                TweetsController.getTweetController().addToBombayTweets(result.data.tweets);

                postExecute.bombayPostExecute();

            }

            @Override
            public void failure(TwitterException exception) {


            }
        });
    }

    public interface BombayPostExecute {
        void bombayPostExecute();
    }
}