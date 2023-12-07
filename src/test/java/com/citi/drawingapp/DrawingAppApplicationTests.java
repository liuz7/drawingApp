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
        canvas.drawCanvas(20, 4);
        Assertions.assertNotNull(canvas.toString());
    }

}
