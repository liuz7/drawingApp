package com.citi.drawingapp.utils;

import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.Line;
import com.citi.drawingapp.model.Rectangle;
import com.citi.drawingapp.model.ShapeArgument;

import java.io.InputStreamReader;
import java.util.Arrays;
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
                    ShapeArgument[] result = coordinateArgumentHelper(arguments[1], arguments[2],
                            arguments[3], arguments[4]);
                    line.draw(result);
                } else if (arguments[0].equals(R.name()) && arguments.length == 5) {
                    Rectangle rectangle = new Rectangle(canvas);
                    ShapeArgument[] result = coordinateArgumentHelper(arguments[1], arguments[2],
                            arguments[3], arguments[4]);
                    rectangle.draw(result);
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

    public static ShapeArgument[] coordinateArgumentHelper(String... arguments) {
        int[] intArray = Arrays.stream(arguments).mapToInt(Integer::parseInt).toArray();
        return coordinateArgumentHelper(intArray);
    }

    public static ShapeArgument[] coordinateArgumentHelper(int... arguments) {
        ShapeArgument[] result = new ShapeArgument[arguments.length / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = ShapeArgument.builder()
                    .coordinateX(arguments[i * 2])
                    .coordinateY(arguments[i * 2 + 1])
                    .build();
        }
        return result;
    }
}
