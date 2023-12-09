package com.citi.drawingapp.validation;

import com.citi.drawingapp.enums.ShapeType;
import com.citi.drawingapp.exception.NoCanvasException;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.ShapeArgument;

public class CheckCanvas extends ValidationStep {

    @Override
    public boolean validate(ShapeType shapeType, Canvas canvas, ShapeArgument... plist) {
        switch (shapeType) {
            case C:
                int width = plist[0].getWidth();
                int height = plist[0].getHeight();
                if (width <= 0 || height <= 0) {
                    throw new IllegalArgumentException("Width and Height should be greater than zero");
                }
                break;
            case L, R:
                if (canvas == null || canvas.getData() == null) {
                    throw new NoCanvasException("Canvas is not found, please draw Canvas firstly");
                }
                int x1 = plist[0].getCoordinateX();
                int y1 = plist[0].getCoordinateY();
                int x2 = plist[1].getCoordinateX();
                int y2 = plist[1].getCoordinateY();
                char[][] data = canvas.getData();
                int m = data.length;
                int n = data[0].length;
                if (y1 <= 0 || y1 >= m - 1 || x1 <= 0 || x1 > n - 2 ||
                        y2 <= 0 || y2 >= m - 1 || x2 <= 0 || x2 > n - 2) {
                    throw new OutOfCanvasException("Line or Rectangle should be in canvas");
                }
                break;
            default:
                break;
        }
        return checkNext(shapeType, canvas, plist);
    }
}
