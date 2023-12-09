package com.citi.drawingapp.utils;

import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.Line;
import com.citi.drawingapp.model.Rectangle;
import com.citi.drawingapp.model.ShapeArgument;

import java.io.InputStreamReader;
import java.util.Scanner;

import static com.citi.drawingapp.enums.ShapeType.*;

public class CommandParser {

    public static void parseCli(String[] args) {
        Canvas canvas = null;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        while (true) {
            System.out.println();
            System.out.println("Please enter draw arguments:");
            String input = scanner.nextLine();
            try {
                String[] arguments = input.trim().split(" ");
                if (arguments[0].equals(C.name()) && arguments.length == 3) {
                    canvas = new Canvas();
                    ShapeArgument p = ShapeArgument.builder()
                            .width(Integer.valueOf(arguments[1]))
                            .height(Integer.valueOf(arguments[2]))
                            .build();
                    canvas.draw(p);
                } else if (arguments[0].equals(L.name()) && arguments.length == 5) {
                    Line line = new Line(canvas);
                    ShapeArgument p1 = ShapeArgument.builder()
                            .coordinateX(Integer.valueOf(arguments[1]))
                            .coordinateY(Integer.valueOf(arguments[2]))
                            .build();
                    ShapeArgument p2 = ShapeArgument.builder()
                            .coordinateX(Integer.valueOf(arguments[3]))
                            .coordinateY(Integer.valueOf(arguments[4]))
                            .build();
                    line.draw(p1, p2);
                } else if (arguments[0].equals(R.name()) && arguments.length == 5) {
                    Rectangle rectangle = new Rectangle(canvas);
                    ShapeArgument p1 = ShapeArgument.builder()
                            .coordinateX(Integer.valueOf(arguments[1]))
                            .coordinateY(Integer.valueOf(arguments[2]))
                            .build();
                    ShapeArgument p2 = ShapeArgument.builder()
                            .coordinateX(Integer.valueOf(arguments[3]))
                            .coordinateY(Integer.valueOf(arguments[4]))
                            .build();
                    rectangle.draw(p1, p2);
                } else if (arguments[0].equalsIgnoreCase("Q")) {
                    scanner.close();
                    System.out.println("App quited");
                    return;
                } else {
                    throw new NotSupportedException("This shape drawing command is not support");
                }
            } catch (Exception e) {
                String errorMessage = e.getMessage() == null ? "Some error found" : e.getMessage();
                System.out.println(errorMessage);
            }
        }
    }
}
