package com.example.amangupta.notification.controller;

import java.io.File;

public class FileController {
    private static FileController fileController;
    private File file;
    private boolean isCopying;
    private FileController(){
        isCopying = false;
    }

    public static FileController getFileController(){
        if (fileController == null){
            fileController = new FileController();
        }
        return fileController;
    }

    public boolean isCopying() {
        return isCopying;
    }

    public void setCopying(boolean copying) {
        isCopying = copying;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
