package com.example.amangupta.twitterapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amangupta.twitterapi.R;
import com.example.amangupta.twitterapi.controller.TweetsController;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by aMAN GUPTA on 4/6/2017.
 */

public class ModiRecycleViewAdapter extends RecyclerView.Adapter<ModiRecycleViewAdapter.ModiViewHolder> {
    Context context;
    List<Tweet> tweets;
    OnLoadMore onLoadMore;

    public ModiRecycleViewAdapter(Context context, List<Tweet> tweets,OnLoadMore onLoadMore) {
        this.context = context;
        this.tweets = tweets;
        this.onLoadMore = onLoadMore;
    }

    public interface OnLoadMore {
        void loadMore();
        void onClickUser(Long id);
        void onClickUrl(String url);
    }
    @Override
    public ModiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet, parent, false);
        ModiViewHolder holder = new ModiViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ModiViewHolder holder, final int position) {
        if (position >= getItemCount() - 15) {
            onLoadMore.loadMore();
        }
        Glide.with(context).load(tweets.get(position).user.profileImageUrl).into(holder.profileImage);
        holder.profileName.setText(tweets.get(position).user.name);
        holder.createTime.setText(tweets.get(position).createdAt.substring(0,19));
        if (tweets.get(position).entities != null && tweets.get(position).entities.userMentions != null){
            SpannableString ss = new SpannableString(tweets.get(position).text);
            for (int i = 0 ; i<tweets.get(position).entities.userMentions.size();i++){
                String user = tweets.get(position).entities.userMentions.get(i).screenName;
                int startIndex = ss.toString().indexOf(user);
                int endIndex = startIndex + user.length();
                final int finalI = i;
                ClickableSpan clickableSpan = new ClickableSpan() {
                    @Override
                    public void onClick(View textView) {
                        onLoadMore.onClickUser(tweets.get(position).entities.userMentions.get(finalI).id);
                    }
                };
                if (startIndex>0&&endIndex<=ss.toString().length()){
                    ss.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
            if (tweets.get(position).entities.urls != null){
                for (int i = 0 ; i<tweets.get(position).entities.urls.size();i++){
                    String url = tweets.get(position).entities.urls.get(i).url;
                    int startIndex = ss.toString().indexOf(url);
                    int endIndex = startIndex + url.length();
                    final int finalI = i;
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(View textView) {
                            onLoadMore.onClickUrl(tweets.get(position).entities.urls.get(finalI).url);
                        }
                    };
                    if (startIndex>0&&endIndex<=ss.toString().length()){
                        ss.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
            if (tweets.get(position).entities.urls != null){
                for (int i = 0 ; i<tweets.get(position).entities.urls.size();i++){
                    String url = tweets.get(position).entities.urls.get(i).url;
                    int startIndex = ss.toString().indexOf(url);
                    int endIndex = startIndex + url.length();
                    final int finalI = i;
                    ClickableSpan clickableSpan = new ClickableSpan() {
                        @Override
                        public void onClick(View textView) {
                            onLoadMore.onClickUrl(tweets.get(position).entities.urls.get(finalI).url);
                        }
                    };
                    if (startIndex>0&&endIndex<=ss.toString().length()){
                        ss.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }
            holder.tweetContent.setText(ss);
            holder.tweetContent.setMovementMethod(LinkMovementMethod.getInstance());

        }else {
            holder.tweetContent.setText(tweets.get(position).text);
        }
        if(tweets.get(position).entities != null && tweets.get(position).entities.media != null && tweets.get(position).extendedEtities.media.get(0).type.equals("photo")){
            holder.tweetImage.setVisibility(View.VISIBLE);
            Glide.with(context).load(tweets.get(position).extendedEtities.media.get(0).mediaUrl).into(holder.tweetImage);
        }else {
            holder.tweetImage.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public class ModiViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView profileName;
        TextView createTime;
        TextView tweetContent;
        ImageView tweetImage;

        public ModiViewHolder(View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.iv_profile);
            profileName = (TextView) itemView.findViewById(R.id.tv_name);
            createTime = (TextView) itemView.findViewById(R.id.tv_time);
            tweetContent = (TextView) itemView.findViewById(R.id.tv_tweet_content);
            tweetImage = (ImageView) itemView.findViewById(R.id.iv_tweet_image);
        }
    }
}
