package com.company;

public class Singleton {
    private static Singleton ourInstance = new Singleton();
    private int xpos= 15;
    private int ypos = 15;
    public static Singleton getInstance() {
        return ourInstance;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    private Singleton() {

    }
}
