package com.example.amangupta.giftapi.controler;

import android.widget.ImageView;

import com.example.amangupta.giftapi.model.Item;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 3/17/2017.
 */

public class Controler {
    private ArrayList<Item> list;
    private Item item;
    private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    private static Controler controler;

    private Controler() {
        list = new ArrayList<>();
    }

    public static Controler getControler() {
        if (controler == null) {
            controler = new Controler();
        }
        return controler;
    }

    public boolean addtemToList(Item item) {
        return list.add(item);
    }

    public ArrayList<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list.addAll(list);
    }
}
