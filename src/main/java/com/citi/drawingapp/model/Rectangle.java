package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.utils.OutputWriter;
import com.citi.drawingapp.validation.CheckArgumentSize;
import com.citi.drawingapp.validation.CheckCanvas;
import lombok.Data;

import static com.citi.drawingapp.enums.ShapeType.R;

@Data
public class Rectangle implements ShapeInterface {

    private Canvas canvas;

    private final static char SHAPE_SEP = 'X';

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
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(R, this.canvas, plist);
        int x1 = plist[0].getCoordinateX();
        int y1 = plist[0].getCoordinateY();
        int x2 = plist[1].getCoordinateX();
        int y2 = plist[1].getCoordinateY();
        char[][] data = this.canvas.getData();
        //draw the top and bottom line
        for (int i = x1; i <= x2; i++) {
            data[y1][i] = SHAPE_SEP;
            data[y2][i] = SHAPE_SEP;
        }
        //draw the left and right line
        for (int j = y1; j <= y2; j++) {
            data[j][x1] = SHAPE_SEP;
            data[j][x2] = SHAPE_SEP;
        }
        OutputWriter.printToConsole(data);
    }
}
