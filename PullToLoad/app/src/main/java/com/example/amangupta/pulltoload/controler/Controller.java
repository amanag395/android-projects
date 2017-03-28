package com.example.amangupta.pulltoload.controler;

import java.util.ArrayList;

/**
 * Created by aMAN GUPTA on 3/21/2017.
 */

public class Controller {
    private static Controller controller;
    private ArrayList<String> list;

    private Controller() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add("Item " + (int) (Math.random() * 197));
        }
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public boolean addToList() {
        return list.add("On Scroll" + (int) (Math.random() * 113));
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void addToListOnPull() {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            tempList.add("On Pull" + (int) (Math.random() * 113));
        tempList.addAll(list);
        list.clear();
        list.addAll(tempList);
    }
}
