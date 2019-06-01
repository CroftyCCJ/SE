package com.company;

import com.company.Database.DBHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {



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
        System.out.println("New Client Connected: " + clientSocket.getInetAddress().getHostAddress());
        DBHandler.getInstance().insertIpAddress(clientSocket.getInetAddress().getHostAddress());
        try {
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
                String s = inputLine;
                System.out.println(inputLine);
                ThreadBuilder tb = new ThreadBuilder();

                if (inputLine.startsWith("-")) {

                    int[] pointerValues;

                    String inputValue = inputLine.replace("-", "");

                    pointerValues = IntUtil.getParsedXY(inputValue);


                    Singleton.getInstance().setXPos(pointerValues[0]);
                    Singleton.getInstance().setYPos(pointerValues[1]);
                    Singleton.getInstance().setUpdate(true);
                } else {
                    tb.createThread(inputLine);
                }


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