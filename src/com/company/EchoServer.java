package com.company;

import java.io.*;
import java.net.*;

public class EchoServer {

    Robomouse robomouse;
    public EchoServer() {
        robomouse = new Robomouse();
    }

    public void establish() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 1234");
            System.exit(-1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 1234");
            System.exit(-1);
        }
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ioe) {
            System.out.println("Failed in creating streams");
            System.exit(-1);
        }
        String inputLine, outputLine;
        try {
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                String s = inputLine;
                System.out.println(inputLine);
                ThreadBuilder tb = new ThreadBuilder();
                //tb.createThread(inputLine);
                Singleton.getInstance().setXpos(Integer.parseInt(s));
                Singleton.getInstance().setYpos(Integer.parseInt(s));
                robomouse.ini();

                if (inputLine.equals("Bye.")) break;
            }
        } catch (IOException ioe) {
            System.out.println("Failed in reading, writing");
            System.exit(-1);
        }
        try {
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Could not close");
            System.exit(-1);
        }
    }
}