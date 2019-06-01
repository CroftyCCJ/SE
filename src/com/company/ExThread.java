package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ExThread extends Thread implements Runnable {

    private String command;

    public ExThread (String command){

        this.command = command;
    }

    @Override
    public void run() {

        try {
            createProcess(); // Original createProcess method from TestProcessBuilder
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createProcess() throws IOException {
        List<String> input = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(command);
        while (tokenizer.hasMoreTokens()) {
            input.add(tokenizer.nextToken());
        }
        ProcessBuilder pb = new ProcessBuilder(input);
        // ProcessBuilder creates a process corresponding to the input command
        // now start the process
        BufferedReader br = null;

        try {
            Process proc = pb.start();
            // obtain the input and output streams
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            // read what the process returned
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException ioe) {
            System.err.println("Error");
            System.err.println(ioe);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
