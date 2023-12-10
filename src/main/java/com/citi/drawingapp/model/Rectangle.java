package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.validation.CheckArgumentSize;
import com.citi.drawingapp.validation.CheckCanvas;
import lombok.Data;

import static com.citi.drawingapp.enums.ShapeType.R;

@Data
public class Rectangle extends Shape implements ShapeInterface {

    private Canvas canvas;

    public Rectangle(Canvas canvas) {
        this.canvas = canvas;
    }

    public Rectangle() {
    }

    /**
     * Draw the Rectangle in canvas to console
     *
     * @param plist ShapeArgument object list contains Integer value for
     *              Rectangle upper left and bottom right points.
     * @return No return value.
     * @throws Any exception
     */
    @Override
    public void draw(ShapeArgument... plist) {
        //validation chain
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(R, canvas, plist);
        int x1 = plist[0].getCoordinateX();
        int y1 = plist[0].getCoordinateY();
        int x2 = plist[1].getCoordinateX();
        int y2 = plist[1].getCoordinateY();
        //draw the top line
        plist[1].setCoordinateY(y1);
        super.drawLine(this.canvas, SHAPE_SEP, SHAPE_SEP, plist);
        plist[1].setCoordinateY(y2);
        //draw the bottom line
        plist[0].setCoordinateY(y2);
        super.drawLine(this.canvas, SHAPE_SEP, SHAPE_SEP, plist);
        plist[0].setCoordinateY(y1);
        //draw the left line
        plist[1].setCoordinateX(x1);
        super.drawLine(this.canvas, SHAPE_SEP, SHAPE_SEP, plist);
        plist[1].setCoordinateX(x2);
        //draw the right line
        plist[0].setCoordinateX(x2);
        super.drawLine(this.canvas, SHAPE_SEP, SHAPE_SEP, plist);
        plist[0].setCoordinateX(x1);
        super.outputToConsole(this.canvas.getData());
    }
}
