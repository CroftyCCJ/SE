package com.company;

public class IntUtil {

    //parseInteger [0] = x
    //parseInteger [1] = y
    public synchronized static int[] getParsedXY(String input) {

        int[] parsedInteger = new int[2];
        String x;
        String y;
        String[] output;


        output = input.split(",");

        x = output[0].replaceAll("[^0-9]", "");
        y = output[1].replaceAll("[^0-9]", "");

        parsedInteger[0] = Integer.parseInt(x);
        parsedInteger[1] = Integer.parseInt(y);

        return parsedInteger;


    }
}
