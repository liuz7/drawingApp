package com.citi.drawingapp.api.factory;

import com.citi.drawingapp.enums.ShapeType;
import com.citi.drawingapp.model.*;

public class ShapeFactory {

    public Shape createShape(ShapeType shapeType) {
        switch (shapeType) {
            case C:
                return new Canvas();
            default:
                break;
        }
        return null;
    }
}
