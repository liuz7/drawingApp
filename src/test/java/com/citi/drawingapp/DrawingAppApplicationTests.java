package com.citi.drawingapp;

import com.citi.drawingapp.exception.NoCanvasException;
import com.citi.drawingapp.exception.OutOfCanvasException;
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
    void testDrawCanvasWithNegativeWidthAndHeight() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> canvas.draw(-1, -1));
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
    void testDrawHorizontalLineOutOfCanvasException() {
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(1, 2, 21, 2));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(0, 2, 6, 2));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(1, 0, 6, 0));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(1, 21, 6, 21));
    }

    @Test
    void testDrawLineNotSupportedException() {
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(1, 3, 21, 2));
    }

    @Test
    void testDrawNoCanvasException() {
        Line line = new Line();
        line.setCanvas(canvas);
        Assertions.assertThrows(NoCanvasException.class, () -> line.draw(1, 2, 6, 2));
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
    void testDrawVerticalLineOutOfCanvasException() {
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(6, 3, 6, 5));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(6, 0, 6, 4));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(0, 3, 0, 4));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(21, 3, 21, 4));
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

    @Test
    void testDrawRectangleOutOfCanvasException() {
        canvas.draw(20, 4);
        Rectangle rectangle = new Rectangle();
        rectangle.setCanvas(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(16, 1, 20, 5));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(16, 1, 21, 3));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(0, 1, 20, 3));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(16, 0, 20, 3));
    }

    @Test
    void testDrawInteraction() {
        String expected = """
                ----------------------
                |    X          XXXXX|
                |XXXXXX         X   X|
                |    X          XXXXX|
                |    X               |
                ----------------------""";
        canvas.draw(20, 4);
        Line line = new Line();
        line.setCanvas(canvas);
        line.draw(1, 2, 6, 2);
        line.draw(5, 1, 5, 4);
        Rectangle rectangle = new Rectangle();
        rectangle.setCanvas(canvas);
        rectangle.draw(16, 1, 20, 3);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

}
