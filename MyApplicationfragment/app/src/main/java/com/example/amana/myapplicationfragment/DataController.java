package com.example.amana.myapplicationfragment;

/**
 * Created by amana on 2/21/2017.
 */

public class DataController {
    static DataController controller;

    private String userData;

    private DataController() {

    }

    public static DataController getController() {
        if (controller == null)
            controller = new DataController();
        return controller;
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }
}
