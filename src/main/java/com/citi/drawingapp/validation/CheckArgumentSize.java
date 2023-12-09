package com.citi.drawingapp.validation;

import com.citi.drawingapp.enums.ShapeType;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.ShapeArgument;

public class CheckArgumentSize extends ValidationStep {

    @Override
    public boolean validate(ShapeType shapeType, Canvas canvas, ShapeArgument... plist) {
        switch (shapeType) {
            case C:
                if (plist == null || plist.length != 1) {
                    throw new IllegalArgumentException("Argument size is incorrect for Canvas");
                }
                break;
            case L, R:
                if (plist == null || plist.length != 2) {
                    throw new IllegalArgumentException("Argument size is incorrect for Line or Rectangle");
                }
                break;
            default:
                break;
        }
        return checkNext(shapeType, canvas, plist);
    }
}
