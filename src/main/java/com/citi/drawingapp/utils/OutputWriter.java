package com.citi.drawingapp.utils;

public class OutputWriter {

    public static void printToConsole(char[][] data) {
        int m = data.length;
        int n = data[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 0) { // if char is null, then print space instead
                    System.out.print(' ');
                } else {
                    System.out.print(data[i][j]);
                }
            }
            System.out.println();
        }
    }
}
