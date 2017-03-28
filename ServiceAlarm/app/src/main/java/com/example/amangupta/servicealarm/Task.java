package com.example.amangupta.servicealarm;

import java.sql.Timestamp;

/**
 * Created by aMAN GUPTA on 3/10/2017.
 */

public class Task {
    private long time;
    private String name;

    public Task(long time, String name) {
        this.time = time;
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return name.equals(task.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
