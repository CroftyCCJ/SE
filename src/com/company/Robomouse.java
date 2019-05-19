package com.company;

import javax.swing.*;
import java.awt.*;

class Robomouse extends Frame {
    // Frame
    static JFrame f;

    // textField
    static TextField x, y;

    // default constructor
    Robomouse() {
    }


    public void mouseMoveTest() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // object of class
                Robomouse rm = new Robomouse();

                // create a frame
                f = new JFrame("Robomouse");

                // set the frame to close on exit
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // create textfield
                x = new TextField(7);
                y = new TextField(7);

                // create a button
                Button b = new Button("OK");


                // create a panel
                Panel panel = new Panel();

                // add items to panel
                panel.add(x);
                panel.add(y);
                panel.add(b);

                f.add(panel);

                // setsize of frame
                f.setSize(300, 300);

                f.show();

                try {
                    Robot r = new Robot();
                    int xi1, yi1, xi, yi;


                    // get x and y points
            /*xi1 = Integer.parseInt(x.getText());
            yi1 = Integer.parseInt(y.getText());*/


                    while (true) {

                        if (Singleton.getInstance().isUpdate()) {

                            // get initial loction
                            Point p = MouseInfo.getPointerInfo().getLocation();
                            xi = p.x;
                            yi = p.y;

                            xi1 = Singleton.getInstance().getXPos();
                            yi1 = Singleton.getInstance().getYPos();

                            int i = xi, j = yi;

                            // slowly move the mouse to detined location
                            while (i != xi1 || j != yi1) {
                                // move the mouse to the other point
                                r.mouseMove(i, j);

                                if (i < xi1)
                                    i++;
                                if (j < yi1)
                                    j++;

                                if (i > xi1)
                                    i--;
                                if (j > yi1)
                                    j--;

                                // wait
                                //Thread.sleep(30);
                            }
                            Singleton.getInstance().setUpdate(false);
                        }
                    }
                } catch (Exception evt) {
                    System.err.println(evt.getMessage());
                }
            }
        }).start();

    }
}



