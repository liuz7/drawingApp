package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.validation.CheckArgumentSize;
import com.citi.drawingapp.validation.CheckCanvas;
import lombok.Data;

import static com.citi.drawingapp.enums.ShapeType.L;

@Data
public class Line extends Shape implements ShapeInterface {

    private Canvas canvas;

    public Line(Canvas canvas) {
        this.canvas = canvas;
    }

    public Line() {
    }

    /**
     * Draw the Line in canvas to console
     *
     * @param plist ShapeArgument object list contains Integer value for line starting and ending points.
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(ShapeArgument... plist) {
        //validation chain
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(L, canvas, plist);
        super.drawLine(this.canvas, SHAPE_SEP, SHAPE_SEP, plist);
        super.outputToConsole(this.canvas.getData());
    }

    @Override
    public String toString() {
        return super.outputToString(this.canvas.getData());
    }
}
