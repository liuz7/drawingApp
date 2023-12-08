package com.citi.drawingapp;

import com.citi.drawingapp.api.factory.ShapeFactory;
import com.citi.drawingapp.model.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.citi.drawingapp.enums.ShapeType.C;

class DrawingAppApplicationTests {

    private static Shape canvas = null;

    @BeforeAll
    public static void init() {
        ShapeFactory shapeFactory = new ShapeFactory();
        canvas = shapeFactory.createShape(C);
    }

    @Test
    void testDrawCanvas() {
        String expected = """
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------""";
        canvas.drawCanvas(20, 4);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawHorizontalLine() {
        String expected = """
                ----------------------
                |                    |
                |XXXXXX              |
                |                    |
                |                    |
                ----------------------""";
        canvas.drawCanvas(20, 4);
        canvas.drawLine(1, 2, 6, 2);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawVerticalLine() {
        String expected = """
                ----------------------
                |                    |
                |XXXXXX              |
                |     X              |
                |     X              |
                ----------------------""";
        canvas.drawCanvas(20, 4);
        canvas.drawLine(1, 2, 6, 2);
        canvas.drawLine(6, 3, 6, 4);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawRectangle() {
        String expected = """
                ----------------------
                |               XXXXX|
                |XXXXXX         X   X|
                |     X         XXXXX|
                |     X              |
                ----------------------""";
        canvas.drawCanvas(20, 4);
        canvas.drawLine(1, 2, 6, 2);
        canvas.drawLine(6, 3, 6, 4);
        canvas.drawRectangle(16, 1, 20, 3);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

}
