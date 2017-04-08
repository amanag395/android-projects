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
import com.example.amangupta.twitterapi.adapter.ModiRecycleViewAdapter;
import com.example.amangupta.twitterapi.constants.Constants;
import com.example.amangupta.twitterapi.controller.TweetsController;
import com.example.amangupta.twitterapi.requester.ModiTweetsRequester;
import com.example.amangupta.twitterapi.requester.SrkTweetsRequester;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Search;

import retrofit2.Call;

/**
 * Created by aMAN GUPTA on 4/6/2017.
 */

public class ModiFragment extends Fragment implements ModiTweetsRequester.ModiPostExecute, SwipeRefreshLayout.OnRefreshListener, ModiRecycleViewAdapter.OnLoadMore {
    Context context;
    RecyclerView recyclerView;
    ModiRecycleViewAdapter adpeter;
    RecyclerView.LayoutManager layoutManager;
    SwipeRefreshLayout swipeRefreshLayout;
    TwitterCore twitterCore;
    ModiTweetsRequester modiTweetsRequester;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_modi, container, false);
        twitterCore = TwitterCore.getInstance();
        modiTweetsRequester = new ModiTweetsRequester(Constants.MODI,twitterCore,this);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_modi);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_modi_tweets);
        adpeter = new ModiRecycleViewAdapter(context, TweetsController.getTweetController().getModiTweets(),this);
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adpeter);
        adpeter.notifyDataSetChanged();
        swipeRefreshLayout.setOnRefreshListener(this);
        new Thread(modiTweetsRequester).start();
        return view;
    }

    @Override
    public void modiPostExecute() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adpeter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onRefresh() {
        new Thread(modiTweetsRequester).start();
    }

    @Override
    public void loadMore() {
        Call<Search> searchCall = twitterCore.getGuestApiClient().getSearchService().tweets(Constants.MODI, null, null, null, "recent", 20, null, null, TweetsController.getTweetController().getModiTweets().get(TweetsController.getTweetController().getModiTweets().size()-1).id - 1, true);
        searchCall.enqueue(new Callback<Search>() {
            @Override
            public void success(Result<Search> result) {
                TweetsController.getTweetController().addModiTweets( result.data.tweets);
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
