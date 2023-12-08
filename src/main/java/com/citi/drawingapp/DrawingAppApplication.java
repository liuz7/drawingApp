package com.citi.drawingapp;

import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.Line;
import com.citi.drawingapp.model.Rectangle;

import java.io.InputStreamReader;
import java.util.Scanner;

import static com.citi.drawingapp.enums.ShapeType.*;

public class DrawingAppApplication {


    public static void main(String[] args) {
        Canvas canvas = null;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please enter draw arguments:");
            String input = scanner.nextLine();
            try {
                String[] arguments = input.trim().split(" ");
                if (arguments[0].equals(C.name()) && arguments.length == 3) {
                    canvas = new Canvas();
                    canvas.draw(Integer.valueOf(arguments[1]), Integer.valueOf(arguments[2]));
                } else if (arguments[0].equals(L.name()) && arguments.length == 5) {
                    if (canvas == null) {
                        System.out.println("Please draw canvas firstly");
                    } else {
                        Line line = new Line();
                        line.setCanvas(canvas);
                        line.draw(Integer.valueOf(arguments[1]), Integer.valueOf(arguments[2]),
                                Integer.valueOf(arguments[3]), Integer.valueOf(arguments[4]));
                    }
                } else if (arguments[0].equals(R.name()) && arguments.length == 5) {
                    if (canvas == null) {
                        System.out.println("Please draw canvas firstly");
                    } else {
                        Rectangle rectangle = new Rectangle();
                        rectangle.setCanvas(canvas);
                        rectangle.draw(Integer.valueOf(arguments[1]), Integer.valueOf(arguments[2]),
                                Integer.valueOf(arguments[3]), Integer.valueOf(arguments[4]));
                    }
                } else if (arguments[0].equalsIgnoreCase("Q")) {
                    return;
                } else {
                    throw new NotSupportedException("This shape drawing operation is not support");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
