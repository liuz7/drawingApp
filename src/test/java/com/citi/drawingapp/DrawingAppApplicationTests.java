package com.citi.drawingapp;

import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.Line;
import com.citi.drawingapp.model.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DrawingAppApplicationTests {

    private static Canvas canvas = null;

    @BeforeAll
    public static void init() {
        canvas = new Canvas();
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
        canvas.draw(20, 4);
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
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        line.draw(1, 2, 6, 2);
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
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        line.draw(1, 2, 6, 2);
        line.draw(6, 3, 6, 4);
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
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        line.draw(1, 2, 6, 2);
        line.draw(6, 3, 6, 4);
        Rectangle rectangle = new Rectangle();
        rectangle.setCanvas(canvas);
        rectangle.draw(16, 1, 20, 3);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

}
