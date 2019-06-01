package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //DBHandler.getInstance().insertIpAddress("123.2.13.21");
        Robomouse robomouse = new Robomouse();


        robomouse.mouseMoveTest();
        EchoServer es = new EchoServer();
        es.establish();
    }
}
