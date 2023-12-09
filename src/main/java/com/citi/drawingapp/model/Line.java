package com.citi.drawingapp.model;

import com.citi.drawingapp.api.ShapeInterface;
import com.citi.drawingapp.enums.ShapeType;
import com.citi.drawingapp.exception.NoCanvasException;
import com.citi.drawingapp.exception.NotSupportedException;
import com.citi.drawingapp.exception.OutOfCanvasException;
import com.citi.drawingapp.utils.OutputWriter;
import com.citi.drawingapp.validation.CheckArgumentSize;
import com.citi.drawingapp.validation.CheckCanvas;
import lombok.Data;

import static com.citi.drawingapp.enums.ShapeType.L;

@Data
public class Line implements ShapeInterface {

    private Canvas canvas;

    private final static char SHAPE_SEP = 'X';

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
        new CheckArgumentSize().linkWith(new CheckCanvas()).validate(L, this.canvas, plist);
        int x1 = plist[0].getCoordinateX();
        int y1 = plist[0].getCoordinateY();
        int x2 = plist[1].getCoordinateX();
        int y2 = plist[1].getCoordinateY();
        char[][] data = this.canvas.getData();
        if (y1 == y2) { //draw the horizontal line
            for (int i = x1; i <= x2; i++) {
                data[y1][i] = SHAPE_SEP;
            }
        } else if (x1 == x2) { //draw the vertical line
            for (int j = y1; j <= y2; j++) {
                data[j][x1] = SHAPE_SEP;
            }
        } else {
            throw new NotSupportedException("This type of line drawing is not supported");
        }
        OutputWriter.printToConsole(data);
    }
}
