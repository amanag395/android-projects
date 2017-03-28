package com.example.amangupta.recycleviewloadmore.controler;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 3/21/2017.
 */

public class Controler {
    private static Controler controler;
    private ArrayList<String> list;

    private Controler() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("Item " + (int) (Math.random() * 197));
        }
    }

    public static Controler getControler() {
        if (controler == null) {
            controler = new Controler();
        }
        return controler;
    }

    public boolean addToList() {
        return list.add("Item " + (int) (Math.random() * 113));
    }

    public ArrayList<String> getList() {
        return list;
    }
}
