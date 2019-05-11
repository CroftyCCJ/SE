package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ThreadBuilder {
    public ThreadBuilder() {
    }

    public  void createThread(String command) throws IOException {
        List<String> input = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(command);
        while (tokenizer.hasMoreTokens()) {
            input.add(tokenizer.nextToken());
        }

        ExThread exThread = new ExThread(command);
        exThread.start();
    }
/*
    public static void main(String[] args) throws IOException {
        String commandLine;
        File wd;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\n** Welcome to the Java Command Shell **");
        System.out.println("If you want to exit the shell, type END and press RETURN.\n");
        // we break out with ‘END’
        while (true) {
            // show the Java shell prompt and read what command they entered
            System.out.print("jsh>");
            commandLine = console.readLine();
            // if user entered a return, just loop again
            if (commandLine.equals("")) {
                continue;
            }
            if (commandLine.toLowerCase().equals("end")) { //User wants to end shell
                System.out.println("\n** Command Shell Terminated. See you next time. BYE for now. *\n");
                System.exit(0);
            }
            //Process the command entered by the user, by creating process
            //20 for (int i = 0; i < 5; i++) {
            createThread(commandLine);
            //}
        }
    } */
}
