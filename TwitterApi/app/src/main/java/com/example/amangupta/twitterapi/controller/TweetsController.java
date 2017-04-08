package com.example.amangupta.twitterapi.controller;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aMAN GUPTA on 4/6/2017.
 */

public class TweetsController {
    private List<Tweet> srkTweets;
    private List<Tweet> demonetisationTweets;
    private List<Tweet> modiTweets;
    private List<Tweet> bombayTweets;
    private static TweetsController tweetsController;
    private TweetsController(){
        this.srkTweets = new ArrayList<>();
        this.demonetisationTweets = new ArrayList<>();
        this.modiTweets = new ArrayList<>();
        this.bombayTweets = new ArrayList<>();
    }

    public static TweetsController getTweetController(){
        if (tweetsController == null ){
            tweetsController = new TweetsController();
        }
        return tweetsController;
    }

    public List<Tweet> getSrkTweets() {
        return srkTweets;
    }

    public List<Tweet> getDemonetisationTweets() {
        return demonetisationTweets;
    }

    public List<Tweet> getModiTweets() {
        return modiTweets;
    }

    public List<Tweet> getBombayTweets() {
        return bombayTweets;
    }

    public void addToSrkTweets(List<Tweet> srkTweets) {
        this.srkTweets.addAll(0,srkTweets);
    }

    public void addToDemonetisationTweets(List<Tweet> demonetisationTweets) {
        this.demonetisationTweets.addAll(0,demonetisationTweets);
    }

    public void addToModiTweets(List<Tweet> modiTweets) {
        this.modiTweets.addAll(0,modiTweets);
    }

    public void addToBombayTweets(List<Tweet> bombayTweets) {
        this.bombayTweets.addAll(0,bombayTweets);
    }
    public void addSrkTweets(List<Tweet> srkTweets) {
        this.srkTweets.addAll(srkTweets);
    }

    public void addDemonetisationTweets(List<Tweet> demonetisationTweets) {
        this.demonetisationTweets.addAll(demonetisationTweets);
    }

    public void addModiTweets(List<Tweet> modiTweets) {
        this.modiTweets.addAll(modiTweets);
    }

    public void addBombayTweets(List<Tweet> bombayTweets) {
        this.bombayTweets.addAll(bombayTweets);
    }
}
