package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Robomouse robomouse = new Robomouse();


        robomouse.mouseMoveTest();
        EchoServer es = new EchoServer();
        es.establish();
    }
}
