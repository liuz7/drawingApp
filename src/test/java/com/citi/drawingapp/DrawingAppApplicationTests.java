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
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(2).build();
        line.draw(p1, p2);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawHorizontalLineOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(21).coordinateY(2).build();
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(0);
        p1.setCoordinateY(2);
        p2.setCoordinateX(6);
        p2.setCoordinateY(2);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(1);
        p1.setCoordinateY(0);
        p2.setCoordinateX(6);
        p2.setCoordinateY(0);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(1);
        p1.setCoordinateY(21);
        p2.setCoordinateX(6);
        p2.setCoordinateY(21);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
    }

    @Test
    void testDrawLineNotSupportedException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(3).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(20).coordinateY(2).build();
        Assertions.assertThrows(NotSupportedException.class, () -> line.draw(p1, p2));
    }

    @Test
    void testDrawNoCanvasExceptionForLine() {
        Line line = new Line();
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(2).build();
        Assertions.assertThrows(NoCanvasException.class, () -> line.draw(p1, p2));
    }

    @Test
    void testDrawNoCanvasExceptionForRectangle() {
        Rectangle rectangle = new Rectangle();
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(16).coordinateY(1).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(20).coordinateY(3).build();
        Assertions.assertThrows(NoCanvasException.class, () -> rectangle.draw(p1, p2));
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
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(2).build();
        line.draw(p1, p2);
        p1.setCoordinateX(6);
        p1.setCoordinateY(3);
        p2.setCoordinateX(6);
        p2.setCoordinateY(4);
        line.draw(p1, p2);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawVerticalLineOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Line line = new Line(canvas);
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(6).coordinateY(3).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(5).build();
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(6);
        p1.setCoordinateY(0);
        p2.setCoordinateX(6);
        p2.setCoordinateY(4);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(0);
        p1.setCoordinateY(3);
        p2.setCoordinateX(0);
        p2.setCoordinateY(4);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
        p1.setCoordinateX(21);
        p1.setCoordinateY(3);
        p2.setCoordinateX(21);
        p2.setCoordinateY(4);
        Assertions.assertThrows(OutOfCanvasException.class, () -> line.draw(p1, p2));
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
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(2).build();
        line.draw(p1, p2);
        p1.setCoordinateX(6);
        p1.setCoordinateY(3);
        p2.setCoordinateX(6);
        p2.setCoordinateY(4);
        line.draw(p1, p2);
        Rectangle rectangle = new Rectangle(canvas);
        p1.setCoordinateX(16);
        p1.setCoordinateY(1);
        p2.setCoordinateX(20);
        p2.setCoordinateY(3);
        rectangle.draw(p1, p2);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

    @Test
    void testDrawRectangleOutOfCanvasException() {
        ShapeArgument p = ShapeArgument.builder().width(20).height(4).build();
        canvas.draw(p);
        Rectangle rectangle = new Rectangle(canvas);
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(16).coordinateY(1).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(20).coordinateY(5).build();
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(p1, p2));
        p1.setCoordinateX(16);
        p1.setCoordinateY(1);
        p2.setCoordinateX(21);
        p2.setCoordinateY(3);
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(p1, p2));
        p1.setCoordinateX(0);
        p1.setCoordinateY(1);
        p2.setCoordinateX(20);
        p2.setCoordinateY(3);
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(p1, p2));
        p1.setCoordinateX(16);
        p1.setCoordinateY(0);
        p2.setCoordinateX(20);
        p2.setCoordinateY(3);
        Assertions.assertThrows(OutOfCanvasException.class, () -> rectangle.draw(p1, p2));
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
        ShapeArgument p1 = ShapeArgument.builder().coordinateX(1).coordinateY(2).build();
        ShapeArgument p2 = ShapeArgument.builder().coordinateX(6).coordinateY(2).build();
        line.draw(p1, p2);
        p1.setCoordinateX(5);
        p1.setCoordinateY(1);
        p2.setCoordinateX(5);
        p2.setCoordinateY(4);
        line.draw(p1, p2);
        Rectangle rectangle = new Rectangle(canvas);
        p1.setCoordinateX(16);
        p1.setCoordinateY(1);
        p2.setCoordinateX(20);
        p2.setCoordinateY(3);
        rectangle.draw(p1, p2);
        Assertions.assertNotNull(canvas);
        Assertions.assertEquals(expected, canvas.toString());
    }

}
