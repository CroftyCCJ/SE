package com.company;

public class Singleton {
    private static Singleton ourInstance = new Singleton();

    private int xPos = 30;
    private int yPos = 30;

    private boolean isUpdate;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        return ourInstance;
    }


    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }
}
