package com.citi.drawingapp;

import com.citi.drawingapp.exception.NoCanvasException;
import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.Line;
import com.citi.drawingapp.model.Rectangle;
import com.citi.drawingapp.model.ShapeArgument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.citi.drawingapp.utils.CommandParser.coordinateArgumentHelper;

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
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawCanvasWithNegativeWidthAndHeight() {
        ShapeArgument p = ShapeArgument.builder().width(-1).height(-1).build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> canvas.draw(p));
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
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        line.draw(coordinateArgumentHelper(1, 2, 6, 2));
        Assertions.assertNotNull(line);
        Assertions.assertEquals(expected, line.toString());
    }

    @Test
    void testDrawHorizontalLineOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(1, 2, 21, 2)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(0, 2, 6, 2)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(1, 0, 6, 0)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(1, 21, 6, 21)));
    }

    @Test
    void testDrawLineNotSupportedException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        Assertions.assertThrows(NotSupportedException.class, () -> line.draw(coordinateArgumentHelper(1, 3, 20, 2)));
    }

    @Test
    void testDrawNoCanvasExceptionForLine() {
        Line line = new Line();
        Assertions.assertThrows(NoCanvasException.class, () -> line.draw(coordinateArgumentHelper(1, 2, 6, 2)));
    }

    @Test
    void testDrawNoCanvasExceptionForRectangle() {
        Rectangle rectangle = new Rectangle();
        Assertions.assertThrows(NoCanvasException.class, () -> rectangle.draw(coordinateArgumentHelper(16, 1, 20, 3)));
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
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        line.draw(coordinateArgumentHelper(1, 2, 6, 2));
        line.draw(coordinateArgumentHelper(6, 3, 6, 4));
        Assertions.assertNotNull(line);
        Assertions.assertEquals(expected, line.toString());
    }

    @Test
    void testDrawVerticalLineOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(6, 3, 6, 5)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(6, 0, 6, 4)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(0, 3, 0, 4)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(coordinateArgumentHelper(21, 3, 21, 4)));
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
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        line.draw(coordinateArgumentHelper(1, 2, 6, 2));
        line.draw(coordinateArgumentHelper(6, 3, 6, 4));
        Rectangle rectangle = new Rectangle(canvas);
        rectangle.draw(coordinateArgumentHelper(16, 1, 20, 3));
        Assertions.assertNotNull(rectangle);
        Assertions.assertEquals(expected, rectangle.toString());
    }

    @Test
    void testDrawRectangleOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Rectangle rectangle = new Rectangle(canvas);
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(coordinateArgumentHelper(16, 1, 20, 5)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(coordinateArgumentHelper(16, 1, 21, 3)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(coordinateArgumentHelper(0, 1, 20, 3)));
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(coordinateArgumentHelper(16, 0, 20, 3)));
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
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        line.draw(coordinateArgumentHelper(1, 2, 6, 2));
        line.draw(coordinateArgumentHelper(5, 1, 5, 4));
        Rectangle rectangle = new Rectangle(canvas);
        rectangle.draw(coordinateArgumentHelper(16, 1, 20, 3));
        Assertions.assertNotNull(rectangle);
        Assertions.assertEquals(expected, rectangle.toString());
    }

}
