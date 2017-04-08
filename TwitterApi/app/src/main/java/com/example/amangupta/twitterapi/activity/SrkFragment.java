package com.example.amangupta.twitterapi.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amangupta.twitterapi.R;
import com.example.amangupta.twitterapi.adapter.SrkRecycleViewAdapter;
import com.example.amangupta.twitterapi.constants.Constants;
import com.example.amangupta.twitterapi.controller.TweetsController;
import com.example.amangupta.twitterapi.requester.SrkTweetsRequester;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;

import retrofit2.Call;

public class SrkFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, SrkTweetsRequester.SrkPostExecute, SrkRecycleViewAdapter.OnLoadMore {
    Context context;
    RecyclerView recyclerView;
    SrkRecycleViewAdapter adpeter;
    RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout swipeRefreshLayout;
    TwitterCore twitterCore;
    SrkTweetsRequester srkTweetsRequester;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_srk, container, false);
        twitterCore = TwitterCore.getInstance();
        srkTweetsRequester = new SrkTweetsRequester(Constants.IMSRK,twitterCore,this);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_srk);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_srk_tweets);
        adpeter = new SrkRecycleViewAdapter(context, TweetsController.getTweetController().getSrkTweets(),this);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpeter);
        swipeRefreshLayout.setOnRefreshListener(this);
        new Thread(srkTweetsRequester).start();
        return view;

    }

    @Override
    public void onRefresh() {
        new Thread(srkTweetsRequester).start();

    }

    @Override
    public void srkPostExecute() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adpeter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void loadMore() {
        Call<Search> searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(Constants.IMSRK, null, null, null, "recent", 20, null, null, TweetsController.getTweetController().getSrkTweets().get(TweetsController.getTweetController().getSrkTweets().size()-1).id - 1, true);
        searchCall.enqueue(new Callback<Search>() {
        @Override
        public void success(Result<Search> result) {
            TweetsController.getTweetController().addSrkTweets( result.data.tweets);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adpeter.notifyDataSetChanged();
                }
            });
        }

            @Override
        public void failure(TwitterException exception) {
        }
    });
    }

    @Override
    public void onClickUser(Long id) {
        String url = "https://twitter.com/intent/user?user_id="+id;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onClickUrl(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
