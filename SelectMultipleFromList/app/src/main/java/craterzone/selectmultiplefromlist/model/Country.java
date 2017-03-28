package craterzone.selectmultiplefromlist.model;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by aMAN GUPTA on 3/6/2017.
 */

public class Country {
    private String name;
    private boolean isSlected;

    public Country(String name) {
        this.name = name.toUpperCase();
        this.isSlected = false;
    }

    public boolean isSlected() {
        return isSlected;
    }

    public void setSlected() {
        isSlected = !isSlected;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
