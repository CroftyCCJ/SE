package com.company;


import java.awt.*;

class Robomouse extends Frame {
    // Frame
    //static JFrame f;

    // default constructor
    Robomouse() {
    }


    public void mouseMoveTest() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // object of class
                Robomouse rm = new Robomouse();


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



