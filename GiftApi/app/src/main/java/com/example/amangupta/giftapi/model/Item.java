package com.example.amangupta.giftapi.model;

/**
 * Created by aMAN GUPTA on 3/17/2017.
 */

public class Item {
    String title;
    String gift_type;
    String gift_cost;
    String hres_url;

    public Item(String title, String type, String gift_cost, String hres_url) {
        this.title = title;
        this.gift_type = type;
        this.gift_cost = gift_cost;
        this.hres_url = hres_url;
    }

    public String getHres_url() {
        return hres_url;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return gift_type;
    }

    public String getGift_cost() {
        return gift_cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return title.equals(item.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
