package com.example.amangupta.userlistfromdb.controller;

import com.example.amangupta.userlistfromdb.model.User;
import com.example.amangupta.userlistfromdb.table.RegisterUser;

import java.util.ArrayList;

public class UserController {
    private static UserController userController;
    private ArrayList<User> users;
    private UserController(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                users = RegisterUser.getRegisterUser().getUsers();
            }
        });
        thread.start();
    }

    public static UserController getController(){
        if (userController ==null){
            userController = new UserController();
        }
        return userController;
    }

    public static UserController getUserController() {
        return userController;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void insertUserToDataBase(final User user) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                RegisterUser.getRegisterUser().insertUser(user);
            }
        });
        thread.start();
    }

    public void deleteFromDataBase(final User user) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                RegisterUser.getRegisterUser().deleteUser(user);
            }
        });
        thread.start();
    }
}
