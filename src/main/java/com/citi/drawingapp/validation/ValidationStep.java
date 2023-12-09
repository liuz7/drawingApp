package com.citi.drawingapp.validation;

import com.citi.drawingapp.enums.ShapeType;
import com.citi.drawingapp.model.Canvas;
import com.citi.drawingapp.model.ShapeArgument;

public abstract class ValidationStep {

    private ValidationStep next;

    public ValidationStep linkWith(ValidationStep next) {
        if (this.next == null) {
            this.next = next;
            return this;
        }
        ValidationStep lastStep = this.next;
        while (lastStep.next != null) {
            lastStep = lastStep.next;
        }
        lastStep.next = next;
        return this;
    }

    public abstract boolean validate(ShapeType shapeType, Canvas canvas, ShapeArgument... plist);

    protected boolean checkNext(ShapeType shapeType, Canvas canvas, ShapeArgument... plist) {
        if (next == null) {
            return true;
        }

        return next.validate(shapeType, canvas, plist);
    }
}
